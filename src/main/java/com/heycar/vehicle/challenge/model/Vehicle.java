package com.heycar.vehicle.challenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@IdClass(DealerVehicleId.class)
public class Vehicle extends AbstractEntity {

  /**
   * 
   */
  private static final long serialVersionUID = -4490883628044203499L;
  
  @Id
  @Column(name = "dealer_id")
  private String dealerId;
  
  @Id
  private String code;
  
  private String make;
  
  private String model;
  
  private Integer kW;
  
  private String year;
  
  private String color;
  
  private Long price;
  
  
}