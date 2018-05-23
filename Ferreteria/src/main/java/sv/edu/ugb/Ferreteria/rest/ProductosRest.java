
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
import sv.edu.ugb.Ferreteria.controlador.ProductosDAO;
import sv.edu.ugb.Ferreteria.modelo.Productos;

@RestController
@RequestMapping(path = "/productos")
public class ProductosRest 
{
    @Autowired
    private ProductosDAO dao;
    
    @GetMapping
    public List<Productos> getAll()
    {
      
        return dao.findAll();
    }
    
    @GetMapping("/productos/{idProducto}")
    public Optional<Productos> findUser(@PathVariable(name = "idProducto")Long idProducto)
    {
        return dao.findById(idProducto);
    }
    
    @PostMapping("/productos")
    public int add(@RequestBody(required = true)Productos pro)
    {
        try{
            dao.save(pro);
            dao.flush();
            return pro.getIdProducto().intValue();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    @PutMapping("/productos")
     public int edit(@RequestBody(required = true) Productos pro)
    {
        try{
            dao.save(pro);
            dao.flush();
            return pro.getIdProducto().intValue();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
     
     @DeleteMapping("/productos/{idProducto}")
     public int delete(@PathVariable(name = "idProducto")Long pro)
     {
        try{
            Productos pr = new Productos();
            pr.setIdProducto(pro);
            dao.delete(pr);
            return 1;
        }catch(Exception e){
            return 0;
        }
     }
}
