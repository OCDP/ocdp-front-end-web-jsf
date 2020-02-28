package br.com.ocpd.controller;

import br.com.ocpd.to.UsuarioTO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ManagedBean(name = "SuperController")
@SessionScoped
public class SuperController extends Navegacao {
    public static final String USUARIO_LOGADO = "USUARIO_LOGADO";

    public static void showNegrito(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message, ""));
    }

    public static void show(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("", message));
    }

    public static void ok(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", message));
    }

    public static void aviso(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertência: ", message));
    }

    public static void erro(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: ", message));
    }

    public static void fatal(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro Fatal: ", message));
    }

    public void colocarObjetoNaSessao(String key, Object obj) {
        ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession().setAttribute(key, obj);
    }

    public void removerObjetoDaSessao(String key) {
        ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession().removeAttribute(key);
    }

    public Object pegarObjetoDaSessao(String key) {
        return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession().getAttribute(key);
    }

    public UsuarioTO getUsuarioLogado() {
        return (UsuarioTO) ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession().getAttribute(USUARIO_LOGADO);
    }

    public void redireciona(paginaEnum pagina) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(pagina.getPagina());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void validaSessaoUsuario() {
        if (null == pegarObjetoDaSessao(USUARIO_LOGADO)) {
            redireciona(paginaEnum.LOGIN);
        }
    }
}
