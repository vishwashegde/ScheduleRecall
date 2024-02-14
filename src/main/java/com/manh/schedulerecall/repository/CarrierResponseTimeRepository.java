package com.manh.schedulerecall.repository;

import com.manh.schedulerecall.entity.CarrierResponseTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrierResponseTimeRepository extends JpaRepository<CarrierResponseTimeEntity, Integer> {
    CarrierResponseTimeEntity findByCarrierIdAndEquipmentIdAndServiceLevelIdAndModeId(String carrierId, String equipmentId, String serviceLevelId, String modeId);
}


