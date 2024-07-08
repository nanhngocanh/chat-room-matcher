package com.hedspi.gr.videocall.model;

import jakarta.validation.constraints.NotNull;

public class PeerUserInfo {
    @NotNull(message = "The peerId is required.")
    private String peerId;

    public PeerUserInfo(String peerId) {
        this.peerId = peerId;
    }
    public PeerUserInfo(){}

    public String getPeerId() {
        return peerId;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }
}
