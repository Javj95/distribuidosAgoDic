/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import models.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Clase encargada de acceder al sistema de citas
 * 
 * @author P
 */
@RestController
public class CitaController {

    @Autowired
    private RestTemplate restTemplate;
    private final String url = "http://localhost:2000";
    private Gson gson;
    private MultiValueMap<String, String> headers;

    /**
     * Constructor de la clase
     */
    public CitaController() {
        gson = new Gson();
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    /**
     * Metodo encargado de registrar una cita en el servicio
     *
     * @param exp Expediente a registrar
     * @return True si fue un exito de lo contrario false.
     */
    public boolean registrarCita(Cita cita) {
        System.out.println("--Registrando Expediente mediante metodo POST--");
        String body = gson.toJson(cita);
        System.out.println("Request Body: " + body);
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
        ResponseEntity<String> res = restTemplate.postForEntity(url, request, String.class);
        String jsonRes = res.getBody();

        // Transforma la respuesta de la peticion en JsonObject para acceder a las propiedades del Json
        JsonObject json = gson.fromJson(jsonRes, JsonObject.class);
        String mensaje = json.get("message").getAsString();

        if (mensaje == "Funciona!") {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo encargado de modifitar una cita del sistema
     *
     * @param exp Expediente a registrar
     * @return True si fue un exito de lo contrario false.
     */
    public boolean modificarCita(Cita cita) {
        System.out.println("--Registrando Expediente mediante metodo POST--");
        String body = gson.toJson(cita);
        System.out.println("Request Body: " + body);
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
        ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
        String jsonRes = res.getBody();

        // Transforma la respuesta de la peticion en JsonObject para acceder a las propiedades del Json
        JsonObject json = gson.fromJson(jsonRes, JsonObject.class);
        String mensaje = json.get("message").getAsString();

        if (mensaje == "Funciona!") {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo encargado de eliminar una cita del sistema
     *
     * @param cita Expediente a registrar
     * @return True si fue un exito de lo contrario false.
     */
    public boolean eliminarCita(Cita cita) {
        System.out.println("--Eliminando Cita mediante metodo DELETE--");
        String body = gson.toJson(cita);
        System.out.println("Request Body: " + body);
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
        ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);
        String jsonRes = res.getBody();

        // Transforma la respuesta de la peticion en JsonObject para acceder a las propiedades del Json
        JsonObject json = gson.fromJson(jsonRes, JsonObject.class);
        String mensaje = json.get("message").getAsString();

        if (mensaje == "Funciona!") {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Metodo encargado de consultar las citas por curp del paciente
     * 
     * @param curp Curp del paciente a consultar
     * @return Lista de citas del paciente
     */
    public Cita[] consultarCitasPaciente(String curp) {
        System.out.println("--Registrando Expediente mediante metodo POST--");
        String body = gson.toJson(curp);
        System.out.println("Request Body: " + body);
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
        ResponseEntity<String> res = restTemplate.getForEntity(url+"/paciente/"+curp, String.class);
        String jsonRes = res.getBody();
        
        // Transforma la respuesta de la peticion en JsonObject para acceder a las propiedades del Json
        JsonObject json = gson.fromJson(jsonRes, JsonObject.class);
        Cita[] result = gson.fromJson(json.get("citas").getAsString(), Cita[].class);
        
        return result;
    }
    
    /**
     * Metodo encargado de consultar las citas por cedula del doctor
     * 
     * @param cedula Cedula del doctor a consultar
     * @return Lista de citas del doctor
     */
    public Cita[] consultarCitasDoctor(String cedula) {
        System.out.println("--Registrando Expediente mediante metodo POST--");
        String body = gson.toJson(cedula);
        System.out.println("Request Body: " + body);
        HttpEntity<String> request = new HttpEntity<String>(body, headers);
        ResponseEntity<String> res = restTemplate.getForEntity(url+"/doctor/"+cedula, String.class);
        String jsonRes = res.getBody();
        
        // Transforma la respuesta de la peticion en JsonObject para acceder a las propiedades del Json
        JsonObject json = gson.fromJson(jsonRes, JsonObject.class);
        Cita[] result = gson.fromJson(json.get("citas").getAsString(), Cita[].class);
        
        return result;
    }
}