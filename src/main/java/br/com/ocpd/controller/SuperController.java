package br.com.ocpd.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "SuperController")
@SessionScoped
public class SuperController {

    public static void showMessageGrowView(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message, ""));
    }
}
