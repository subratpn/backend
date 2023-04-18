package com.wellsfargo.backend.dto;

import java.time.Instant;

public class ExceptionRes {

    private String errorMsg;

    private Instant occurredAt;

    public ExceptionRes(String errorMsg) {
        this.errorMsg = errorMsg;
        this.occurredAt = Instant.now();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Instant getOccurredAt() {
        return occurredAt;
    }
}
