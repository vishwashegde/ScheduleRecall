package com.manh.schedulerecall.mapper;

import com.manh.schedulerecall.dto.ShipmentTenderDTO;
import com.manh.schedulerecall.entity.ShipmentTenderEntity;
import com.manh.schedulerecall.enums.PickupStatusEnum;
import com.manh.schedulerecall.util.DateTimeUtil;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTenderEntityDTOMapper {

    public ShipmentTenderDTO mapEntityToDTO(ShipmentTenderEntity shipmentTenderEntity) {
        return ShipmentTenderDTO.builder()
                .pk(shipmentTenderEntity.getPk()+"")
                .shipmentId(shipmentTenderEntity.getShipmentId())
                .serviceLevelId(shipmentTenderEntity.getServiceLevelId())
                .carrierId(shipmentTenderEntity.getCarrierId())
                .modeId(shipmentTenderEntity.getModeId())
                .equipmentId(shipmentTenderEntity.getEquipmentId())
                .acceptedTime(DateTimeUtil.formatDateTimeWithSecond(shipmentTenderEntity.getAcceptedTime()))
                .pickupResponseTime(DateTimeUtil.formatDateTimeWithSecond(shipmentTenderEntity.getPickupResponseTime()))
                .createdTime(DateTimeUtil.formatDateTimeWithSecond(shipmentTenderEntity.getCreatedTime()))
                .updatedTime(DateTimeUtil.formatDateTimeWithSecond(shipmentTenderEntity.getUpdatedTime()))
                .build();
    }

    public ShipmentTenderEntity mapDTOToEntity(ShipmentTenderDTO shipmentTenderDTO){
        ShipmentTenderEntity shipmentTenderEntity = new ShipmentTenderEntity();
        shipmentTenderEntity.setShipmentId(shipmentTenderDTO.getShipmentId());
        shipmentTenderEntity.setModeId(shipmentTenderDTO.getModeId());
        shipmentTenderEntity.setEquipmentId(shipmentTenderDTO.getEquipmentId());
        shipmentTenderEntity.setCarrierId(shipmentTenderDTO.getCarrierId());
        shipmentTenderEntity.setServiceLevelId(shipmentTenderDTO.getServiceLevelId());
        shipmentTenderEntity.setAcceptedTime(DateTimeUtil.formatStringToTimestamp(shipmentTenderDTO.getAcceptedTime()));
        shipmentTenderEntity.setPickupStatus(PickupStatusEnum.PENDING.getStatus());
        return shipmentTenderEntity;
    }
}
