package ru.iad.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Флора", schema = "s225138", catalog = "studs")
public class Flora {
    private int idВидаРастения;
    private String названиеВида;
    private String особенностиВида;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        Flora flora = (Flora) o;
        return idВидаРастения == flora.idВидаРастения &&
                Objects.equals(названиеВида, flora.названиеВида) &&
                Objects.equals(особенностиВида, flora.особенностиВида);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idВидаРастения, названиеВида, особенностиВида);
    }
}
