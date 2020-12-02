/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import static javafx.scene.input.KeyCode.T;
import models.Doctor;
import models.Expediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Clase controller encargada de acceder a los endpoints del servicio de Expedientes
 * y realizar las operaciones necesarias.
 * 
 * @author P
 */
@RestController
public class ExpedienteController {

    @Autowired
    private RestTemplate restTemplate;
    private final String url = "http://localhost:3000";
    private Gson gson;
    private MultiValueMap<String, String> headers;

    /**
     * Constructor de la clase
     */
    public ExpedienteController() {
        gson = new Gson();
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    /**
     * Metodo encargado de registrar un expediente en el servicio
     * 
     * @param exp Expediente a registrar
     * @return True si fue un exito de lo contrario false.
     */
    public boolean registrarExpediente(Expediente exp) {
        System.out.println("--Registrando Expediente mediante metodo POST--");
        String body = gson.toJson(exp);
        System.out.println("Request Body: " + body);
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
        ResponseEntity<String> res = restTemplate.postForEntity(url, request, String.class);
        String jsonRes = res.getBody();
        
        // Transforma la respuesta de la peticion en JsonObject para acceder a las propiedades del Json
        JsonObject json = gson.fromJson(jsonRes, JsonObject.class);
        String mensaje = json.get("message").getAsString();
        
        if (mensaje == "Funciona!"){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Metodo encargado de consultar un expediente con su curp
     * 
     * @param curp Curp del expediente que se desea consultar
     * @return Expediente del curp
     */
    public Expediente consultarExpediente(String curp){
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<String> res = restTemplate.getForEntity(url+"/"+curp, String.class);
        String jsonRes = res.getBody();
        System.out.println(jsonRes);
        Expediente resultado = gson.fromJson(jsonRes, Expediente.class);
        return resultado;
    }
    
    /**
     * Metodo que agrega una entrada el historial de un expediente por curp
     * 
     * @param curp Curp del expediente a modificar
     * @param entrada Entrada a registrar en el historial
     * @return Expediente actualizado
     */
    public Expediente registrarEntradaHistorial(String curp,String entrada){
        // Armando el body del request
        JsonObject entry = new JsonObject();
        entry.addProperty("entrada", entrada);
        String body = entry.toString();

        // Armando el request
        HttpEntity<String> req = new HttpEntity<String>(body, headers);
        
        // Mandando la solicitud y obteniendo la respuesta
        ResponseEntity<String> res = restTemplate.postForEntity(url+"/"+curp, req, String.class);
     
        // Se guarda la respuesta como expediente y se regresa
        Expediente resultado = gson.fromJson(res.getBody(), Expediente.class);
        return resultado;
    }
}
