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

    protected static final String URL = "http://ec2-3-20-202-13.us-east-2.compute.amazonaws.com:8080/";
    protected static final String URL_API = URL + "api/";
    protected static final String URL_ENDPOINT = URL + "swagger-ui.html#/operations/";

    protected enum ApiEnum {
        URL_BASIC_AUTH(URL_API + "usuario/basicauth"),
        END_BASIC_AUTH(URL_ENDPOINT + "usuario-controller/getByCpfUsingGET"),
        URL_CAD_USUARIO(URL_API + ""),
        END_CAD_USUARIO(URL_ENDPOINT + ""),
        URL_GET_BY_CPF(URL_API + "usuario/byCpf/%s"),
        END_GET_BY_CPF(URL_ENDPOINT + ""),
        URL_GET_SEXOS(URL_API + "acompanhamento/sexos"),
        END_GET_SEXOS(URL_ENDPOINT + ""),
        URL_GET_BY_TIPO_LOCAL_DE_ATENDIMENTO(URL_API + "localAtendimento/byTipo/%s"),
        END_GET_BY_TIPO_LOCAL_DE_ATENDIMENTO(URL_ENDPOINT + ""),
        URL_GET_TIPO_USUARIO(URL_API + ""),
        END_GET_TIPO_USUARIO(URL_ENDPOINT + "usuario/tipoUsuario"),
        URL_RECUPERAR_SENHA(URL_API + ""),
        END_RECUPERAR_SENHA(URL_ENDPOINT + "");

        private String url;

        ApiEnum(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }


    public HttpResponse getResponse(ApiEnum apiEnum) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            return client.execute(new HttpGet(apiEnum.getUrl()));
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

    public HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "*/*");
        headers.add("Cache-Control", "no-cache");
        headers.add("Connection", "keep-alive");
        headers.add("Content-Type", "application/json");
        headers.add("Accept-Encoding", "gzip, deflate, br");
        headers.add("Host", "ec2-3-20-202-13.us-east-2.compute.amazonaws.com");
        return headers;
    }
}
