
import controllers.ExpedienteController;
import main.ExpedientesMedicos;
import models.Expediente;
import models.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author P
 */
public class Test {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExpedientesMedicos em = new ExpedientesMedicos();
//        Usuario user = new Usuario();
//        user.setUsername("usuario1");
//        user.setPassword("usuario1");
//        user.setRol(0);
//        user.setIdentificador("usuario1");
//        if(em.registrarUsuario(user)){
//            System.out.println("Si rifa");
//        }
//        String username = "morkesho";
//        String password = "morkesho";
//        Usuario user = em.identificarse(username,password);
//        System.out.println(user.getIdentificador());
//        if(user != null){
//            System.out.println("Se logro.");
//        }
        
//        Expediente exp = em.consultarExpediente("algo");
//        System.out.println(exp.getApellidoMaterno());
         em.registrarEntradaHistorial("algo", "algo pasa en el vecindario");
         Expediente exp = em.consultarExpediente("algo");
         
         System.out.println(exp.getHistorial()[3].getBody());
        
    }
    
}
