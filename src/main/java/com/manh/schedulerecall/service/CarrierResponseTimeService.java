package com.manh.schedulerecall.service;

import com.manh.schedulerecall.entity.CarrierResponseTimeEntity;
import com.manh.schedulerecall.repository.CarrierResponseTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarrierResponseTimeService {
    @Autowired
    CarrierResponseTimeRepository carrierResponseTimeRepository;

    public Page<CarrierResponseTimeEntity> findAll(int pageNumber, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "CarrierId");
        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);
        return carrierResponseTimeRepository.findAll(pageable);
    }

    public Page<CarrierResponseTimeEntity> findByCarrierKey(String pageNumber, int pageSize) {
        //Pageable pageable = new PageRequest(pageNumber, pageSize);
        //return carrierResponseTimeRepository.findAll(pageable);
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public CarrierResponseTimeEntity save(CarrierResponseTimeEntity carrierResponseTimeEntity) {
        return carrierResponseTimeRepository.save(carrierResponseTimeEntity);
    }
}
