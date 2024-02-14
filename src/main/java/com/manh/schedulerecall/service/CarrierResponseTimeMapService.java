package com.manh.schedulerecall.service;

import com.manh.schedulerecall.dto.CarrierResponseTimeDTO;
import com.manh.schedulerecall.entity.CarrierResponseTimeEntity;
import com.manh.schedulerecall.mapper.CarrierResponseEntityDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarrierResponseTimeMapService {

    @Autowired
    CarrierResponseTimeService carrierResponseTimeService;
    @Autowired
    CarrierResponseEntityDTOMapper carrierResponseEntityDTOMapper;

    public Page<CarrierResponseTimeDTO> findAll(int pageNumber, int pageSize) {
        Page<CarrierResponseTimeEntity> carrierResponseTimeEntities = carrierResponseTimeService.findAll(pageNumber, pageSize);
        return carrierResponseTimeEntities.map(entity -> carrierResponseEntityDTOMapper.mapEntityToDTO(entity));
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public CarrierResponseTimeDTO save(CarrierResponseTimeDTO carrierResponseTimeDTO) {
        CarrierResponseTimeEntity carrierResponseTimeEntityToSave = carrierResponseEntityDTOMapper.mapDTOToEntity(carrierResponseTimeDTO);
        CarrierResponseTimeEntity savedCarrierResponseTime = carrierResponseTimeService.save(carrierResponseTimeEntityToSave);
        if(savedCarrierResponseTime==null){
            return CarrierResponseTimeDTO.builder().build();
        }
        else{
            return carrierResponseEntityDTOMapper.mapEntityToDTO(savedCarrierResponseTime);
        }
    }
}
