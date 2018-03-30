package cursovaya.entities;

import javax.persistence.*;
import java.util.Date;

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

    @Id
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

        if (idЗоопарка != zoo.idЗоопарка) return false;
        if (датаОснования != null ? !датаОснования.equals(zoo.датаОснования) : zoo.датаОснования != null) return false;
        if (директор != null ? !директор.equals(zoo.директор) : zoo.директор != null) return false;
        if (количествоЖивотных != null ? !количествоЖивотных.equals(zoo.количествоЖивотных) : zoo.количествоЖивотных != null)
            return false;
        if (местоположение != null ? !местоположение.equals(zoo.местоположение) : zoo.местоположение != null)
            return false;
        if (название != null ? !название.equals(zoo.название) : zoo.название != null) return false;
        if (функциональность != null ? !функциональность.equals(zoo.функциональность) : zoo.функциональность != null)
            return false;
        if (штат != null ? !штат.equals(zoo.штат) : zoo.штат != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idЗоопарка;
        result = 31 * result + (датаОснования != null ? датаОснования.hashCode() : 0);
        result = 31 * result + (директор != null ? директор.hashCode() : 0);
        result = 31 * result + (количествоЖивотных != null ? количествоЖивотных.hashCode() : 0);
        result = 31 * result + (местоположение != null ? местоположение.hashCode() : 0);
        result = 31 * result + (название != null ? название.hashCode() : 0);
        result = 31 * result + (функциональность != null ? функциональность.hashCode() : 0);
        result = 31 * result + (штат != null ? штат.hashCode() : 0);
        return result;
    }
}
