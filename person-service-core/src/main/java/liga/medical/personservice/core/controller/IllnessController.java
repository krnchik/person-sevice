package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.annotation.DbLog;
import liga.medical.personservice.core.dto.IllnessDto;
import liga.medical.personservice.core.exception.NoElementInDbException;
import liga.medical.personservice.core.mapper.IllnessMapper;
import liga.medical.personservice.core.service.api.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/illness")
public class IllnessController {

    private final IllnessService service;
    private final IllnessMapper mapper;

    @Autowired
    public IllnessController(IllnessService service, IllnessMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/update/")
    @ResponseBody
    @DbLog
    public ResponseEntity<IllnessDto> updateById(@RequestBody IllnessDto illnessDto) {
        try {
            service.update(mapper.toEntity(illnessDto));
            return new ResponseEntity<>(illnessDto, HttpStatus.OK);
        } catch (NoElementInDbException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
