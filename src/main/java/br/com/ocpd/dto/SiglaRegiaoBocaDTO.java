package br.com.ocpd.dto;

import org.json.JSONObject;

public class SiglaRegiaoBocaDTO extends TransferObject {
    private String nome;
    private String imagemBase64;

    public SiglaRegiaoBocaDTO(JSONObject obj) {
        super(obj);
        this.nome = obj.get("nome").toString();
        this.imagemBase64 = obj.get("imagemBase64").toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }
}
