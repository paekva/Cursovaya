package ru.iad.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Животные", schema = "s225138", catalog = "studs")
public class Animals {
    private int idЖивотного;
    private String имя;
    private Date датаРождения;
    private String особенности;
    private String состояние;
    private int idВида;
    private Integer idПапы;
    private Integer idМамы;

    public void setДатаРождения(java.sql.Date датаРождения) {
        this.датаРождения = датаРождения;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_животного", nullable = false)
    public int getIdЖивотного() {
        return idЖивотного;
    }

    public void setIdЖивотного(int idЖивотного) {
        this.idЖивотного = idЖивотного;
    }

    @Basic
    @Column(name = "Имя", nullable = false, length = 50)
    public String getИмя() {
        return имя;
    }

    public void setИмя(String имя) {
        this.имя = имя;
    }

    @Basic
    @Column(name = "Дата_рождения", nullable = true)
    public Date getДатаРождения() {
        return датаРождения;
    }

    public void setДатаРождения(Date датаРождения) {
        this.датаРождения = датаРождения;
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
    @Column(name = "Состояние", nullable = false, length = 10)
    public String getСостояние() {
        return состояние;
    }

    public void setСостояние(String состояние) {
        this.состояние = состояние;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return idЖивотного == animals.idЖивотного &&
                Objects.equals(имя, animals.имя) &&
                Objects.equals(датаРождения, animals.датаРождения) &&
                Objects.equals(особенности, animals.особенности) &&
                Objects.equals(состояние, animals.состояние);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idЖивотного, имя, датаРождения, особенности, состояние);
    }

    @Basic
    @Column(name = "id_вида", nullable = false)
    public int getIdВида() {
        return idВида;
    }

    public void setIdВида(int idВида) {
        this.idВида = idВида;
    }

    @Basic
    @Column(name = "id_папы", nullable = true)
    public Integer getIdПапы() {
        return idПапы;
    }

    public void setIdПапы(Integer idПапы) {
        this.idПапы = idПапы;
    }

    @Basic
    @Column(name = "id_мамы", nullable = true)
    public Integer getIdМамы() {
        return idМамы;
    }

    public void setIdМамы(Integer idМамы) {
        this.idМамы = idМамы;
    }
}
