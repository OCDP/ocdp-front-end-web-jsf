package br.com.ocpd.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;

public class AwsApi {

    protected static final String URL_API = "";
    protected static final String URL_LOGIN = URL_API + "";
    protected static final String URL_CAD_USUARIO = URL_API + "";
    protected static final String URL_RECUPERAR_SENHA = URL_API + "";


    public HttpResponse getResponse(String url) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            return client.execute(new HttpGet(url));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject getJson(HttpResponse response) {
        try {
            return new JSONObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public HttpHeaders getHeader(boolean chat) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "*/*");
        headers.add("Cache-Control", "no-cache");
        headers.add("Connection", "keep-alive");
        headers.add("Content-Type", "application/json");
        headers.add("Accept-Encoding", "gzip, deflate, br");
        headers.add("Host", "");
        return headers;
    }
}
