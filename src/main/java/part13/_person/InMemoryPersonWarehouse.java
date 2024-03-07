package part13._person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class InMemoryPersonWarehouse implements PersonWarehouse {
    private final ArrayList<Person> persons;

    public InMemoryPersonWarehouse() {
        this.persons = new ArrayList<>();
    }

    @Override
    public void save(Person person) {
        this.persons.add(person);
    }

    @Override
    public Person search(String socialSecurityNumber) {
        for (Person p : this.persons) {
            if (p.getSocialSecurityNumber().equals(socialSecurityNumber)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public void delete(Person person) {
        this.persons.remove(person);
    }

    public void delete(String socialSecurityNumber) {
        Iterator<Person> personIterator = this.persons.iterator();

        while(personIterator.hasNext()) {
            Person p = personIterator.next();
            if (p.getSocialSecurityNumber().equals(socialSecurityNumber)) {
                personIterator.remove();
            }
        }
    }

    @Override
    public void deleteAll() {
        this.persons.clear();
    }

    @Override
    public Collection<Person> getAll() {
        return this.persons;
    }
}
