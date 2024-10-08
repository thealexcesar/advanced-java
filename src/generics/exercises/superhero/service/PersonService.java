package generics.exercises.superhero.service;

import generics.exercises.superhero.domain.model.Person;
import generics.exercises.superhero.domain.repository.PersonRepository;

public class PersonService<T extends Person> {
    private final PersonRepository<T> repository;

    public PersonService(PersonRepository<T> repository) {
        this.repository = repository;
    }

    public void add(T person) {
        repository.add(person);
    }

    public void remove(T person) {
        repository.remove(person);
    }

    public void printAllPeople() {
        repository.printPeople();
    }
}
