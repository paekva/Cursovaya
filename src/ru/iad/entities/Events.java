package ru.iad.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Мероприятия", schema = "s225138", catalog = "studs")
public class Events {
    private int idМероприятия;
    private String название;
    private int idЗоопарка;
    private Date датаВремяМероприятия;
    private Double продолжительность;
    private Double стоимостьБилетов;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_мероприятия", nullable = false)
    public int getIdМероприятия() {
        return idМероприятия;
    }

    public void setIdМероприятия(int idМероприятия) {
        this.idМероприятия = idМероприятия;
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
    @Column(name = "id_зоопарка", nullable = false)
    public int getIdЗоопарка() {
        return idЗоопарка;
    }

    public void setIdЗоопарка(int idЗоопарка) {
        this.idЗоопарка = idЗоопарка;
    }

    @Basic
    @Column(name = "Дата_время_мероприятия", nullable = false)
    public Date getДатаВремяМероприятия() {
        return датаВремяМероприятия;
    }

    public void setДатаВремяМероприятия(Date датаВремяМероприятия) {
        this.датаВремяМероприятия = датаВремяМероприятия;
    }

    @Basic
    @Column(name = "Продолжительность", nullable = true, precision = 0)
    public Double getПродолжительность() {
        return продолжительность;
    }

    public void setПродолжительность(Double продолжительность) {
        this.продолжительность = продолжительность;
    }

    @Basic
    @Column(name = "Стоимость_билетов", nullable = true, precision = 0)
    public Double getСтоимостьБилетов() {
        return стоимостьБилетов;
    }

    public void setСтоимостьБилетов(Double стоимостьБилетов) {
        this.стоимостьБилетов = стоимостьБилетов;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return idМероприятия == events.idМероприятия &&
                idЗоопарка == events.idЗоопарка &&
                Objects.equals(название, events.название) &&
                Objects.equals(датаВремяМероприятия, events.датаВремяМероприятия) &&
                Objects.equals(продолжительность, events.продолжительность) &&
                Objects.equals(стоимостьБилетов, events.стоимостьБилетов);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idМероприятия, название, idЗоопарка, датаВремяМероприятия, продолжительность, стоимостьБилетов);
    }
}
