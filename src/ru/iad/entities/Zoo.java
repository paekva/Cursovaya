package ru.iad.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Зоопарки", schema = "s225138", catalog = "studs")
public class Zoo {
    private int idЗоопарка;
    private Date датаОснования;
    private String директор;
    private Integer количествоЖивотных;
    private String местоположение;
    private String название;
    private String функциональность;
    private Integer штат;

    public void setДатаОснования(Timestamp датаОснования) {
        this.датаОснования = датаОснования;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_зоопарка", nullable = false)
    public int getIdЗоопарка() {
        return idЗоопарка;
    }

    public void setIdЗоопарка(int idЗоопарка) {
        this.idЗоопарка = idЗоопарка;
    }

    @Basic
    @Column(name = "Дата_основания", nullable = true)
    public Date getДатаОснования() {
        return датаОснования;
    }

    public void setДатаОснования(Date датаОснования) {
        this.датаОснования = датаОснования;
    }

    @Basic
    @Column(name = "Директор", nullable = false, length = 30)
    public String getДиректор() {
        return директор;
    }

    public void setДиректор(String директор) {
        this.директор = директор;
    }

    @Basic
    @Column(name = "Количество_животных", nullable = true)
    public Integer getКоличествоЖивотных() {
        return количествоЖивотных;
    }

    public void setКоличествоЖивотных(Integer количествоЖивотных) {
        this.количествоЖивотных = количествоЖивотных;
    }

    @Basic
    @Column(name = "Местоположение", nullable = false, length = 50)
    public String getМестоположение() {
        return местоположение;
    }

    public void setМестоположение(String местоположение) {
        this.местоположение = местоположение;
    }

    @Basic
    @Column(name = "Название", nullable = false, length = 30)
    public String getНазвание() {
        return название;
    }

    public void setНазвание(String название) {
        this.название = название;
    }

    @Basic
    @Column(name = "Функциональность", nullable = false, length = 20)
    public String getФункциональность() {
        return функциональность;
    }

    public void setФункциональность(String функциональность) {
        this.функциональность = функциональность;
    }

    @Basic
    @Column(name = "Штат", nullable = true)
    public Integer getШтат() {
        return штат;
    }

    public void setШтат(Integer штат) {
        this.штат = штат;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo zoo = (Zoo) o;
        return idЗоопарка == zoo.idЗоопарка &&
                Objects.equals(датаОснования, zoo.датаОснования) &&
                Objects.equals(директор, zoo.директор) &&
                Objects.equals(количествоЖивотных, zoo.количествоЖивотных) &&
                Objects.equals(местоположение, zoo.местоположение) &&
                Objects.equals(название, zoo.название) &&
                Objects.equals(функциональность, zoo.функциональность) &&
                Objects.equals(штат, zoo.штат);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idЗоопарка, датаОснования, директор, количествоЖивотных, местоположение, название, функциональность, штат);
    }
}
