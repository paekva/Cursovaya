package ru.iad.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Тип_деятельности", schema = "s225138", catalog = "studs")
public class ActivityType {
    private int idТипаДеятельности;
    private String названиеТипаДеятельности;
    private String описаниеДеятельности;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_типа_деятельности", nullable = false)
    public int getIdТипаДеятельности() {
        return idТипаДеятельности;
    }

    public void setIdТипаДеятельности(int idТипаДеятельности) {
        this.idТипаДеятельности = idТипаДеятельности;
    }

    @Basic
    @Column(name = "Название_типа_деятельности", nullable = false, length = 50)
    public String getНазваниеТипаДеятельности() {
        return названиеТипаДеятельности;
    }

    public void setНазваниеТипаДеятельности(String названиеТипаДеятельности) {
        this.названиеТипаДеятельности = названиеТипаДеятельности;
    }

    @Basic
    @Column(name = "Описание_деятельности", nullable = true, length = -1)
    public String getОписаниеДеятельности() {
        return описаниеДеятельности;
    }

    public void setОписаниеДеятельности(String описаниеДеятельности) {
        this.описаниеДеятельности = описаниеДеятельности;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityType that = (ActivityType) o;
        return idТипаДеятельности == that.idТипаДеятельности &&
                Objects.equals(названиеТипаДеятельности, that.названиеТипаДеятельности) &&
                Objects.equals(описаниеДеятельности, that.описаниеДеятельности);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idТипаДеятельности, названиеТипаДеятельности, описаниеДеятельности);
    }
}
