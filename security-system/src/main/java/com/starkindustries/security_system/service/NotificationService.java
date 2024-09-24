package com.starkindustries.security_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Envía una notificación a todos los clientes conectados
    public void sendSensorAlert(String message) {
        messagingTemplate.convertAndSend("/topic/alerts", message);
    }
}
