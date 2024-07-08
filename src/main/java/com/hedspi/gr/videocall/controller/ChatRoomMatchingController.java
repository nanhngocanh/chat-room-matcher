package com.hedspi.gr.videocall.controller;

import com.hedspi.gr.videocall.PartnerResponse;
import com.hedspi.gr.videocall.enums.Status;
import com.hedspi.gr.videocall.model.PeerUserInfo;
import com.hedspi.gr.videocall.service.ChatRoomMatchingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/call")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class ChatRoomMatchingController {

    private final ChatRoomMatchingService userService;

    @PostMapping("/findPartner")
    public ResponseEntity<PartnerResponse> callSomeone(@RequestBody @Valid PeerUserInfo user) {
        String partnerId = userService.findPartner(user);
        if (partnerId == null){
            return ResponseEntity.ok(new PartnerResponse(Status.WAITING));
        }
        return ResponseEntity.ok(new PartnerResponse(partnerId,Status.READY));
    }

    @PostMapping("/rejectCall")
    public ResponseEntity<PartnerResponse> rejectCall(@RequestBody @Valid PeerUserInfo user) {
        boolean rejected = userService.rejectCall(user);
        if (!rejected) {
            return ResponseEntity.badRequest().body(new PartnerResponse(user.getPeerId(),Status.NOT_IN_QUEUE));
        }
        return ResponseEntity.ok(new PartnerResponse(user.getPeerId(),Status.REJECTED));

    }
}
