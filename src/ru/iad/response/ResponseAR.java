package ru.iad.response;

public class ResponseAR {
    private String email;
    private String fio;
    private String animal;
    private String purpose;
    private String organisation;
    private String dateFrom;
    private String dateTo;

    public ResponseAR(String email, String fio, String animal, String purpose,
                      String organisation, String dateFrom, String dateTo) {
        this.email = email;
        this.fio = fio;
        this.animal = animal;
        this.purpose = purpose;
        this.organisation = organisation;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String getEmail() {
        return email;
    }

    public String getFio() {
        return fio;
    }

    public String getAnimal() {
        return animal;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }
}
