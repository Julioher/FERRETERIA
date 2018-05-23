
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
import sv.edu.ugb.Ferreteria.controlador.CategoriasDAO;
import sv.edu.ugb.Ferreteria.modelo.Categorias;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriasRest 
{
    @Autowired
    private CategoriasDAO dao;
    
    @GetMapping
    public List<Categorias> getAll()
    {
        return dao.findAll();
    }
    
    @GetMapping("/categorias/{idCategoria}")
    public Optional<Categorias>  findUser(@PathVariable(name = "idCategoria")Long idCategoria)
    {
        return dao.findById(idCategoria);
    }
    
    
    @PostMapping("/categorias")
    public int add(@RequestBody(required = true)Categorias cat)
    {
        try{
            dao.save(cat);
            dao.flush();
            return cat.getIdCategoria().intValue();
        }catch(Exception e){
            return 0;
        }
    }
    
    @PutMapping("/categorias")
     public int edit(@RequestBody(required = true)Categorias cat)
    {
        try{
            dao.save(cat);
            dao.flush();
            return cat.getIdCategoria().intValue();
        }catch(Exception e){
            return 0;
        }
    }
     
     @DeleteMapping("/categorias/{idCategoria}")
     public int delete(@PathVariable(name = "idCategoria")Long cat)
     {
         try{
             Categorias c = new Categorias();
             c.setIdCategoria(cat);
             dao.delete(c);
             return 1;
         }catch(Exception e){
            return 0;
        }
     }
}
