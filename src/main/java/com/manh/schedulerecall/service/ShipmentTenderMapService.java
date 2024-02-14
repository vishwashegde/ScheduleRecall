package com.manh.schedulerecall.service;

import com.manh.schedulerecall.dto.ShipmentTenderDTO;
import com.manh.schedulerecall.entity.ShipmentTenderEntity;
import com.manh.schedulerecall.mapper.ShipmentTenderEntityDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShipmentTenderMapService {
    @Autowired
    ShipmentTenderEntityDTOMapper shipmentTenderEntityDTOMapper;
    @Autowired
    ShipmentTenderService shipmentTenderService;
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public ShipmentTenderDTO saveShipmentDetails(ShipmentTenderDTO shipmentTenderDTO) {
        ShipmentTenderEntity shipmentTenderEntityToSave = shipmentTenderEntityDTOMapper.mapDTOToEntity(shipmentTenderDTO);
        ShipmentTenderEntity savedShipmentTenderEntity = shipmentTenderService.saveShipmentDetails(shipmentTenderEntityToSave);
        return shipmentTenderEntityDTOMapper.mapEntityToDTO(savedShipmentTenderEntity);
    }

    public Page<ShipmentTenderDTO> findPendingShipments(int pageNum, int size) {
        Page<ShipmentTenderEntity> shipmentTenderEntities = shipmentTenderService.findPendingShipments(pageNum, size);
        return shipmentTenderEntities.map(entity -> shipmentTenderEntityDTOMapper.mapEntityToDTO(entity));
    }

    public Page<ShipmentTenderDTO> findAllShipments(int pageNum, int size) {
        Page<ShipmentTenderEntity> shipmentTenderEntities = shipmentTenderService.findAll(pageNum, size);
        return shipmentTenderEntities.map(entity -> shipmentTenderEntityDTOMapper.mapEntityToDTO(entity));
    }
    public ShipmentTenderDTO findByShipmentId(String shipmentId){
        return shipmentTenderEntityDTOMapper.mapEntityToDTO(shipmentTenderService.findByShipmentId(shipmentId));
    }
}
