package br.com.ocpd.dto;

import com.google.gson.JsonObject;

public class UsuarioDTO extends TransferObject {

    private String cpf;
    private String senha;
    private String nome;
    private String email;
    private String status = null;
    private String telefone;
    private String tipoUsuario;
    private String tipoAtencao;

    public UsuarioDTO(JsonObject obj) {
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
        this.cpf = obj.get("cpf").toString();
        /*this.senha = obj.get("").toString();*/
        this.nome = obj.get("nome").toString();
        this.email = obj.get("email").toString();
        this.status = obj.get("status").toString();
        this.telefone = obj.get("telefone").toString();
        this.tipoUsuario = obj.get("tipoUsuario").toString();
        this.tipoAtencao = obj.get("tipoAtencao").toString();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoAtencao() {
        return tipoAtencao;
    }

    public void setTipoAtencao(String tipoAtencao) {
        this.tipoAtencao = tipoAtencao;
    }
}
