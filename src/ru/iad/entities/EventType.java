package ru.iad.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Типы_мероприятий", schema = "s225138", catalog = "studs")
public class EventType {
    private int idТипаМероприятия;
    private String названиеТипаМероприятия;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_типа_мероприятия", nullable = false)
    public int getIdТипаМероприятия() {
        return idТипаМероприятия;
    }

    public void setIdТипаМероприятия(int idТипаМероприятия) {
        this.idТипаМероприятия = idТипаМероприятия;
    }

    @Basic
    @Column(name = "Название_типа_мероприятия", nullable = false, length = 50)
    public String getНазваниеТипаМероприятия() {
        return названиеТипаМероприятия;
    }

    public void setНазваниеТипаМероприятия(String названиеТипаМероприятия) {
        this.названиеТипаМероприятия = названиеТипаМероприятия;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventType eventType = (EventType) o;
        return idТипаМероприятия == eventType.idТипаМероприятия &&
                Objects.equals(названиеТипаМероприятия, eventType.названиеТипаМероприятия);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idТипаМероприятия, названиеТипаМероприятия);
    }
}
