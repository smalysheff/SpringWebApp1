package ru.smal.dao;

import org.springframework.stereotype.Component;
import ru.smal.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private List<Person>  people;

    {
        people = new ArrayList<>();
        people.add(new Person(1, "Ivan"));
        people.add(new Person(2, "Stepan"));
        people.add(new Person(3, "Sergey"));
        people.add(new Person(4, "Leo"));
        people.add(new Person(5, "Nikita"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
