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
        URL_USUARIO(URL_API + "usuario"),
        END_USUARIO_SALVAR(URL_ENDPOINT + "usuario-controller/salvarUsingPOST_13"),
        END_USUARIO_ATUALIZAR(URL_ENDPOINT + "usuario-controller/atualizarUsingPUT_11"),
        URL_GET_BY_CPF(URL_API + "usuario/byCpf/%s"),
        END_GET_BY_CPF(URL_ENDPOINT + "usuario-controller/getByCpfUsingGET"),
        URL_GET_SEXOS(URL_API + "acompanhamento/sexos"),
        END_GET_SEXOS(URL_ENDPOINT + "acompanhamento-controller/getSexosUsingGET"),
        URL_LOCAL_DE_ATENDIMENTO(URL_API + "localAtendimento/byTipo/"),
        URL_GET_BY_TIPO_LOCAL_DE_ATENDIMENTO(URL_API + "localAtendimento/byTipo/%s"),
        END_GET_BY_TIPO_LOCAL_DE_ATENDIMENTO(URL_ENDPOINT + "local-atendimento-controller/getByTipoLocalDeAtendimentoUsingGET"),
        URL_GET_TIPO_USUARIO(URL_API + "usuario/tipoUsuario"),
        END_GET_TIPO_USUARIO(URL_ENDPOINT + "usuario-controller/getTipoUsuarioUsingGET"),
        URL_RECUPERAR_SENHA(URL_API + ""),//AGUARDANDO IMPLEMENTAÇÃO
        END_RECUPERAR_SENHA(URL_ENDPOINT + ""),//AGUARDANDO IMPLEMENTAÇÃO
        URL_GET_CIDADES(URL_API + "cidade"),
        END_GET_CIDADES(URL_ENDPOINT + "cidade-controller/getCidadesUsingGET"),
        URL_BAIRRO(URL_API + "bairro"),
        URL_GET_BAIRRO_BY_NOME(URL_API + "bairro/byNome/%s"),
        END_BAIRRO_ATUALIZAR(URL_ENDPOINT + "bairro-controller/atualizarUsingPUT"),
        END_BAIRRO_SALVAR(URL_ENDPOINT + "bairro-controller/salvarUsingPOST_1"),
        URL_CIDADE(URL_API + "cidade"),
        URL_GET_CIDADE_BY_NOME(URL_API + "cidade/byNome/%s"),
        END_GET_CIDADE_BY_NOME(URL_ENDPOINT + "cidade-controller/getByNameUsingGET_1"),
        END_CIDADE_ATUALIZAR(URL_ENDPOINT + "cidade-controller/atualizarUsingPUT_1"),
        END_CIDADE_SALVAR(URL_ENDPOINT + "cidade-controller/salvarUsingPOST_2"),
        URL_DISTRITO(URL_API + "distrito"),
        URL_GET_DISTRITO_BY_NOME(URL_API + "distrito/byNome/%s"),
        END_GET_DISTRITO_BY_NOME(URL_ENDPOINT + "distrito-controller/getByNameUsingGET_2"),
        END_DISTRITO_SALVAR(URL_ENDPOINT + "distrito-controller/salvarUsingPOST_3"),
        END_DISTRITO_ATUALIZAR(URL_ENDPOINT + "distrito-controller/salvarUsingPOST_3"),
        URL_LOCAL_ATENDIMENTO(URL_API + "localAtendimento"),
        END_LOCAL_ATENDIMENTO_ATUALIZAR(URL_ENDPOINT + "local-atendimento-controller/atualizarUsingPUT_5"),
        URL_TIPO_LESAO(URL_API + "tipoLesao"),
        URL_GET_TIPO_LESAO_BY_NOME(URL_API + "tipoLesao/byNome/%s"),
        END_GET_TIPO_LESAO_BY_NOME(URL_ENDPOINT + "tipo-lesao-controller/getByNameUsingGET_6"),
        END_TIPO_LESAO_ATUALIZAR(URL_ENDPOINT + "tipo-lesao-controller/atualizarUsingPUT_9"),
        END_TIPO_LESAO_SALVAR(URL_ENDPOINT + "tipo-lesao-controller/salvarUsingPOST_11"),
        URL_GET_TIPO_LOCAL_ATENDIMENTO_BY_NOME(URL_API + "tipoLocalAtendimento/byNome/%s"),
        END_GET_TIPO_LOCAL_ATENDIMENTO_BY_NOME(URL_ENDPOINT + "tipo-local-atendimento-controller/getByNameUsingGET_7"),
        END_TIPO_LOCAL_ATENDIMENTO_ATUALIZAR(URL_ENDPOINT + "tipo-local-atendimento-controller/atualizarUsingPUT_10"),
        END_TIPO_LOCAL_ATENDIMENTO_SALVAR(URL_ENDPOINT + "tipo-local-atendimento-controller/salvarUsingPOST_12"),
        URL_GET_USUARIO_BY_TIPO_AND_STATUS(URL_API + "usuario/byTipoAndStatus/%s/%s"),
        END_GET_USUARIO_BY_TIPO_AND_STATUS(URL_ENDPOINT + "usuario-controller/getByTipoAndStatusUsingGET");

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
