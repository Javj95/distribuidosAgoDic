/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author P
 */
@RestController
public class RestContoller {
    @Autowired
    private IProducto repo;
    
    @GetMapping
    public List<Producto> listar(){
        return repo.findAll();
    }
    
}
