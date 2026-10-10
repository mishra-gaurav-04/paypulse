package com.micronids.paypulse.shared.enums;

public enum PaymentEvent {
    AUTHORIZE_ATTEMPT,
    AUTHORIZE_FAILED,
    AUTHORIZE_SUCCESS,
    CAPTURE_REQUEST,
    CAPTURE_FAILED,
    CAPTURE_SUCCESS,
    REFUND_INIT,
    REFUND_COMPLETE,
    SETTLE,
    CANCEL,
    CAPTURE_TIMEOUT
}
