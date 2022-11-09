package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.annotation.DbLog;
import liga.medical.personservice.core.dto.ContactDto;
import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.mapper.ContactMapper;
import liga.medical.personservice.core.service.api.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/update/")
    @ResponseBody
    @DbLog
    public ResponseEntity<ContactDto> updateById(@RequestBody ContactDto contactDto) {
        try {
            service.update(mapper.toEntity(contactDto));
            return new ResponseEntity<>(contactDto, HttpStatus.OK);
        } catch (NoElementInDbException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
