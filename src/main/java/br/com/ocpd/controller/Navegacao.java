package br.com.ocpd.controller;

public class Navegacao {

    protected enum PaginaEnum {
        LOGIN("login.jsf"),
        CAD_USUARIO("cadastro_usuario.jsf"),
        RECUPERAR_SENHA("recuperar_senha.jsf"),
        DASHBOARD("dashboard.jsf"),
        INDEX("index.jsf"),
        Z(".jsf"),
        ZZ("");

        private String pagina;

        PaginaEnum(String pagina) {
            this.pagina = pagina;
        }

        public String getPagina() {
            return pagina;
        }
    }
}
