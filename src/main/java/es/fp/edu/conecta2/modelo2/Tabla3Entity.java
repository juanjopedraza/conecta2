package es.fp.edu.conecta2.modelo2;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tabla3", schema = "bolsa", catalog = "")
public class Tabla3Entity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = true, length = 45)
    private String nombre;

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

        Tabla3Entity that = (Tabla3Entity) o;

        if (id != that.id) return false;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
