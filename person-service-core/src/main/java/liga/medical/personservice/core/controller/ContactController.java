package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.ContactDto;
import liga.medical.personservice.core.mapper.ContactMapper;
import liga.medical.personservice.core.model.Contact;
import liga.medical.personservice.core.service.api.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService service;
    private final ContactMapper mapper;

    @Autowired
    public ContactController(ContactService service, ContactMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        List<Contact> contacts = service.findAll();
        return new ResponseEntity<>(mapper.toDtoList(contacts), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ContactDto> save(@RequestBody ContactDto contactDto) {
        service.save(mapper.toEntity(contactDto));
        return new ResponseEntity<>(contactDto, HttpStatus.OK);
    }
}
