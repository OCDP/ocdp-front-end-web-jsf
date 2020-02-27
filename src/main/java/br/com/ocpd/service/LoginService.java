package br.com.ocpd.service;

import br.com.ocpd.to.UsuarioTO;

public class LoginService {

    public UsuarioTO logar(UsuarioTO usuarioTO) {
        /**
         * implementar aqui call API
         */
        usuarioTO.setStatus("Ativo");
        usuarioTO.setNome("Dáurio Filho");
        return usuarioTO;
    }
}
