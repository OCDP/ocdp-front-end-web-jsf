package br.com.ocpd.dto;

import com.google.gson.JsonObject;

public class TipoLocalAtendimentoDTO extends TransferObject {
    private String nome;

    public TipoLocalAtendimentoDTO(JsonObject obj) {
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
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
