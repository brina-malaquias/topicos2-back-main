package br.unitins.projeto.service.compra;

import br.unitins.projeto.dto.metodo.pagamento.boleto.BoletoResponseDTO;
import br.unitins.projeto.dto.compra.CompraDTO;
import br.unitins.projeto.dto.compra.CompraResponseDTO;
import br.unitins.projeto.dto.compra.StatusCompraDTO;
import br.unitins.projeto.dto.historico_entrega.HistoricoEntregaDTO;
import br.unitins.projeto.dto.historico_entrega.HistoricoEntregaResponseDTO;
import br.unitins.projeto.dto.metodo.pagamento.pix.PixResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface CompraService {

    List<CompraResponseDTO> getAll();

    CompraResponseDTO findById(Long id);

    CompraResponseDTO create(@Valid CompraDTO dto, Long idUsuario);

    CompraResponseDTO alterStatusCompra(Long idCompra, @Valid StatusCompraDTO dto);

    List<CompraResponseDTO> findByUsuario(Long idUsuario);

    List<HistoricoEntregaResponseDTO> getHistoricoEntrega(Long idCompra);

    HistoricoEntregaResponseDTO insertHistoricoEntrega(Long idCompra, @Valid HistoricoEntregaDTO dto);

    BoletoResponseDTO pagarPorBoleto(Long idCompra);

    PixResponseDTO pagarPorPix(Long idCompra);

    BoletoResponseDTO getBoleto(Long idCompra);

    PixResponseDTO getPix(Long idCompra);

    List<CompraResponseDTO> findAllByUsuario(Long idUsuario, int pageNumber, int pageSize);

}
