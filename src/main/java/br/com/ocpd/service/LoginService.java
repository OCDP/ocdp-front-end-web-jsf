package br.com.ocpd.service;

import br.com.ocpd.to.UsuarioTO;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginService extends AwsApi {

    public UsuarioTO logar(UsuarioTO usuarioTO) {
        usuarioTO.setStatus("Ativo");
        usuarioTO.setNome("Dáurio Filho");

        try {
            HttpResponse response = getResponse(URL_LOGIN);
            if (response.getStatusLine().getStatusCode() == 200) {
                JSONObject js = getJson(response);
                usuarioTO.setId(js.getLong(""));
                usuarioTO.setStatus(js.getString(""));
                usuarioTO.setNome(js.getString(""));
                usuarioTO.setCpf(js.getString(""));
                usuarioTO.setEmail(js.getString(""));
                usuarioTO.setTelefone(js.getString(""));
                usuarioTO.setTipoAtencao(js.getString(""));
                usuarioTO.setTipoUsuario(js.getString(""));
            } else {
                usuarioTO = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioTO;
    }

    public void recuperarSenha(UsuarioTO usuarioTO) {

    }

    public void gravarNovoUsuario(UsuarioTO usuarioTO) {

    }

}
