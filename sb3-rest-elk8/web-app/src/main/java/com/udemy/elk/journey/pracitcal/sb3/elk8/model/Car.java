package com.udemy.elk.journey.pracitcal.sb3.elk8.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Document(indexName = "elk-jrn")
public class Car {
  private String brand, color, type;
}
