package com.manh.schedulerecall.mapper;

import com.manh.schedulerecall.dto.CarrierResponseTimeDTO;
import com.manh.schedulerecall.entity.CarrierResponseTimeEntity;
import com.manh.schedulerecall.util.DateTimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CarrierResponseEntityDTOMapper {

    public CarrierResponseTimeDTO mapEntityToDTO(CarrierResponseTimeEntity entity) {
        return CarrierResponseTimeDTO.builder()
                .pk(entity.getPk()+"")
                .responseTime(entity.getResponseTime().toString())
                .carrierId(entity.getCarrierId())
                .equipmentId(entity.getEquipmentId())
                .serviceLevelId(entity.getServiceLevelId())
                .modeId(entity.getModeId())
                .createdTime(DateTimeUtil.formatDateTimeWithSecond(entity.getCreatedTime()))
                .updatedTime(DateTimeUtil.formatDateTimeWithSecond(entity.getUpdatedTime()))
                .build();
    }

    public CarrierResponseTimeEntity mapDTOToEntity(CarrierResponseTimeDTO carrierResponseTimeDTO){
        CarrierResponseTimeEntity carrierResponseTimeEntity = new CarrierResponseTimeEntity();
        carrierResponseTimeEntity.setCarrierId(carrierResponseTimeDTO.getCarrierId());
        carrierResponseTimeEntity.setEquipmentId(carrierResponseTimeDTO.getEquipmentId());
        carrierResponseTimeEntity.setModeId(carrierResponseTimeDTO.getModeId());
        carrierResponseTimeEntity.setServiceLevelId(carrierResponseTimeDTO.getServiceLevelId());
        if (StringUtils.isNumeric(carrierResponseTimeDTO.getResponseTime())) {
            carrierResponseTimeEntity.setResponseTime(Integer.parseInt(carrierResponseTimeDTO.getResponseTime()));
        } else {
            carrierResponseTimeEntity.setResponseTime(9999);
        }
        return carrierResponseTimeEntity;
    }
}
