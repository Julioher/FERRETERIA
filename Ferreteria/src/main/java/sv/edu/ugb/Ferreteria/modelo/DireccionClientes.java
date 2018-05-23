
package sv.edu.ugb.Ferreteria.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DireccionClientes implements Serializable

{
    @Id
    @Column(name = "id_direccion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_direccion;
    @Column(name = "direccion_cliente")
    private String direccion_cliente;
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "id_cliente")
   private  Clientes idCliente;

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
        return idCliente;
    }

    public void setId_cliente(Clientes id_cliente) {
        this.idCliente = id_cliente;
    }


}
