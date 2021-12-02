package com.hexagonal.user.adapter.in.web;

import com.hexagonal.user.application.model.User;
import com.hexagonal.user.application.port.in.RegisterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
class RegisterMvcController {

  private final RegisterUseCase registerUseCase;

  @PostMapping("/mvc/register/")
  ModelAndView register(@ModelAttribute("user") User user){


    registerUseCase.registerUser(new User(user. getName(),user.getEmail()), false);

    ModelAndView modelAndView = new ModelAndView("registration_success.html");
    modelAndView.addObject("username", user.getName());

    return modelAndView;
  }

}
