package ru.iad.restful.search;

import java.util.ArrayList;
import java.util.List;
//import static ru.pip.dao.crud.ComplexSearch.*;

/*@Path("/search")
@Stateless
public class AnimalSearchRequests {

    /*@EJB
    SimpleSearch ss;

    @GET
    public String animalsByName(){
        try {
            return ss.findAnimalsByName();
        }
        catch(Exception e)
        {
             e.printStackTrace();
        }
        return "hello";
    }*/

    /*
    @POST
    @Path("zoo/{zoo}")
    @Produces({"application/xml","application/json"})
    public List<Animal> findAnimalsByZoo(@PathParam("zoo") String zoo){
        Session session = mainBean.getSessionFactory().openSession();
        try {
            List<ЖивотныеEntity> animalList = searchAnimalByZoo(session,zoo);
            if(animalList == null) throw new Exception();

            List<Animal> animals = new ArrayList<Animal>();

            for (ЖивотныеEntity a: animalList) {
                ВидыЖивотныхEntity type = searchKindOfAnimalById(session, a.getIdВида());
                Animal newAnimal = new Animal(type.getНазвание(), a.getИмя(), a.getIdЖивотного());
                animals.add(newAnimal);
            }

            return animals;
        }
        catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("type/{type}")
    @Produces({"application/xml","application/json"})
    public List<Animal> findAnimalsByType(@PathParam("type") String type){
        Session session = mainBean.getSessionFactory().openSession();
        try {
            List<ЖивотныеEntity> animalList = searchAnimalByType(session,type);
            if(animalList == null) throw new Exception();

            List<Animal> animals = new ArrayList<Animal>();

            for (ЖивотныеEntity a: animalList) {
                Animal newAnimal = new Animal(type, a.getИмя(), a.getIdЖивотного());
                animals.add(newAnimal);
            }

            return animals;
        }
        catch (Exception e) {
            return null;
        }
    }

    @GET
    @Path("animal/{id}")
    @Produces({"application/xml","application/json"})
    public ResponseAnimal findAnimal(@PathParam("id") Integer id){

        Session session =  mainBean.getSessionFactory().openSession();
        try {
            ЖивотныеEntity foundAnimal = searchAnimalById(session,id);
            if(foundAnimal == null) throw new Exception("Animal not found");

            String spicies = searchKindOfAnimalById(session,foundAnimal.getIdВида()).getНазвание();
            long age = System.currentTimeMillis() - foundAnimal.getДатаРождения().getTime();
            Integer newAge = (int)(age / (60*60*60*24*365));

            // У площадки есть id зоопарка, оттуда его и берем

            String dadStr;
            ЖивотныеEntity dad = searchAnimalById(session,foundAnimal.getIdПапы());
            if(dad == null) dadStr = "Неизвестно";
            else dadStr = dad.getИмя();

            String mumStr;
            ЖивотныеEntity mum = searchAnimalById(session,foundAnimal.getIdПапы());
            if(dad == null) mumStr = "Неизвестно";
            else mumStr = mum.getИмя();

            ResponseAnimal animal = new ResponseAnimal(foundAnimal.getИмя(), spicies, newAge, "Place 3", "Zoo 2", dadStr, mumStr, foundAnimal.getОсобенности());
            List<УпоминанияОЗоопаркеEntity> foundList = searchMentioningByAnimal(session,foundAnimal.getIdЖивотного());
            for (УпоминанияОЗоопаркеEntity m: foundList) {
                animal.getMentions().add(m.getНазваниеУпоминания());
            }

            return animal;
        }
        catch (Exception e) {
            return null;
        }
    }*/
//}

class AnimalHelp
{
    private String name;
    private String type;
    private Integer id;

    public AnimalHelp(String name, String type, Integer id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }
}

class ResponseAnimal
{
    private String name;
    private String spicies;
    private Integer age;
    private String place;
    private String zoo;
    private String dad;
    private String mum;
    private String info;
    private List<String> mentions;

    public List<String> getMentions() {
        return mentions;
    }
    public ResponseAnimal(String name, String spicies, Integer age, String place, String zoo, String dad, String mum, String info) {
        this.name = name;
        this.spicies = spicies;
        this.age = age;
        this.place = place;
        this.zoo = zoo;
        this.dad = dad;
        this.mum = mum;
        this.info = info;
        this.mentions = new ArrayList<String>();
    }
}