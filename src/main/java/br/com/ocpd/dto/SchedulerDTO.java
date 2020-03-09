package br.com.ocpd.dto;

import org.json.JSONObject;

public class SchedulerDTO extends TransferObject {

    private String chave;
    private String valor;

    public SchedulerDTO(JSONObject obj) {
        super(obj);
        this.chave = obj.get("chave").toString();
        this.valor = obj.get("valor").toString();
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
