package com.hedspi.gr.videocall.service;

import com.hedspi.gr.videocall.model.PeerUserInfo;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class ChatRoomMatchingService {
    private static final Queue<String> ID_QUEUE = new LinkedList<>();

    public String findPartner(PeerUserInfo user){
        String partnerId = ID_QUEUE.poll();
        if (partnerId == null){
            ID_QUEUE.add(user.getPeerId());
        } else if (partnerId.equals(user.getPeerId())) {
            return null;
        }
        return partnerId;
    }

    public Boolean rejectCall(PeerUserInfo user){
        return ID_QUEUE.remove(user.getPeerId());
    }
}
