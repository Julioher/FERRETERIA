
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
import sv.edu.ugb.Ferreteria.controlador.VentasDAO;
import sv.edu.ugb.Ferreteria.modelo.Ventas;

@RestController
@RequestMapping(path = "/ventas")
public class VentasRest
{
    @Autowired
    private VentasDAO dao;

    /**
     *
     * @return
     */
    @GetMapping
    public List<Ventas> getAll()
    {
        return dao.findAll();
    }

    
    @GetMapping("/ventas/{idVenta}")
    public Optional<Ventas> findUser(@PathVariable(name = "idVenta") Long idVenta)
    {
        return dao.findById(idVenta);
    }
        
    @PostMapping("/ventas")
    public int add(@RequestBody(required = true) Ventas ven)
    {
        try{
            dao.save(ven);
            dao.flush();
            return ven.getIdVenta().intValue();
        }catch(Exception e){
            return 0;
        }
    }

    @PutMapping("/ventas")
     public int edit(@RequestBody(required = true) Ventas ven)
    {
        try{
            dao.save(ven);
            dao.flush();
            return ven.getIdVenta().intValue();
        }catch(Exception e){
            return 0;
        }
    }

     @DeleteMapping("/ventas/{idVenta}")
     public int delete(@PathVariable(name = "idVenta")Long ven)
     {
         try{
            Ventas ve = new Ventas();
            ve.setIdVenta(ven);
            dao.delete(ve);
            return 1;
         }catch(Exception e){
            return 0;
        }
     }
}
