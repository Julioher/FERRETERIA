
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
import sv.edu.ugb.Ferreteria.controlador.DetalleVentasDAO;
import sv.edu.ugb.Ferreteria.modelo.DetalleVentas;

@RestController
@RequestMapping(path = "/detalleventas")
public class DetalleVentasRest 
{
     @Autowired
    private DetalleVentasDAO dao;
    
     @GetMapping
    public List<DetalleVentas> getAll()
    {
        return dao.findAll();
    }
    
    
     @GetMapping("/detalleventas/{idDetalleVenta}")
    public Optional<DetalleVentas> findUser(@PathVariable(name = "idDetalleVenta")Long idDetalleVenta)
    {
        return dao.findById(idDetalleVenta);
    }
    
    
    @PostMapping("/detalleventas")
    public int add(@RequestBody(required = true)DetalleVentas det)
    {
        try{
            dao.save(det);
            dao.flush();
            return det.getIdDetalleVenta().intValue();
        }catch(Exception e){
            return 0;
        }
    }
    
    @PutMapping("/detalleventas")
    public int edit(@RequestBody(required = true)DetalleVentas det)
    {
        try{
            dao.save(det);
            dao.flush();
            return det.getIdDetalleVenta().intValue();
        }catch(Exception e){
            return 0;
        }
    }
    
    @DeleteMapping("/detalleventas/{idDetalleVenta}")
    public int delete(@PathVariable(name = "idDetalleVenta")Long det)
    {
        try{
            DetalleVentas de = new DetalleVentas();
            de.setIdDetalleVenta(det);
            dao.delete(de);
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
}
