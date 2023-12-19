package com.udemy.elk.journey.pracitcal.sb3.elk8.api;

import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CarController extends RouteBuilder {
  @Override
  public void configure() {

    final int portNum = 12666;

    restConfiguration().component("netty-http")
            .host("0.0.0.0")
            .port(portNum)
            .contextPath("/api")
            .bindingMode(RestBindingMode.auto);
    //
    /*
      /api/welcome
      /api/time
      /api/car/v1/random
      /api/car/v1/echo (POST)

      /api/car/v1/cars/{brand}/{color}
      /api/car/v1/cars?brand=xxx&color=yyy
      /api/car/v1/cars/{id}
      /api/car/v1/cars (POST)

    */
    rest("/car/v1/random")
            .get()
              .to("direct:greeting");


  }
}
