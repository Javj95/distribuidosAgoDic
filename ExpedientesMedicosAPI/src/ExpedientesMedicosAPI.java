
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
    public boolean registrarExpediente(Expediente expediente);
    
    public Expediente consultarExpediente(String curp);
    
    public Expediente registrarEntradaHistorial(String curp, String entrada);
    
    
    // Doctores
    public boolean registraDoctor(Doctor doctor);
    
    public Doctor consultaDoctor(String cedula);
    
    // Usuarios
    public boolean registrarUsuario(Usuario user);
    
    public Usuario identificarse(String user, String pass);
    
    // Citas
    public Cita registrarCita(Cita cita);
    
    public Cita[] consultaCitas(String curp);
}
