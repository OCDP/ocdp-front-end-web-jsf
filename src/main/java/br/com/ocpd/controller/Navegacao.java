package br.com.ocpd.controller;

public class Navegacao {

    protected enum PaginaEnum {
        LOGIN("login.jsf"),
        CAD_USUARIO("cadastro_usuario.jsf"),
        RECUPERAR_SENHA("recuperar_senha.jsf"),
        DASHBOARD("dashboard.jsf"),
        INDEX("index.jsf"),
        BAIRRO("bairro.jsf"),
        CIDADE("cidade.jsf"),
        DISTRITO("distrito.jsf"),
        LESAO("lesao.jsf"),
        LOCAL_ATENDIUMENTO("local_atendimento.jsf"),
        TIPO_LESAO("tipo_lesao.jsf"),
        TIPO_LOCAL_ATENDIMENTO("tipo_local_atendimento.jsf"),
        USUARIOS("usuarios.jsf");

        private String pagina;

        PaginaEnum(String pagina) {
            this.pagina = pagina;
        }

        public String getPagina() {
            return pagina;
        }
    }
}
