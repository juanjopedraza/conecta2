package es.fp.edu.conecta2.modelo2;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tabla2", schema = "bolsa", catalog = "")
public class Tabla2Entity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = true, length = 50)
    private String nombre;
    @Basic
    @Column(name = "tabla1_id", nullable = false)
    private int tabla1Id;
    @ManyToOne
    @JoinColumn(name = "tabla1_id", referencedColumnName = "id", nullable = false)
    private Tabla1Entity tabla1ByTabla1Id;

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

    public int getTabla1Id() {
        return tabla1Id;
    }

    public void setTabla1Id(int tabla1Id) {
        this.tabla1Id = tabla1Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tabla2Entity that = (Tabla2Entity) o;

        if (id != that.id) return false;
        if (tabla1Id != that.tabla1Id) return false;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + tabla1Id;
        return result;
    }

    public Tabla1Entity getTabla1ByTabla1Id() {
        return tabla1ByTabla1Id;
    }

    public void setTabla1ByTabla1Id(Tabla1Entity tabla1ByTabla1Id) {
        this.tabla1ByTabla1Id = tabla1ByTabla1Id;
    }
}
