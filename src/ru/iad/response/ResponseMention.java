package ru.iad.response;

import java.util.Date;

public class ResponseMention {
        private String name;
        private String type;
        private Date date;
        private String animal;
        private String zoo;
        private String worker;

        public ResponseMention(String name, String type, Date date, String animal, String zoo, String worker) {
            this.name = name;
            this.type = type;
            this.date = date;
            this.animal = animal;
            this.zoo = zoo;
            this.worker = worker;
        }
}
