
package sv.edu.ugb.Ferreteria.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetalleVentas implements Serializable
{
    @Id
    @Column(name = "idDetalleVenta")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDetalleVenta;
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "precio_venta")
    private Double precio_venta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVenta") 
    private Ventas idVenta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto")
    private Productos idProducto;

    public Long getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Long idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Ventas getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Ventas idVenta) {
        this.idVenta = idVenta;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
