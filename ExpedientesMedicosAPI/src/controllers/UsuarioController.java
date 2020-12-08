/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import models.Expediente;
import models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author P
 */
@RestController
public class UsuarioController {

    @Autowired
    private RestTemplate restTemplate;
    private final String url = "http://localhost:1000";
    private Gson gson;
    private MultiValueMap<String, String> headers;

    /**
     * Constructor de la clase
     */
    public UsuarioController() {
        gson = new Gson();
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    /**
     * Metodo encargado de registrar un usuario en el sistema
     *
     * @param usuario Usuario a registrar en el sistema
     * @return Regresa true si se registro correctamente de lo cotrario false
     */
    public boolean registrarUsuario(Usuario usuario) {
        System.out.println("--Registrando Usuario mediante metodo POST--");
        String body = gson.toJson(usuario);
        System.out.println("Request Body: " + body);
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
        ResponseEntity<String> res = restTemplate.postForEntity(url + "/register", request, String.class);
        String jsonRes = res.getBody();

        // Transforma la respuesta de la peticion en JsonObject para acceder a las propiedades del Json
        Usuario user = gson.fromJson(jsonRes, Usuario.class);
        System.out.println(user.getIdentificador());
        
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo encargado de identificar un usuario con su usuario y contraseña
     *
     * @param username Nombre de usuario
     * @param password Contrase;a de usuario
     * @return Resgresa la informacion del usuario
     */
    public Usuario identificarUsuario(String username, String password) {
        // Armando el body del request
        JsonObject credentials = new JsonObject();
        credentials.addProperty("username", username);
        credentials.addProperty("password", password);
        String body = credentials.toString();

        // Armando el request
        HttpEntity<String> req = new HttpEntity<String>(body, headers);

        // Mandando la solicitud y obteniendo la respuesta
        ResponseEntity<String> res = restTemplate.postForEntity(url + "/login", req, String.class);

        Usuario resultado = gson.fromJson(res.getBody(), Usuario.class);
        System.out.println(resultado.getUsername());
        return resultado;
    }
}
