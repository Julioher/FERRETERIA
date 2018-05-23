
package sv.edu.ugb.Ferreteria.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.edu.ugb.Ferreteria.controlador.DireccionClientesDAO;
import sv.edu.ugb.Ferreteria.modelo.Clientes;
import sv.edu.ugb.Ferreteria.modelo.DireccionClientes;

@RestController
@RequestMapping("/direccionclientes")
public class DireccionClientesRest 
{
    @Autowired
    private DireccionClientesDAO dao;
    
    @GetMapping
    public List<DireccionClientes> getAll()
    {
        return dao.findAll();
    }
    
    
    @GetMapping("/direccionclientes/{id_direccion}")
    public Optional<DireccionClientes> findUser(@PathVariable(name = "id_direccion") Long id_direccion)
    {
        return dao.findById(id_direccion);
    }       
    
    
    @PostMapping("/direccionclientes")
    public int add(@RequestBody(required = true)DireccionClientes dir)
    {
        try{
            dao.save(dir);
            dao.findAll();
            return dir.getId_direccion().intValue();
        }catch(Exception e){
            return 0;
        }
    }
    
    @PutMapping("/direccionclientes")
    public int edit(@RequestBody(required = true)DireccionClientes dir)
    {
        try{
            dao.save(dir);
            dao.findAll();
            return dir.getId_direccion().intValue();
        }catch(Exception e){
            return 0;
        }
    }
    
    @DeleteMapping("/direccionclientes/{id_direccion}")
    public int delete(@PathVariable(name = "id_direccion")Long dir)
    {
        try{
            DireccionClientes d = new DireccionClientes();
            d.setId_direccion(dir);
            dao.delete(d);
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
}
