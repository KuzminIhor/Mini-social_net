package ua.springcourse.dao;

import org.springframework.stereotype.Component;
import ua.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT,"Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(people -> people.getId() == id).findAny().orElse(null);
    }

    public void update(Person person, int id) {
        person.setId(id);
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == person.getId()) {
                people.set(i, person);
                break;
            }
        }
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
