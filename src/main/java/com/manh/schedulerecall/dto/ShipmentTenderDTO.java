package com.manh.schedulerecall.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Builder(toBuilder = true)
public class ShipmentTenderDTO implements Serializable {
    private String pk;
    private String shipmentId;
    private String serviceLevelId;
    private String modeId;
    private String carrierId;
    private String equipmentId;
    private String acceptedTime;
    private String pickupResponseTime;
    private String createdTime;
    private String updatedTime;
}
