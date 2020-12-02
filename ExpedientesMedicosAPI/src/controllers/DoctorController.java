/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import models.Doctor;
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
public class DoctorController { 

    @Autowired
    private RestTemplate restTemplate;
    private final String url = "http://localhost:4000";
    private Gson gson;
    private MultiValueMap<String, String> headers;

    /**
     * Constructor de la clase
     */
    public DoctorController() {
        gson = new Gson();
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }
    
    /**
     * Metodo encargado de registrar un doctor en el servicio
     * 
     * @param exp Expediente a registrar
     * @return True si fue un exito de lo contrario false.
     */
    public boolean registrarDoctor(Doctor doctor) {
        System.out.println("--Registrando Usuario mediante metodo POST--");
        String body = gson.toJson(doctor);
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
     * Metodo encargado de consultar un doctor con su cedula
     * 
     * @param cedula Cedula del doctor que se desea consultar
     * @return Doctor con cedula correspondiente
     */
    public Doctor consultarDoctor(String cedula){
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<String> res = restTemplate.getForEntity(url+"/"+cedula, String.class);
        String jsonRes = res.getBody();
        System.out.println(jsonRes);
        Doctor resultado = gson.fromJson(jsonRes, Doctor.class);
        return resultado;
    }
    
}
