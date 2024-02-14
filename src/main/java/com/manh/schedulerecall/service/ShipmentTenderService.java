package com.manh.schedulerecall.service;

import com.manh.schedulerecall.entity.CarrierResponseTimeEntity;
import com.manh.schedulerecall.entity.ShipmentTenderEntity;
import com.manh.schedulerecall.enums.PickupStatusEnum;
import com.manh.schedulerecall.repository.CarrierResponseTimeRepository;
import com.manh.schedulerecall.repository.ShipmentTenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ShipmentTenderService {
    @Autowired
    ShipmentTenderRepository shipmentTenderRepository;
    @Autowired
    CarrierResponseTimeRepository carrierResponseTimeRepository;

    public Page<ShipmentTenderEntity> findPendingShipments(int pageNumber, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "ShipmentId");
        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);
        return shipmentTenderRepository.findByPickupStatusAndPickupResponseTimeBefore(PickupStatusEnum.PENDING.getStatus(), Timestamp.valueOf(LocalDateTime.now()), pageable);
    }

    public List<ShipmentTenderEntity> findPendingShipmentsForTrigger() {
        return shipmentTenderRepository.findByPickupStatusAndPickupResponseTimeBefore(PickupStatusEnum.PENDING.getStatus(), Timestamp.valueOf(LocalDateTime.now()));
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public ShipmentTenderEntity saveShipmentDetails(ShipmentTenderEntity shipmentTenderEntity) {
        updateReponseTimeOnShipment(shipmentTenderEntity);
        return shipmentTenderRepository.save(shipmentTenderEntity);
    }

    private void updateReponseTimeOnShipment(ShipmentTenderEntity shipmentTenderEntity) {
        CarrierResponseTimeEntity carrierResponseTimeEntity = carrierResponseTimeRepository.findByCarrierIdAndEquipmentIdAndServiceLevelIdAndModeId(shipmentTenderEntity.getCarrierId(),
                shipmentTenderEntity.getEquipmentId(), shipmentTenderEntity.getServiceLevelId(), shipmentTenderEntity.getModeId());
        if(Objects.isNull(carrierResponseTimeEntity)){
            throw new RuntimeException("Carrier Key does not exist");
        }
        int responseTimeInMins = carrierResponseTimeEntity.getResponseTime();
        long responseTimeinMillis = (long) responseTimeInMins * 60 * 1000;
        shipmentTenderEntity.setPickupResponseTime(new Timestamp(shipmentTenderEntity.getAcceptedTime().getTime() + responseTimeinMillis));
    }

    public ShipmentTenderEntity findByShipmentId(String shipmentId) {
        return shipmentTenderRepository.findByShipmentId(shipmentId);
    }

    public Page<ShipmentTenderEntity> findAll(int pageNum, int size) {
        Sort sort = new Sort(Sort.Direction.ASC, "ShipmentId");
        Pageable pageable = new PageRequest(pageNum, size, sort);
        return shipmentTenderRepository.findAll(pageable);
    }
}
