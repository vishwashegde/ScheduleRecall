package com.manh.schedulerecall.scheduler;

import com.manh.schedulerecall.entity.ShipmentTenderEntity;
import com.manh.schedulerecall.service.ShipmentTenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Component
public class ShipmentTenderRecallScheduler {
    @Autowired
    ShipmentTenderService shipmentTenderService;
    @Scheduled(cron = "0 * * * * *") // Runs every minute
    public void runTask() {
        System.out.println("Task executed at: " + new Date());
        // write a query similar to OM_SCHED_TRIGGER
        List<ShipmentTenderEntity> pendingShipments =  shipmentTenderService.findPendingShipmentsForTrigger();
        if(!CollectionUtils.isEmpty(pendingShipments)){
            pendingShipments.forEach(pendingShipment -> System.out.println("Shipment hasn't been picked up, will be recalled " + pendingShipment.getShipmentId()));
        }
    }
}
