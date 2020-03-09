package br.com.ocpd.service;

import br.com.ocpd.to.UsuarioDTO;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

public class LoginService extends AwsApi {

    public UsuarioDTO logar(UsuarioDTO usuarioDTO) {
        usuarioDTO.setStatus("Ativo");
        usuarioDTO.setNome("Dáurio Filho");

        try {
            HttpResponse response = getResponse(ApiEnum.URL_BASIC_AUTH);
            if (response.getStatusLine().getStatusCode() == 200) {
                JSONObject js = getJson(response);
                usuarioDTO.setId(js.getLong(""));
                usuarioDTO.setStatus(js.getString(""));
                usuarioDTO.setNome(js.getString(""));
                usuarioDTO.setCpf(js.getString(""));
                usuarioDTO.setEmail(js.getString(""));
                usuarioDTO.setTelefone(js.getString(""));
                usuarioDTO.setTipoAtencao(js.getString(""));
                usuarioDTO.setTipoUsuario(js.getString(""));
            } else {
                usuarioDTO = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioDTO;
    }

    public void recuperarSenha(UsuarioDTO usuarioDTO) {

    }

    public void gravarNovoUsuario(UsuarioDTO usuarioDTO) {

    }

}
