package es.fp.edu.conecta2.modelo2;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "tabla1", schema = "bolsa", catalog = "")
public class Tabla1Entity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @OneToMany(mappedBy = "tabla1ByTabla1Id")
    private Collection<Tabla2Entity> tabla2sById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tabla1Entity that = (Tabla1Entity) o;

        if (id != that.id) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    public Collection<Tabla2Entity> getTabla2sById() {
        return tabla2sById;
    }

    public void setTabla2sById(Collection<Tabla2Entity> tabla2sById) {
        this.tabla2sById = tabla2sById;
    }
}
