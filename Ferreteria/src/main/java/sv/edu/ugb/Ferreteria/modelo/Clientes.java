
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
public class Clientes implements Serializable
{
    @Id
    @Column(name = "idCliente")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long idCliente;
    @Column(name = "pNombre")
    private String pNombre;
    @Column(name = "sNombre")
    private String sNombre;
    @Column(name = "pApellido")
    private String pApellido;
    @Column(name = "sApellido")
    private String sApellido;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "clave")
    private String clave;
    @Column(name = "dui")
    private String dui;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_direccion")
    //private  DireccionClientes id_direccion;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

   /* public DireccionClientes getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(DireccionClientes id_direccion) {
        this.id_direccion = id_direccion;
    */


}
