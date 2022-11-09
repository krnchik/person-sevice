package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.annotation.DbLog;
import liga.medical.personservice.core.dto.MedicalCardDto;
import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.mapper.MedicalCardMapper;
import liga.medical.personservice.core.service.api.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicalcard")
public class MedicalCardController {

    private final MedicalCardService service;
    private final MedicalCardMapper mapper;

    @Autowired
    public MedicalCardController(MedicalCardService service, MedicalCardMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/update/")
    @ResponseBody
    @DbLog
    public ResponseEntity<MedicalCardDto> updateById(@RequestBody MedicalCardDto medicalCardDto) {
        try {
            service.update(mapper.toEntity(medicalCardDto));
            return new ResponseEntity<>(medicalCardDto, HttpStatus.OK);
        } catch (NoElementInDbException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
