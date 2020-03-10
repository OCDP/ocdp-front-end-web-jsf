package br.com.ocpd.service;

import br.com.ocpd.dto.UsuarioDTO;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

public class LoginService extends AwsApi {

    public UsuarioDTO logar(UsuarioDTO usuarioDTO) {

        try {
//            HttpResponse response = getResponse(ApiEnum.URL_BASIC_AUTH);
            HttpResponse response = getResponse(ApiEnum.TEST2);

            System.out.println("1 = " + response.getStatusLine());
            System.out.println("2 = " + response.getEntity().getContent());

            if (response.getStatusLine().getStatusCode() == 200) {
                JSONObject js = getJson(response);
                usuarioDTO = new UsuarioDTO(getJson(response));

                usuarioDTO.setStatus("Ativo");
                usuarioDTO.setNome("Dáurio Filho");
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

    public static void main(String[] args) {
        new LoginService().logar(new UsuarioDTO());
        System.out.println(ApiEnum.TEST2.getUrl());
    }

}
