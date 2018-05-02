
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
public class DireccionClientes implements Serializable
        
{
    @Id
    @Column(name = "id_direccion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_direccion;
    @Column(name = "direccion_cliente")
    private String direccion_cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private  Clientes id_cliente;

    public Long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Long id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public Clientes getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Clientes id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    
}
