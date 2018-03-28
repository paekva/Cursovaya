package ru.iad.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Флора {
    private int idВидаРастения;
    private String названиеВида;
    private String особенностиВида;

    @Id
    @Column(name = "id_вида_растения", nullable = false)
    public int getIdВидаРастения() {
        return idВидаРастения;
    }

    public void setIdВидаРастения(int idВидаРастения) {
        this.idВидаРастения = idВидаРастения;
    }

    @Basic
    @Column(name = "Название_вида", nullable = false, length = 50)
    public String getНазваниеВида() {
        return названиеВида;
    }

    public void setНазваниеВида(String названиеВида) {
        this.названиеВида = названиеВида;
    }

    @Basic
    @Column(name = "Особенности_вида", nullable = true, length = -1)
    public String getОсобенностиВида() {
        return особенностиВида;
    }

    public void setОсобенностиВида(String особенностиВида) {
        this.особенностиВида = особенностиВида;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Флора флора = (Флора) o;
        return idВидаРастения == флора.idВидаРастения &&
                Objects.equals(названиеВида, флора.названиеВида) &&
                Objects.equals(особенностиВида, флора.особенностиВида);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idВидаРастения, названиеВида, особенностиВида);
    }
}
