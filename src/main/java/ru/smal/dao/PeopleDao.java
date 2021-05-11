package ru.smal.dao;

import org.springframework.stereotype.Component;
import ru.smal.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDao {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Nikita"));
        people.add(new Person(++PEOPLE_COUNT, "Ksenia"));
        people.add(new Person(++PEOPLE_COUNT, "Alex"));
        people.add(new Person(++PEOPLE_COUNT, "James"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

}
