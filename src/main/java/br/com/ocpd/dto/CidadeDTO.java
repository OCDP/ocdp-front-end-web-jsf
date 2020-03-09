package br.com.ocpd.dto;

import org.json.JSONObject;

public class CidadeDTO extends TransferObject {

    private String nome;

    public CidadeDTO(JSONObject obj) {
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

