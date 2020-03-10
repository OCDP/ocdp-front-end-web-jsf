package br.com.ocpd.controller;

import br.com.ocpd.service.LoginService;
import br.com.ocpd.dto.UsuarioDTO;
import br.com.ocpd.util.Utilitaria;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "LoginController")
@SessionScoped
public class LoginController extends SuperController {
    private UsuarioDTO usuarioDTO;
    private UsuarioDTO novoUsuarioDTO;
    private LoginService loginService;
    private boolean lembrarSenha;

    public void logar() {
        if (!Utilitaria.validaCpf(getUsuarioDTO().getCpf())) {
            aviso("Informe um CPF válido!");
            return;
        }
        if (!Utilitaria.validaTextoPreenchido(getUsuarioDTO().getSenha())) {
            aviso("Informe sua senha!");
            return;
        }
        setUsuarioDTO(getLoginService().logar(getUsuarioDTO()));
        if (null != getUsuarioDTO().getStatus()) {
            colocarObjetoNaSessao(USUARIO_LOGADO, getUsuarioDTO());
            redireciona(PaginaEnum.INDEX);
        }
    }

    public void sair() {
        setUsuarioDTO(null);
        removerObjetoDaSessao(USUARIO_LOGADO);
        redireciona(PaginaEnum.LOGIN);
    }

    public void recuperarSenha() {
        getLoginService().recuperarSenha(getUsuarioDTO());
    }

    public void gravarNovoUsuario() {
        getLoginService().gravarNovoUsuario(getNovoUsuarioDTO());
    }

    public String getAno() {
        return Utilitaria.anoAtual();
    }

    public UsuarioDTO getUsuarioDTO() {
        if (null == this.usuarioDTO)
            this.usuarioDTO = new UsuarioDTO();
        return this.usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }


    public LoginService getLoginService() {
        if (null == loginService)
            loginService = new LoginService();
        return loginService;
    }

    public UsuarioDTO getNovoUsuarioDTO() {
        return novoUsuarioDTO;
    }

    public void setNovoUsuarioDTO(UsuarioDTO novoUsuarioDTO) {
        this.novoUsuarioDTO = novoUsuarioDTO;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public boolean isLembrarSenha() {
        return lembrarSenha;
    }

    public void setLembrarSenha(boolean lembrarSenha) {
        this.lembrarSenha = lembrarSenha;
    }
}
