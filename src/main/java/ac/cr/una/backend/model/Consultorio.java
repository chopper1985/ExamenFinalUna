
package ac.cr.una.backend.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "consultorio", catalog = "agenda", uniqueConstraints = {
    @UniqueConstraint(columnNames = "nombre")
    ,@UniqueConstraint(columnNames = "telefono")})
public class Consultorio implements Serializable {

    private String nombre;
    private String telefono;
    private String fechaAtencion;
    private int id;

    public Consultorio() {
    }

    public Consultorio(String nombre, String telefono, String fechaAtencion, int id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaAtencion = fechaAtencion;
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nombre", unique = true, nullable = false, length = 10)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "telefono", unique = true, nullable = false, length = 10)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(name = "fechaAtencion", unique = true, nullable = false, length = 10)
    public String getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.telefono);
        hash = 97 * hash + Objects.hashCode(this.fechaAtencion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consultorio other = (Consultorio) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.fechaAtencion, other.fechaAtencion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultorio{" + "nombre=" + nombre + ", telefono=" + telefono + ", fechaAtencion=" + fechaAtencion + ", id=" + id + '}';
    }

}
