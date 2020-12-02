/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.expediente.PermisoExpediente;

/**
 *
 * @author P
 */
public class Doctor {
    private String cedula;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String departamento;
    private String puesto;
    private String especialidad;
    private PermisoExpediente[] permisosExpediente;

    public Doctor(String cedula, String nombre, String apellidoPaterno, String apellidoMaterno, String departamento, String puesto, String especialidad) {
        this.cedula = "";
        this.nombre = "";
        this.apellidoPaterno = "";
        this.apellidoMaterno = "";
        this.departamento = "";
        this.puesto = "";
        this.especialidad = "";
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public PermisoExpediente[] getPermisosExpediente() {
        return permisosExpediente;
    }

    public void setPermisosExpediente(PermisoExpediente[] permisosExpediente) {
        this.permisosExpediente = permisosExpediente;
    }
    
}
