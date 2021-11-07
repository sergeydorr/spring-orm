package people.controller;

import people.model.Person;
import people.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person getPerson(@PathVariable long id) {
        return this.personRepository.findById(id);
    }

    @GetMapping(path = "")
    public Iterable<Person> getPeople() {
        return this.personRepository.findAll();
    }


    @PostMapping(path = "")
    public String addPerson(@RequestBody Person person) {
        this.personRepository.save(person);
        return "Person succesfully added!";
    }

    @DeleteMapping(path = "/{id}")
    public String removePerson(@PathVariable long id) {
        this.personRepository.deleteById(id);
        return String.format("Person with id %s was succesfully deleted!", id);
    }

    @PatchMapping(path = "/{id}")
    public String updatePerson(@RequestBody Person incomingPerson, @PathVariable(name = "id") long id) {
        Person existingPerson = this.personRepository.findById(id);
        incomingPerson.setId(existingPerson.getId());
        this.personRepository.save(incomingPerson);
        return String.format("Person with id %s was succesfully updated!", id);
    }
}
