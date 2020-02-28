package br.com.ocpd.controller;

import br.com.ocpd.service.LoginService;
import br.com.ocpd.to.UsuarioTO;
import br.com.ocpd.util.Utilitaria;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean(name = "LoginController")
@SessionScoped
public class LoginController extends SuperController {
    private UsuarioTO usuarioTO;
    private UsuarioTO novoUsuarioTO;
    private LoginService loginService;

    public void logar() {
        if (!validaCpf()) {
            aviso("Informe um CPF válido!");
            return;
        }
        if (!validaSenha()) {
            aviso("Informe sua senha!");
            return;
        }
        setUsuarioTO(getLoginService().logar(getUsuarioTO()));
        if (null != getUsuarioTO().getStatus()) {
            colocarObjetoNaSessao(USUARIO_LOGADO, getUsuarioTO());
            redireciona(paginaEnum.INDEX);
        }
    }

    private boolean validaCpf() {
        return Utilitaria.validaTextoPreenchido(getUsuarioTO().getCpf()) && getUsuarioTO().getCpf().trim().length() == 11;
    }

    private boolean validaSenha() {
        return Utilitaria.validaTextoPreenchido(getUsuarioTO().getSenha());
    }

    public void sair() {
        setUsuarioTO(null);
        removerObjetoDaSessao(USUARIO_LOGADO);
        redireciona(paginaEnum.LOGIN);
    }

    public void recuperarSenha() {
        getLoginService().recuperarSenha(getUsuarioTO());
    }

    public void gravarNovoUsuario() {
        getLoginService().gravarNovoUsuario(getNovoUsuarioTO());
    }

    public String getAno() {
        return Utilitaria.anoAtual();
    }

    public UsuarioTO getUsuarioTO() {
        if (null == this.usuarioTO)
            this.usuarioTO = new UsuarioTO();
        return this.usuarioTO;
    }

    public void setUsuarioTO(UsuarioTO usuarioTO) {
        this.usuarioTO = usuarioTO;
    }


    public LoginService getLoginService() {
        if (null == loginService)
            loginService = new LoginService();
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public UsuarioTO getNovoUsuarioTO() {
        return novoUsuarioTO;
    }

    public void setNovoUsuarioTO(UsuarioTO novoUsuarioTO) {
        this.novoUsuarioTO = novoUsuarioTO;
    }
}
