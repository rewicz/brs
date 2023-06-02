package BRS.weddingGuests;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

  private final PersonService personService;
  @GetMapping
  Iterable<Person> getAll() {
    return personService.getAll();
  }
  @GetMapping("/{id}")
  Person getPerson(@PathVariable Long id) {
    return personService.getById(id);
  }
  @PutMapping
  void putPerson(@RequestBody Person inputDTO) {
    personService.putPerson(inputDTO);
  }
  @PostMapping
  Long createPerson(@RequestBody Person inputDTO) {
    return personService.createPerson(inputDTO);
  }

  @DeleteMapping("/{id}")
  void deletePerson(@PathVariable Long id) {
    personService.deletePerson(id);
  }


}
