package com.udemy.elk.journey.pracitcal.sb3.elk8.service;

import com.udemy.elk.journey.pracitcal.sb3.elk8.model.Car;
import org.apache.camel.Handler;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CarRandomizeService {

  private static final List<String> BRANDS = List.of("Toyota", "Honda", "Subaru");
  private static final List<String> COLORS = List.of("Gray", "White", "Black");

  private static final List<String> TYPES = List.of("Sedan", "Suv", "MPV");


  @Handler
  Car randomizeCars() {
    var brand = BRANDS.get(ThreadLocalRandom.current().nextInt(BRANDS.size()));
    var color = COLORS.get(ThreadLocalRandom.current().nextInt(BRANDS.size()));
    var type = TYPES.get(ThreadLocalRandom.current().nextInt(BRANDS.size()));
    //
    return new Car(brand, color, type);

  }
}
