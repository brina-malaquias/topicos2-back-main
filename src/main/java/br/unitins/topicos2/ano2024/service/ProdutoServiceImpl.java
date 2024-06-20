package br.unitins.topicos2.ano2024.service;


import br.unitins.projeto.repository.ItemCompraRepository;
import br.unitins.topicos2.ano2024.dto.produto.ProdutoDTO;
import br.unitins.topicos2.ano2024.dto.produto.ProdutoResponseDTO;
import br.unitins.topicos2.ano2024.form.ProdutoImageForm;
import br.unitins.topicos2.ano2024.model.produto.Produto;
import br.unitins.topicos2.ano2024.repository.ProdutoRepository;
import br.unitins.topicos2.ano2024.service.file.FileService;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

import java.io.IOException;
import java.io.NotActiveException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

    @Inject
    ProdutoRepository repository;


    @Inject
    ItemCompraRepository itemCompraRepository;

    @Inject
    Validator validator;

    @Inject
    FileService fileService;

    @Override
    public List<ProdutoResponseDTO> getAll() {
        List<Produto> list = repository.listAll();
        return list.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public ProdutoResponseDTO findById(Long id) {
        Produto produto = repository.findById(id);

        if (produto == null)
            throw new NotFoundException("Produto não encontrado.");

        return new ProdutoResponseDTO(produto);
    }

    @Override
    @Transactional
    public ProdutoResponseDTO create(@Valid ProdutoDTO produtoDto) throws ConstraintViolationException {

        Produto entity = new Produto();
        entity.setNome(produtoDto.nome());
        entity.setDescricao(produtoDto.descricao());
        entity.setEstoque(produtoDto.estoque());
        entity.setAtivo(Boolean.TRUE);
        entity.setValor(produtoDto.valor());

        repository.persist(entity);
        return new ProdutoResponseDTO(entity);
    }

    @Override
    @Transactional
    public ProdutoResponseDTO update(Long id, @Valid ProdutoDTO produtoDto) throws ConstraintViolationException {

        Produto entity = repository.findById(id);

        if (entity == null){
            throw new NotFoundException("Produto não encontrado");
        }

        entity.setNome(produtoDto.nome());
        entity.setDescricao(produtoDto.descricao());
        entity.setEstoque(produtoDto.estoque());
        entity.setValor(produtoDto.valor());
        entity.setAtivo(entity.getAtivo());

        repository.persist(entity);

        return new ProdutoResponseDTO(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProdutoResponseDTO> findByNome(String nome, Boolean ativo, int pageNumber, int pageSize) {
        List<Produto> list = this.repository.findByFiltro(nome, ativo)
                .page(Page.of(pageNumber, pageSize))
                .list().stream()
                .sorted(Comparator.comparing(Produto::getNome))
                .collect(Collectors.toList());

        return list.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProdutoResponseDTO alterarSituacao(Long id, Boolean dto) {
        Produto entity = repository.findById(id);
        entity.setAtivo(dto);

        return new ProdutoResponseDTO(entity);
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<ProdutoResponseDTO> findAllPaginado(int pageNumber, int pageSize) {
        List<Produto> lista = this.repository.findAll()
                .page(Page.of(pageNumber, pageSize))
                .list();

        return lista.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public Long countByNome(String nome, Boolean ativo) {
        return repository.findByFiltro(nome, ativo).count();
    }

    @Override
    @Transactional
    public void salvarImagens(ProdutoImageForm imagem) throws IOException {
        Produto produto = repository.findById(imagem.getId());

        if (produto == null) {
            throw new NotActiveException("Produto não encontrado");
        }

        try {
            String novoNomeImagem = fileService.salvarImagem(imagem.getImagem(), imagem.getNomeImagem(), "produto");
            String imagemAntiga = produto.getNomeImagem();
            produto.setNomeImagem(novoNomeImagem);

            fileService.excluirImagem(imagemAntiga, "produto");
        } catch (IOException e) {
            throw e;
        }
    }


    /*
    @Override
    public byte[] criarRelatorioProduto() {

        List<Produto> lista = repository.findAll().list();
        return gerarRelatorioPDF(lista);
    }

    private byte[] gerarRelatorioPDF(List<Produto> produtos){

         // Crie um ByteArrayOutputStream para armazenar o PDF resultante
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Crie um documento PDF usando o iText7
        try (PdfDocument pdfDocument = new PdfDocument(new PdfWriter(baos))) {
            
            Document document = new Document(pdfDocument, PageSize.A4);
            pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, new HeaderFooterHandler());

            // Adicione um cabeçalho ao PDF
            // Image logo = new Image(ImageDataFactory.create("caminho/para/sua/logo.png"));
            // document.add(logo);


            // Adicione um título e um subtítulo
            Paragraph titulo = new Paragraph("Relatório de Produtos")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(22);
                
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"));
            Paragraph subtitulo = new Paragraph("Gerado em: " + dataHora)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12);
            document.add(titulo);
            document.add(subtitulo);

            // Adicione a tabela com os itens
            Table tabela = new Table(new float[]{1, 1, 1, 1, 1})
                    .setWidth(UnitValue.createPercentValue(100))
                    .setMarginTop(10);
            tabela.addHeaderCell("ID");
            tabela.addHeaderCell("Nome");
            tabela.addHeaderCell("Preço");
            tabela.addHeaderCell("Vendas");
            tabela.addHeaderCell("Total");



            for (Produto produto : produtos) {
                int vendas = 0;
                
                if (itemCompraRepository.findByProduto(produto.getId()).size() == 0) {
                    vendas = 0;
                }
                else{
                    vendas =  itemCompraRepository.findByProduto(produto.getId()).size() ;
                }
                
                double lucro = vendas * produto.getPreco();
                
                tabela.addCell(String.valueOf(produto.getId()));
                tabela.addCell(produto.getNome());
                tabela.addCell(String.valueOf(produto.getPreco()));
                tabela.addCell(String.valueOf(vendas));
                tabela.addCell(String.valueOf(lucro)+ " reais");
            }

            document.add(tabela);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }


    class HeaderFooterHandler implements IEventHandler {
        public void handleEvent(Event event) {
            PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
            PdfDocument pdf = docEvent.getDocument();
            PdfPage page = docEvent.getPage();
            int pageNum = pdf.getPageNumber(page);

            PdfCanvas canvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdf);
            canvas.beginText().setFontAndSize(pdf.getDefaultFont(), 12);
            
            canvas.moveText(34, 20).showText("Página "+ pageNum);

            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss"));
            canvas.moveText(500 - 80, 0).showText(dataHora);

            canvas.endText();
                  
        }
    }
    */
}
