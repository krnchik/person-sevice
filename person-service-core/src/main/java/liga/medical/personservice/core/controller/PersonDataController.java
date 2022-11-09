package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.annotation.DbLog;
import liga.medical.personservice.core.dto.PersonDataDto;
import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.mapper.PersonDataMapper;
import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.service.api.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonDataController {

    private final PersonDataService service;

    private final PersonDataMapper mapper;

    @Autowired
    public PersonDataController(PersonDataService service, PersonDataMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    @DbLog
    public ResponseEntity<List<PersonDataDto>> getAllContacts() {
        List<PersonData> personData = service.findAll();
        return new ResponseEntity<>(mapper.toDtoList(personData), HttpStatus.OK);
    }

    @PostMapping("/save")
    @DbLog
    public ResponseEntity<PersonDataDto> save(@RequestBody PersonDataDto personDataDto) {
        service.save(mapper.toEntity(personDataDto));
        return new ResponseEntity<>(personDataDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @DbLog
    public ResponseEntity<PersonDataDto> findById(@PathVariable("id") Long id) {
        try {
            PersonData personData = service.findById(id);
            return new ResponseEntity<>(mapper.toDto(personData), HttpStatus.OK);
        } catch (NoElementInDbException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/delete/{id}")
    @DbLog
    public ResponseEntity<PersonDataDto> deleteById(@PathVariable("id") Long id) {
        try {
            PersonData personData = service.findById(id);
            service.deleteById(id);
            return new ResponseEntity<>(mapper.toDto(personData), HttpStatus.OK);
        } catch (NoElementInDbException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{firstName}/{lastName}")
    @DbLog
    public ResponseEntity<List<PersonDataDto>> findByFirstNameAndLastName(@PathVariable("firstName") String firstName,
                                                                          @PathVariable("lastName") String lastName) {
        List<PersonData> personData = service.findByFirstNameAndLastName(firstName, lastName);
        return new ResponseEntity<>(mapper.toDtoList(personData), HttpStatus.OK);
    }

    @PostMapping("/update/")
    @ResponseBody
    @DbLog
    public ResponseEntity<PersonDataDto> updateById(@RequestBody PersonDataDto personDataDto) {
        try {
            service.update(mapper.toEntity(personDataDto));
            return new ResponseEntity<>(personDataDto, HttpStatus.OK);
        } catch (NoElementInDbException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
