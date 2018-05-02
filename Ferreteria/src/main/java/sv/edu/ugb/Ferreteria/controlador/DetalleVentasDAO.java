
package sv.edu.ugb.Ferreteria.controlador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sv.edu.ugb.Ferreteria.modelo.DetalleVentas;


public interface DetalleVentasDAO extends JpaRepository<DetalleVentas, Long>
{
    
}
