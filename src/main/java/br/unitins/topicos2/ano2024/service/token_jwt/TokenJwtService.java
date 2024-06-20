package br.unitins.topicos2.ano2024.service.token_jwt;

import br.unitins.topicos2.ano2024.model.usuario.Usuario;

public interface TokenJwtService {
    public String generateJwt(Usuario usuario);
}
