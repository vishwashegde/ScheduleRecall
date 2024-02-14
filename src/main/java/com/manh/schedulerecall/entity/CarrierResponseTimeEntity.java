package com.manh.schedulerecall.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "CARRIER_RESPONSE_TIME", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CARRIER_ID", "MODE_ID", "SERVICE_LEVEL_ID", "EQUIPMENT_ID"})
})
public class CarrierResponseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk")
    private int pk;

    @Column(name = "carrier_id")
    private String carrierId;

    @Column(name = "service_level_id")
    private String serviceLevelId;

    @Column(name = "mode_id")
    private String modeId;

    @Column(name = "equipment_id")
    private String equipmentId;

    @Column(name = "response_time")
    private Integer responseTime;

    @CreationTimestamp
    @Column(name = "created_time")
    private Timestamp createdTime;

    @UpdateTimestamp
    @Column(name = "updated_time")
    private Timestamp updatedTime;
}
