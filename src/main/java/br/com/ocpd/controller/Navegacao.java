package br.com.ocpd.controller;

public class Navegacao {

    protected enum paginaEnum {
        CADASTRO_USUARIO("cadastro_usuario.jsf"),
        DASHBOARD("dashboard.jsf"),
        INDEX("index.jsf"),
        LOGIN("login.jsf"),
        RECUPERAR_SENHA("recuperar_senha.jsf"),
        Z("");

        private String pagina;

        paginaEnum(String pagina) {
            this.pagina = pagina;
        }

        public String getPagina() {
            return pagina;
        }
    }
}
