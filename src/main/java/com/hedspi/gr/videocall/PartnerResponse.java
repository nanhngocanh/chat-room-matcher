package com.hedspi.gr.videocall;

import com.hedspi.gr.videocall.enums.Status;

public class PartnerResponse {
    private String peerId;
    private Status status;

    public PartnerResponse(String peerId, Status status) {
        this.peerId = peerId;
        this.status = status;
    }

    public PartnerResponse(Status status) {
        this.status = status;
    }

    public PartnerResponse() {
    }

    public String getPeerId() {
        return peerId;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
