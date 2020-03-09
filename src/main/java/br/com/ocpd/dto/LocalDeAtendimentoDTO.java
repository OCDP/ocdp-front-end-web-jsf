package br.com.ocpd.dto;


import org.json.JSONObject;

public class LocalDeAtendimentoDTO extends TransferObject {

    private DistritoDTO distrito;
    private String emailResponsavel;
    private String nome;
    private String nomeResponsavel;
    private TipoLocalAtendimentoDTO tipoLocalAtendimento;

    public LocalDeAtendimentoDTO(JSONObject obj) {
        super(obj);
        this.distrito = new DistritoDTO(new JSONObject(obj.get("distrito").toString()));
        this.emailResponsavel = obj.get("emailResponsavel").toString();
        this.nome = obj.get("nome").toString();
        this.nomeResponsavel = obj.get("nomeResponsavel").toString();
        this.tipoLocalAtendimento = new TipoLocalAtendimentoDTO(new JSONObject(obj.get("tipoLocalAtendimento").toString()));
    }

    public DistritoDTO getDistrito() {
        return distrito;
    }

    public void setDistrito(DistritoDTO distrito) {
        this.distrito = distrito;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public TipoLocalAtendimentoDTO getTipoLocalAtendimento() {
        return tipoLocalAtendimento;
    }

    public void setTipoLocalAtendimento(TipoLocalAtendimentoDTO tipoLocalAtendimento) {
        this.tipoLocalAtendimento = tipoLocalAtendimento;
    }
}
