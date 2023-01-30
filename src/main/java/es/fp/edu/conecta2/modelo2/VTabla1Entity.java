package es.fp.edu.conecta2.modelo2;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "v_tabla1", schema = "bolsa", catalog = "")
public class VTabla1Entity {
    @Basic
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "genero", nullable = true, length = 50)
    private String genero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VTabla1Entity that = (VTabla1Entity) o;

        if (id != that.id) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (genero != null ? !genero.equals(that.genero) : that.genero != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        return result;
    }
}
