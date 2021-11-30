package com.hexagonal.user.application.port.out;

public interface SendMailPort {

  void sendMail(String subject, String text);

}
