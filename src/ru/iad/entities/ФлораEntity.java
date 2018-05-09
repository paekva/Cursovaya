package ru.iad.entities;

public class ФлораEntity {
    private int idВидаРастения;
    private String названиеВида;
    private String особенностиВида;

    public int getIdВидаРастения() {
        return idВидаРастения;
    }

    public void setIdВидаРастения(int idВидаРастения) {
        this.idВидаРастения = idВидаРастения;
    }

    public String getНазваниеВида() {
        return названиеВида;
    }

    public void setНазваниеВида(String названиеВида) {
        this.названиеВида = названиеВида;
    }

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

        ФлораEntity that = (ФлораEntity) o;

        if (idВидаРастения != that.idВидаРастения) return false;
        if (названиеВида != null ? !названиеВида.equals(that.названиеВида) : that.названиеВида != null) return false;
        if (особенностиВида != null ? !особенностиВида.equals(that.особенностиВида) : that.особенностиВида != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idВидаРастения;
        result = 31 * result + (названиеВида != null ? названиеВида.hashCode() : 0);
        result = 31 * result + (особенностиВида != null ? особенностиВида.hashCode() : 0);
        return result;
    }
}
