package com.manh.schedulerecall.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "SHIPMENT_TENDER")
public class ShipmentTenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk")
    private int pk;

    @Column(name = "shipment_id")
    private String shipmentId;

    @Column(name = "carrier_id")
    private String carrierId;

    @Column(name = "service_level_id")
    private String serviceLevelId;

    @Column(name = "mode_id")
    private String modeId;

    @Column(name = "equipment_id")
    private String equipmentId;

    @Column(name = "pickup_response_time")
    private Timestamp pickupResponseTime;

    @Column(name = "accepted_time")
    private Timestamp acceptedTime;

    @Column(name = "pickup_status")
    private String pickupStatus;

    @CreationTimestamp
    @Column(name = "created_time")
    private Timestamp createdTime;

    @UpdateTimestamp
    @Column(name = "updated_time")
    private Timestamp updatedTime;
}
