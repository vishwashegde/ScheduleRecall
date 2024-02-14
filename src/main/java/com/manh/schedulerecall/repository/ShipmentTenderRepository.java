package com.manh.schedulerecall.repository;

import com.manh.schedulerecall.entity.ShipmentTenderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface ShipmentTenderRepository extends JpaRepository<ShipmentTenderEntity, Integer> {
    Page<ShipmentTenderEntity> findByPickupStatusAndPickupResponseTimeBefore(String pickupStatus, Timestamp currentTime, Pageable pageable);
    List<ShipmentTenderEntity> findByPickupStatusAndPickupResponseTimeBefore(String pickupStatus, Timestamp currentTime);
    ShipmentTenderEntity findByShipmentId(String shipmentId);
}
