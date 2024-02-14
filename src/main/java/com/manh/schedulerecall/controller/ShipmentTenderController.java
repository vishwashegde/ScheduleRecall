package com.manh.schedulerecall.controller;

import com.manh.schedulerecall.dto.ShipmentTenderDTO;
import com.manh.schedulerecall.service.ShipmentTenderMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/api/shipmenttender")
public class ShipmentTenderController {
    @Autowired
    ShipmentTenderMapService shipmentTenderMapService;

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ShipmentTenderDTO> saveShipmentDetails(@RequestBody ShipmentTenderDTO shipmentTenderDTO) {
        return ResponseEntity.ok().body(shipmentTenderMapService.saveShipmentDetails(shipmentTenderDTO));
    }

    @GetMapping(value = "/findPending", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Page<ShipmentTenderDTO>> findPending(@RequestParam(required = false, defaultValue = "0") String pageNum, @RequestParam(required = false, defaultValue = "20") String size) {
        Page<ShipmentTenderDTO> pendingShipments = shipmentTenderMapService.findPendingShipments(Integer.parseInt(pageNum), Integer.parseInt(size));
        if(pendingShipments!=null && pendingShipments.getContent()!=null && !pendingShipments.getContent().isEmpty()){
            return ResponseEntity.ok().body(pendingShipments);
        }
        else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @GetMapping(value = "/findAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Page<ShipmentTenderDTO>> findAll(@RequestParam(required = false, defaultValue = "0") String pageNum, @RequestParam(required = false, defaultValue = "20") String size){
        Page<ShipmentTenderDTO> allShipments = shipmentTenderMapService.findAllShipments(Integer.parseInt(pageNum), Integer.parseInt(size));
        if(allShipments!=null && allShipments.getContent()!=null && !allShipments.getContent().isEmpty()){
            return ResponseEntity.ok().body(allShipments);
        }
        else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(value = "/findByShipmentId", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ShipmentTenderDTO> findByShipmentId(@RequestParam(name = "ShipmentId") String shipmentId){
        ShipmentTenderDTO shipmentTenderDTO = shipmentTenderMapService.findByShipmentId(shipmentId);
        if(Objects.isNull(shipmentTenderDTO)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.ok().body(shipmentTenderDTO);
        }
    }
}
