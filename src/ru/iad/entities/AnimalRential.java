package ru.iad.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Прокат_животных", schema = "s225138", catalog = "studs")
public class AnimalRential {
    private int idПроката;
    private int idЗоопаркаДающего;
    private Date датаВзятия;
    private Integer idЗоопаркаБерущего;
    private String фиоБерущего;
    private String цель;
    private Double ценаУслуги;
    private Date датаВозврата;
    private int idЖивотного;

    public void setДатаВзятия(java.sql.Date датаВзятия) {
        this.датаВзятия = датаВзятия;
    }

    public void setДатаВозврата(java.sql.Date датаВозврата) {
        this.датаВозврата = датаВозврата;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_проката", nullable = false)
    public int getIdПроката() {
        return idПроката;
    }

    public void setIdПроката(int idПроката) {
        this.idПроката = idПроката;
    }

    @Basic
    @Column(name = "id_зоопарка_дающего", nullable = false)
    public int getIdЗоопаркаДающего() {
        return idЗоопаркаДающего;
    }

    public void setIdЗоопаркаДающего(int idЗоопаркаДающего) {
        this.idЗоопаркаДающего = idЗоопаркаДающего;
    }

    @Basic
    @Column(name = "Дата_взятия", nullable = false)
    public Date getДатаВзятия() {
        return датаВзятия;
    }

    public void setДатаВзятия(Date датаВзятия) {
        this.датаВзятия = датаВзятия;
    }

    @Basic
    @Column(name = "id_зоопарка_берущего", nullable = true)
    public Integer getIdЗоопаркаБерущего() {
        return idЗоопаркаБерущего;
    }

    public void setIdЗоопаркаБерущего(Integer idЗоопаркаБерущего) {
        this.idЗоопаркаБерущего = idЗоопаркаБерущего;
    }

    @Basic
    @Column(name = "ФИО_берущего", nullable = true, length = 50)
    public String getФиоБерущего() {
        return фиоБерущего;
    }

    public void setФиоБерущего(String фиоБерущего) {
        this.фиоБерущего = фиоБерущего;
    }

    @Basic
    @Column(name = "Цель", nullable = false, length = -1)
    public String getЦель() {
        return цель;
    }

    public void setЦель(String цель) {
        this.цель = цель;
    }

    @Basic
    @Column(name = "Цена_услуги", nullable = true, precision = 0)
    public Double getЦенаУслуги() {
        return ценаУслуги;
    }

    public void setЦенаУслуги(Double ценаУслуги) {
        this.ценаУслуги = ценаУслуги;
    }

    @Basic
    @Column(name = "Дата_возврата", nullable = true)
    public Date getДатаВозврата() {
        return датаВозврата;
    }

    public void setДатаВозврата(Date датаВозврата) {
        this.датаВозврата = датаВозврата;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalRential that = (AnimalRential) o;
        return idПроката == that.idПроката &&
                idЗоопаркаДающего == that.idЗоопаркаДающего &&
                Objects.equals(датаВзятия, that.датаВзятия) &&
                Objects.equals(idЗоопаркаБерущего, that.idЗоопаркаБерущего) &&
                Objects.equals(фиоБерущего, that.фиоБерущего) &&
                Objects.equals(цель, that.цель) &&
                Objects.equals(ценаУслуги, that.ценаУслуги) &&
                Objects.equals(датаВозврата, that.датаВозврата);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idПроката, idЗоопаркаДающего, датаВзятия, idЗоопаркаБерущего, фиоБерущего, цель, ценаУслуги, датаВозврата);
    }

    @Basic
    @Column(name = "id_животного", nullable = false)
    public int getIdЖивотного() {
        return idЖивотного;
    }

    public void setIdЖивотного(int idЖивотного) {
        this.idЖивотного = idЖивотного;
    }
}
