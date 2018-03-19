package ru.iad.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "Площадки", schema = "s225138", catalog = "studs")
public class Places {
    private int номерПлощадки;
    private int idЗоопарка;
    private String названиеПлощадки;
    private BigInteger площадь;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Номер_площадки", nullable = false)
    public int getНомерПлощадки() {
        return номерПлощадки;
    }

    public void setНомерПлощадки(int номерПлощадки) {
        this.номерПлощадки = номерПлощадки;
    }

    @Basic
    @Column(name = "id_зоопарка", nullable = false)
    public int getIdЗоопарка() {
        return idЗоопарка;
    }

    public void setIdЗоопарка(int idЗоопарка) {
        this.idЗоопарка = idЗоопарка;
    }

    @Basic
    @Column(name = "Название_площадки", nullable = false, length = 50)
    public String getНазваниеПлощадки() {
        return названиеПлощадки;
    }

    public void setНазваниеПлощадки(String названиеПлощадки) {
        this.названиеПлощадки = названиеПлощадки;
    }

    @Basic
    @Column(name = "Площадь", nullable = true, precision = 0)
    public BigInteger getПлощадь() {
        return площадь;
    }

    public void setПлощадь(BigInteger площадь) {
        this.площадь = площадь;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Places places = (Places) o;
        return номерПлощадки == places.номерПлощадки &&
                idЗоопарка == places.idЗоопарка &&
                Objects.equals(названиеПлощадки, places.названиеПлощадки) &&
                Objects.equals(площадь, places.площадь);
    }

    @Override
    public int hashCode() {

        return Objects.hash(номерПлощадки, idЗоопарка, названиеПлощадки, площадь);
    }
}
