package ru.smal.dao;

import org.springframework.stereotype.Component;
import ru.smal.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDao {

    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(1, "Nikita"));
        people.add(new Person(2, "Ksenia"));
        people.add(new Person(3, "Alex"));
        people.add(new Person(4, "James"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

}
