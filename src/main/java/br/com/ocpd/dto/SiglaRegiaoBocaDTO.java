package br.com.ocpd.dto;

import com.google.gson.JsonObject;

public class SiglaRegiaoBocaDTO extends TransferObject {
    private String nome;
    private String imagemBase64;

    public SiglaRegiaoBocaDTO(JsonObject obj) {
        try {
            if (obj.get("id").getAsLong() > 0) {
                super.setId(obj.get("id").getAsLong());
            } else {
                super.setId(0L);
            }
        } catch (Exception e) {
            e.printStackTrace();
            super.setId(0L);
        }
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
