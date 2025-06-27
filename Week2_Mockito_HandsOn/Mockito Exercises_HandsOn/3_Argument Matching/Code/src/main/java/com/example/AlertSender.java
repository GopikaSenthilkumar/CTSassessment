package com.example;
public class AlertSender {
	    private final NotificationService notificationService;
	    public AlertSender(NotificationService notificationService) {
	        this.notificationService = notificationService;
	    }
	    public void alertAdmin() {
	        notificationService.send("agopikasenthilkumar@gmail.com", "Server is down!");
	    }
}
