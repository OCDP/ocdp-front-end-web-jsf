package br.com.ocpd.controller;

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

    public void logar() {
        System.out.println(getUsuarioTO().getCpf());
        System.out.println(getUsuarioTO().getSenha());
        showMessageGrowView("Logou");
    }

    public UsuarioTO getUsuarioTO() {
        if (null == this.usuarioTO)
            this.usuarioTO = new UsuarioTO();
        return this.usuarioTO;
    }

    public void setUsuarioTO(UsuarioTO usuarioTO) {
        this.usuarioTO = usuarioTO;
    }

    public String getAno() {
        return Utilitaria.anoAtual();
    }
}
