package com.hexagonal.user.adapter.in.web.mvc;

import com.hexagonal.user.adapter.in.web.rest.UserResource;
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
  ModelAndView register(@ModelAttribute("user") UserResource userResource){


    registerUseCase.registerUser(new RegisterUseCase.RegisterCommand(userResource. getName(),userResource.getEmail(), false));

    ModelAndView modelAndView = new ModelAndView("registration_success.html");
    modelAndView.addObject("username", userResource.getName());

    return modelAndView;
  }

}
