package ru.iad.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Упоминания_о_зоопарке", schema = "s225138", catalog = "studs")
public class Mentions {
    private int idУпоминания;
    private String названиеУпоминания;
    private int idВидаУпоминания;
    private Integer idЗоопарка;
    private int idЖивотного;
    private Integer idСотрудника;
    private Date датаПубликации;

    @Id
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
    @Column(name = "id_вида_упоминания", nullable = false)
    public int getIdВидаУпоминания() {
        return idВидаУпоминания;
    }

    public void setIdВидаУпоминания(int idВидаУпоминания) {
        this.idВидаУпоминания = idВидаУпоминания;
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
    @Column(name = "id_животного", nullable = false)
    public int getIdЖивотного() {
        return idЖивотного;
    }

    public void setIdЖивотного(int idЖивотного) {
        this.idЖивотного = idЖивотного;
    }

    @Basic
    @Column(name = "id_сотрудника", nullable = true)
    public Integer getIdСотрудника() {
        return idСотрудника;
    }

    public void setIdСотрудника(Integer idСотрудника) {
        this.idСотрудника = idСотрудника;
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
        Mentions mentions = (Mentions) o;
        return idУпоминания == mentions.idУпоминания &&
                idВидаУпоминания == mentions.idВидаУпоминания &&
                idЖивотного == mentions.idЖивотного &&
                Objects.equals(названиеУпоминания, mentions.названиеУпоминания) &&
                Objects.equals(idЗоопарка, mentions.idЗоопарка) &&
                Objects.equals(idСотрудника, mentions.idСотрудника) &&
                Objects.equals(датаПубликации, mentions.датаПубликации);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idУпоминания, названиеУпоминания, idВидаУпоминания, idЗоопарка, idЖивотного, idСотрудника, датаПубликации);
    }
}
