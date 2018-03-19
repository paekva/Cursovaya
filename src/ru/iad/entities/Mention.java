package ru.iad.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Упоминания_о_зоопарке", schema = "s225138", catalog = "studs")
public class Mention {
    private int idУпоминания;
    private String названиеУпоминания;
    private Integer idЗоопарка;
    private Date датаПубликации;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_упоминания", nullable = false)
    public int getIdУпоминания() {
        return idУпоминания;
    }

    public void setIdУпоминания(int idУпоминания) {
        this.idУпоминания = idУпоминания;
    }

    @Basic
    @Column(name = "Название_упоминания", nullable = false, length = 50)
    public String getНазваниеУпоминания() {
        return названиеУпоминания;
    }

    public void setНазваниеУпоминания(String названиеУпоминания) {
        this.названиеУпоминания = названиеУпоминания;
    }

    @Basic
    @Column(name = "id_зоопарка", nullable = true)
    public Integer getIdЗоопарка() {
        return idЗоопарка;
    }

    public void setIdЗоопарка(Integer idЗоопарка) {
        this.idЗоопарка = idЗоопарка;
    }

    @Basic
    @Column(name = "Дата_публикации", nullable = true)
    public Date getДатаПубликации() {
        return датаПубликации;
    }

    public void setДатаПубликации(Date датаПубликации) {
        this.датаПубликации = датаПубликации;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mention mention = (Mention) o;
        return idУпоминания == mention.idУпоминания &&
                Objects.equals(названиеУпоминания, mention.названиеУпоминания) &&
                Objects.equals(idЗоопарка, mention.idЗоопарка) &&
                Objects.equals(датаПубликации, mention.датаПубликации);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idУпоминания, названиеУпоминания, idЗоопарка, датаПубликации);
    }
}
