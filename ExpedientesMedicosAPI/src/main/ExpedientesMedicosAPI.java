package main;


import models.Cita;
import models.Doctor;
import models.Expediente;
import models.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author P
 */
public interface ExpedientesMedicosAPI {
    
    // Expedientes
    
    /**
     * Registra un expediente en la base de datos
     * 
     * @param expediente Expediente a registrar
     * @return Regresa true si se realizo la operacion correctamente, de lo 
     * contrario false.
     */
    public boolean registrarExpediente(Expediente expediente);
    
    /**
     * Consulta un expediente de la base de datos
     * 
     * @param curp Curp del expediente que se desea consultar
     * @return Regresa el expediente consultado
     */
    public Expediente consultarExpediente(String curp);
    
    /**
     * Registra un evento en el historial de un expediente
     * 
     * @param curp Curp del expediente a sobreescribir
     * @param entrada Entrada a agregar en el historial
     * @return Regresa el expediente actualizado.
     */
    public Expediente registrarEntradaHistorial(String curp, String entrada);
    
    
    // Doctores
    
    /**
     * Registra un doctor en la base de datos
     * 
     * @param doctor Doctor a registrar en la base de datos
     * @return Regresa true si se realizo la operacion correctamente, de lo
     * contrario false.
     */
    public boolean registraDoctor(Doctor doctor);
    
    /**
     * Consulta un doctor de la base de datos
     * 
     * @param cedula Cedula del doctor a consultar
     * @return Regresa el doctor que coincida con la cedula especificada.
     */
    public Doctor consultaDoctor(String cedula);
    
    // Usuarios
    
    /**
     * Registra un usuario en la base de datos
     * 
     * @param user Usuario a registrar
     * @return Regresa true si se registro correctamente, de lo contrario false
     */
    public boolean registrarUsuario(Usuario user);
    
    /**
     * Identifica las credenciales de un usuario en la base de datos
     * 
     * @param user Nombre de usuario
     * @param pass Contrase;a
     * @return Regresa la informacion del usuario a identificar.
     */
    public Usuario identificarse(String user, String pass);
    
    // Citas
    
    /**
     * Registra una cita en la base de datos
     * 
     * @param cita Cita a registrar
     * @return Regresa true si se modifico correctamente, de lo contrario
     * false
     */
    public boolean registrarCita(Cita cita);
    
    /**
     * Modifica una cita en la base de datos
     * 
     * @param cita Cita a modificar
     * @return Regresa true si se modifico la cita correctamente, de lo contrario
     * false.
     */
    public boolean modificarCita(Cita cita);
    
    /**
     * Elimina la cita que coincida su _id
     * 
     * @param cita Cita a eliminar
     * @return Regresa true si se elimino correctamente, de lo contrario
     * false.
     */
    public boolean eliminarCita(Cita cita);
    
    /**
     * Consulta las citas proximas de un doctor por cedula
     * 
     * @param cedula Cedula del doctor 
     * @return Regresa las citas proximas del doctor
     */
    public Cita[] consultaCitasDoctor(String cedula);
    
    /**
     * Consulta las citas proximas de un paciente por curp
     * 
     * @param curp Curp del paciente 
     * @return Regresa las citas proximas del paciente
     */
    public Cita[] consultaCitasPaciente(String curp);
}
