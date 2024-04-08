package ashes.notificationservice.service;


import ashes.registercore.core.MessageDTO;

public interface EmailService {
    void sendEmail(MessageDTO dto);
}
