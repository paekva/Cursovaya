package ru.iad.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Виды_категорий", schema = "s225138", catalog = "studs")
public class TicketsType {
    private int idКатегории;
    private String названиеКатегории;
    private String описаниеКатегории;
    private double стоимость;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_категории", nullable = false)
    public int getIdКатегории() {
        return idКатегории;
    }

    public void setIdКатегории(int idКатегории) {
        this.idКатегории = idКатегории;
    }

    @Basic
    @Column(name = "Название_категории", nullable = false, length = 50)
    public String getНазваниеКатегории() {
        return названиеКатегории;
    }

    public void setНазваниеКатегории(String названиеКатегории) {
        this.названиеКатегории = названиеКатегории;
    }

    @Basic
    @Column(name = "Описание_категории", nullable = true, length = -1)
    public String getОписаниеКатегории() {
        return описаниеКатегории;
    }

    public void setОписаниеКатегории(String описаниеКатегории) {
        this.описаниеКатегории = описаниеКатегории;
    }

    @Basic
    @Column(name = "Стоимость", nullable = false, precision = 0)
    public double getСтоимость() {
        return стоимость;
    }

    public void setСтоимость(double стоимость) {
        this.стоимость = стоимость;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketsType that = (TicketsType) o;
        return idКатегории == that.idКатегории &&
                Double.compare(that.стоимость, стоимость) == 0 &&
                Objects.equals(названиеКатегории, that.названиеКатегории) &&
                Objects.equals(описаниеКатегории, that.описаниеКатегории);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idКатегории, названиеКатегории, описаниеКатегории, стоимость);
    }
}
