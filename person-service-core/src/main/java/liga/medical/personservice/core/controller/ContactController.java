package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.ContactDto;
import liga.medical.personservice.core.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ContactController {

    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping("/contact/all")
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        List<ContactDto> contactDtos = service.findAll()
                .stream()
                .map(ContactDto::fromContact)
                .collect(Collectors.toList());
        return new ResponseEntity<>(contactDtos, HttpStatus.OK);
    }

    @PostMapping("/contact/save")
    public ResponseEntity<ContactDto> save(@RequestBody ContactDto contact) {
        service.save(contact.convertToContact());
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
}
