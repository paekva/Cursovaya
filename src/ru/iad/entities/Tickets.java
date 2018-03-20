package ru.iad.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Билеты", schema = "s225138", catalog = "studs")
public class Tickets {
    private int idБилета;
    private Integer idЗоопарка;
    private Date датаПокупки;
    private int idСотрудника;
    private int idКатегории;

    public void setДатаПокупки(Timestamp датаПокупки) {
        this.датаПокупки = датаПокупки;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_билета", nullable = false)
    public int getIdБилета() {
        return idБилета;
    }

    public void setIdБилета(int idБилета) {
        this.idБилета = idБилета;
    }

    @Basic
    @Column(name = "id_зоопарка", nullable = true)
    public Integer getIdЗоопарка() {
        return idЗоопарка;
    }

    public void setIdЗоопарка(Integer idЗоопарка) {
        this.idЗоопарка = idЗоопарка;
    }

    @Basic
    @Column(name = "Дата_покупки", nullable = true)
    public Date getДатаПокупки() {
        return датаПокупки;
    }

    public void setДатаПокупки(Date датаПокупки) {
        this.датаПокупки = датаПокупки;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return idБилета == tickets.idБилета &&
                Objects.equals(idЗоопарка, tickets.idЗоопарка) &&
                Objects.equals(датаПокупки, tickets.датаПокупки);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idБилета, idЗоопарка, датаПокупки);
    }

    @Basic
    @Column(name = "id_сотрудника", nullable = false)
    public int getIdСотрудника() {
        return idСотрудника;
    }

    public void setIdСотрудника(int idСотрудника) {
        this.idСотрудника = idСотрудника;
    }

    @Basic
    @Column(name = "id_категории", nullable = false)
    public int getIdКатегории() {
        return idКатегории;
    }

    public void setIdКатегории(int idКатегории) {
        this.idКатегории = idКатегории;
    }
}
