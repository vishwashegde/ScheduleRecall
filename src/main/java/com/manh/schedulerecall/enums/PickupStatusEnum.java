package com.manh.schedulerecall.enums;

import lombok.Getter;

@Getter
public enum PickupStatusEnum {
    PENDING("PENDING"), DISPATCHED("DISPATCHED");
    private final String status;

    PickupStatusEnum(String status) {
        this.status = status;
    }

}
