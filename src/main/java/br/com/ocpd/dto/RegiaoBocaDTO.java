package br.com.ocpd.dto;

import org.json.JSONObject;

public class RegiaoBocaDTO extends TransferObject {


    private String nome;
    private SiglaRegiaoBocaDTO siglaRegiaoBoca;



    public RegiaoBocaDTO(JSONObject obj) {
        super(obj);
        this.nome =  obj.get("nome").toString();
        this.siglaRegiaoBoca = new SiglaRegiaoBocaDTO(new JSONObject(obj.get("siglaRegiaoBoca").toString()));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SiglaRegiaoBocaDTO getSiglaRegiaoBoca() {
        return siglaRegiaoBoca;
    }

    public void setSiglaRegiaoBoca(SiglaRegiaoBocaDTO siglaRegiaoBoca) {
        this.siglaRegiaoBoca = siglaRegiaoBoca;
    }
}
