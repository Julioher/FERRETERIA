
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
import sv.edu.ugb.Ferreteria.controlador.ClientesDAO;
import sv.edu.ugb.Ferreteria.modelo.Clientes;

@RestController
@RequestMapping(path = "/clientes")
public class ClientesRest 
{
    @Autowired
    private ClientesDAO dao;
    
    @GetMapping
    public List<Clientes> getAll()
    {
       return dao.findAll();
    }
    
    @GetMapping("/clientes/{idCliente}")
    public Optional<Clientes> findUser(@PathVariable (name= "idCliente")Long idCliente)
    {
        return dao.findById(idCliente);
    }
    
    
    
    @PostMapping("/clientes")
    public int add(@RequestBody(required = true)Clientes cli)
    {
        try{
            dao.save(cli);
            dao.flush();
            return cli.getIdCliente().intValue();
        }catch(Exception e){
            return 0;
        }
    }
    
    @PutMapping("/clientes")
    public int edit(@RequestBody(required = true)Clientes cli)
    {
        try{
            dao.save(cli);
            dao.flush();
            return cli.getIdCliente().intValue();
        }catch(Exception e){
            return 0;
        }
    }
    
    @DeleteMapping("/clientes/{idCliente}")
    public int delete(@PathVariable(name = "idCliente")Long cli)
    {
        try{
            Clientes cl = new Clientes();
            cl.setIdCliente(cli);
            dao.delete(cl);
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
}
