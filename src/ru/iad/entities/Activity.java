package ru.iad.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Вид_деятельности", schema = "s225138", catalog = "studs")
public class Activity {
    private int idДеятельности;
    private int idЗоопарка;
    private double количествоЧасовВНеделю;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_деятельности", nullable = false)
    public int getIdДеятельности() {
        return idДеятельности;
    }

    public void setIdДеятельности(int idДеятельности) {
        this.idДеятельности = idДеятельности;
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
    @Column(name = "Количество_часов_в_неделю", nullable = false, precision = 0)
    public double getКоличествоЧасовВНеделю() {
        return количествоЧасовВНеделю;
    }

    public void setКоличествоЧасовВНеделю(double количествоЧасовВНеделю) {
        this.количествоЧасовВНеделю = количествоЧасовВНеделю;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return idДеятельности == activity.idДеятельности &&
                idЗоопарка == activity.idЗоопарка &&
                Double.compare(activity.количествоЧасовВНеделю, количествоЧасовВНеделю) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idДеятельности, idЗоопарка, количествоЧасовВНеделю);
    }
}
