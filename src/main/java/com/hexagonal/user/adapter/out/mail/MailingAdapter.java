package com.hexagonal.user.adapter.out.mail;

import com.hexagonal.user.application.port.out.SendMailPort;
import org.springframework.stereotype.Component;

@Component
public class MailingAdapter implements SendMailPort {

  @Override
  public void sendMail(String subject, String text) {
      // sending a mail...
  }

}
