/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.expediente;

/**
 *
 * @author P
 */
public class PermisoExpediente {
    private String curp;
    private String paciente;

    public PermisoExpediente() {
        this.curp = "";
        this.paciente = "";
    }

    
    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
    
}
