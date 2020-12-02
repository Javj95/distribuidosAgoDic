/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author P
 */
public class Cita {
    private String _id;
    private String curp_paciente;
    private String fecha;
    private String hora;
    private String departamento;
    private String consultorio;
    private String cedula_medico;

    public Cita() {
        this._id = "";
        this.curp_paciente = "";
        this.fecha = "";
        this.hora = "";
        this.departamento = "";
        this.consultorio = "";
        this.cedula_medico = "";
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getCurp_paciente() {
        return curp_paciente;
    }

    public void setCurp_paciente(String curp_paciente) {
        this.curp_paciente = curp_paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getCedula_medico() {
        return cedula_medico;
    }

    public void setCedula_medico(String cedula_medico) {
        this.cedula_medico = cedula_medico;
    }
    
    
}
