package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.MedicalCardDto;
import liga.medical.personservice.core.exception.NoElementInDb;
import liga.medical.personservice.core.mapper.MedicalCardMapper;
import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.service.api.MedicalCardService;
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

    @PostMapping("/save")
    public ResponseEntity<MedicalCardDto> save(@RequestBody MedicalCardDto medicalCardDto) {
        service.save(mapper.toEntity(medicalCardDto));
        return new ResponseEntity<>(medicalCardDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<MedicalCardDto> findById(@PathVariable("id") Long id) {
        try {
            MedicalCard medicalCard = service.findById(id);
            return new ResponseEntity<>(mapper.toDto(medicalCard), HttpStatus.OK);
        } catch (NoElementInDb e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
