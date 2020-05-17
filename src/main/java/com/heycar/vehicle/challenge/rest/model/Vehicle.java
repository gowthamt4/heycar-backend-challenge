package com.heycar.vehicle.challenge.rest.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 5527791201635852634L;

  private String code;
  
  private String make;
  
  private String model;
  
  @JsonProperty(value = "kW")
  private String kW;
  
  private String year;
  
  private String color;
  
  private String price;

}
