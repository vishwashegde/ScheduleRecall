package com.manh.schedulerecall.controller;

import com.manh.schedulerecall.dto.CarrierResponseTimeDTO;
import com.manh.schedulerecall.service.CarrierResponseTimeMapService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrierresponsetime")
public class CarrierResponseTimeController {
    @Autowired
    CarrierResponseTimeMapService carrierResponseTimeMapService;

    @GetMapping(value = "/findAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Page<CarrierResponseTimeDTO>> findAll(@RequestParam(value = "size", required = false) String sizeStr, @RequestParam(value = "page", required = false) String pageNumberStr) {
        int size;
        int pageNumber;
        size = StringUtils.isNumeric(sizeStr) ? Integer.parseInt(sizeStr) : 20;
        pageNumber = StringUtils.isNumeric(pageNumberStr) ? Integer.parseInt(pageNumberStr) : 0;
        Page<CarrierResponseTimeDTO> page = carrierResponseTimeMapService.findAll(pageNumber, size);
        if (page != null && page.getContent() != null && !page.getContent().isEmpty()) {
            return ResponseEntity.ok().body(page);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CarrierResponseTimeDTO> saveCarrierResponse(@RequestBody CarrierResponseTimeDTO carrierResponseTimeDTO) {
        CarrierResponseTimeDTO savedCarrierResponseTimeDTO = carrierResponseTimeMapService.save(carrierResponseTimeDTO);
        if(StringUtils.isEmpty(savedCarrierResponseTimeDTO.getCarrierId())){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().body(savedCarrierResponseTimeDTO);
    }

}
