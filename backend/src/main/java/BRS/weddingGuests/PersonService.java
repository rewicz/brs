package BRS.weddingGuests;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;

  public Iterable<Person> getAll() {
    Iterable<Person> personsList = personRepository.findAll();

    return personsList;
  }
  public Person getById(Long id) {
    Person person = personRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND));

    return person;
  }
  public Long createPerson(Person personDto) {
    Person person = personRepository.save(personDto);

    return person.getId();
  }
  public void putPerson(Person personDto) {
    Person existingPerson = personRepository.findById(personDto.getId())
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND));

    existingPerson.setName(personDto.getName());

    personRepository.save(existingPerson);
  }
  public void deletePerson(Long id) {
    personRepository.deleteById(id);
  }
}
