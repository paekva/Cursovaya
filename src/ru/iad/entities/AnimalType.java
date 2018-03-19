package ru.iad.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Виды_животных", schema = "s225138", catalog = "studs")
public class AnimalType {
    private int idВида;
    private String название;
    private String особенности;
    private Double срПродолжЖизни;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_вида", nullable = false)
    public int getIdВида() {
        return idВида;
    }

    public void setIdВида(int idВида) {
        this.idВида = idВида;
    }

    @Basic
    @Column(name = "Название", nullable = false, length = 50)
    public String getНазвание() {
        return название;
    }

    public void setНазвание(String название) {
        this.название = название;
    }

    @Basic
    @Column(name = "Особенности", nullable = true, length = -1)
    public String getОсобенности() {
        return особенности;
    }

    public void setОсобенности(String особенности) {
        this.особенности = особенности;
    }

    @Basic
    @Column(name = "Ср_продолж_жизни", nullable = true, precision = 0)
    public Double getСрПродолжЖизни() {
        return срПродолжЖизни;
    }

    public void setСрПродолжЖизни(Double срПродолжЖизни) {
        this.срПродолжЖизни = срПродолжЖизни;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalType that = (AnimalType) o;
        return idВида == that.idВида &&
                Objects.equals(название, that.название) &&
                Objects.equals(особенности, that.особенности) &&
                Objects.equals(срПродолжЖизни, that.срПродолжЖизни);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idВида, название, особенности, срПродолжЖизни);
    }
}
