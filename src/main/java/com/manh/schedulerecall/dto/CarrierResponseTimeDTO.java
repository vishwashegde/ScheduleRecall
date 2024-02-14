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
public class CarrierResponseTimeDTO implements Serializable {
    private String pk;
    private String carrierId;
    private String equipmentId;
    private String modeId;
    private String responseTime;
    private String serviceLevelId;
    private String updatedTime;
    private String createdTime;
}
