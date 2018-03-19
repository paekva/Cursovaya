package ru.iad.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Виды_упоминаний", schema = "s225138", catalog = "studs")
public class MentionType {
    private int idВидаУпоминания;
    private String названиеВидаУпоминания;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_вида_упоминания", nullable = false)
    public int getIdВидаУпоминания() {
        return idВидаУпоминания;
    }

    public void setIdВидаУпоминания(int idВидаУпоминания) {
        this.idВидаУпоминания = idВидаУпоминания;
    }

    @Basic
    @Column(name = "Название_вида_упоминания", nullable = false, length = 50)
    public String getНазваниеВидаУпоминания() {
        return названиеВидаУпоминания;
    }

    public void setНазваниеВидаУпоминания(String названиеВидаУпоминания) {
        this.названиеВидаУпоминания = названиеВидаУпоминания;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentionType that = (MentionType) o;
        return idВидаУпоминания == that.idВидаУпоминания &&
                Objects.equals(названиеВидаУпоминания, that.названиеВидаУпоминания);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idВидаУпоминания, названиеВидаУпоминания);
    }
}
