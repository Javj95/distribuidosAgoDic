/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.aux;

/**
 *
 * @author P
 */
public class Entrada {
    private String body; 
    private String fecha;

    public Entrada(String body, String fecha) {
        this.body = body;
        this.fecha = fecha;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
