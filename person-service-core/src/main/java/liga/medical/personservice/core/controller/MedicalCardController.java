package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.MedicalCardDto;
import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.service.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalCardController {

    final MedicalCardService service;

    @Autowired
    public MedicalCardController(MedicalCardService service) {
        this.service = service;
    }

    @PostMapping("/medicalcard/save")
    public ResponseEntity<MedicalCardDto> save(@RequestBody MedicalCardDto medicalCardDto) {
        MedicalCard medicalCard = medicalCardDto.convertToMedicalCard();
        service.save(medicalCard);
        return new ResponseEntity<>(medicalCardDto, HttpStatus.OK);
    }

    @GetMapping("/medicalcard/{id}")
    @ResponseBody
    public ResponseEntity<MedicalCardDto> findById(@PathVariable("id") Long id) {
        MedicalCard medicalCard = service.findById(id);
        if (medicalCard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        MedicalCardDto medicalCardDto = new MedicalCardDto();
        return new ResponseEntity<>(medicalCardDto.fromMedicalCard(medicalCard), HttpStatus.OK);
    }
}
