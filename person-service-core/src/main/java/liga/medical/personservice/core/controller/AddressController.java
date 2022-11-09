package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.annotation.DbLog;
import liga.medical.personservice.core.dto.AddressDto;
import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.mapper.AddressMapper;
import liga.medical.personservice.core.service.api.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService service;
    private final AddressMapper mapper;

    @Autowired
    public AddressController(AddressService service, AddressMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/update/")
    @ResponseBody
    @DbLog
    public ResponseEntity<AddressDto> updateById(@RequestBody AddressDto addressDto) {
        try {
            service.update(mapper.toEntity(addressDto));
            return new ResponseEntity<>(addressDto, HttpStatus.OK);
        } catch (NoElementInDbException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
