package br.com.ocpd.dto;

import org.json.JSONObject;

public class LesaoDTO extends TransferObject {

    private String nome;

    public LesaoDTO(JSONObject obj) {
        super(obj);
        this.nome = obj.get("nome").toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
