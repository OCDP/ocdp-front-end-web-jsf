package br.com.ocpd.dto;

import com.google.gson.JsonObject;
import org.json.JSONObject;

public class FatorDeRiscoDTO extends TransferObject {
    private String nome;

    public FatorDeRiscoDTO(JSONObject obj) {
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
