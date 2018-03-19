package ru.iad.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Сотрудники", schema = "s225138", catalog = "studs")
public class Employees {
    private int idСотрудника;
    private String фио;
    private String пол;
    private String профессия;
    private String образование;
    private Double стажРаботы;
    private int idЗоопарка;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_сотрудника", nullable = false)
    public int getIdСотрудника() {
        return idСотрудника;
    }

    public void setIdСотрудника(int idСотрудника) {
        this.idСотрудника = idСотрудника;
    }

    @Basic
    @Column(name = "ФИО", nullable = false, length = 50)
    public String getФио() {
        return фио;
    }

    public void setФио(String фио) {
        this.фио = фио;
    }

    @Basic
    @Column(name = "Пол", nullable = false, length = 7)
    public String getПол() {
        return пол;
    }

    public void setПол(String пол) {
        this.пол = пол;
    }

    @Basic
    @Column(name = "Профессия", nullable = false, length = -1)
    public String getПрофессия() {
        return профессия;
    }

    public void setПрофессия(String профессия) {
        this.профессия = профессия;
    }

    @Basic
    @Column(name = "Образование", nullable = true, length = -1)
    public String getОбразование() {
        return образование;
    }

    public void setОбразование(String образование) {
        this.образование = образование;
    }

    @Basic
    @Column(name = "Стаж_работы", nullable = true, precision = 0)
    public Double getСтажРаботы() {
        return стажРаботы;
    }

    public void setСтажРаботы(Double стажРаботы) {
        this.стажРаботы = стажРаботы;
    }

    @Basic
    @Column(name = "id_зоопарка", nullable = false)
    public int getIdЗоопарка() {
        return idЗоопарка;
    }

    public void setIdЗоопарка(int idЗоопарка) {
        this.idЗоопарка = idЗоопарка;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return idСотрудника == employees.idСотрудника &&
                idЗоопарка == employees.idЗоопарка &&
                Objects.equals(фио, employees.фио) &&
                Objects.equals(пол, employees.пол) &&
                Objects.equals(профессия, employees.профессия) &&
                Objects.equals(образование, employees.образование) &&
                Objects.equals(стажРаботы, employees.стажРаботы);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idСотрудника, фио, пол, профессия, образование, стажРаботы, idЗоопарка);
    }
}
