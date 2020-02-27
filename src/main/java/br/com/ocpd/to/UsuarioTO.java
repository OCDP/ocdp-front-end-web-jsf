package br.com.ocpd.to;

public class UsuarioTO extends TransferObject{

    private String cpf;
    private String senha;
    private String nome;
    private String email;
    private String status;
    private String telefone;
    private String tipoUsuario;
    private String tipoAtencao;

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
