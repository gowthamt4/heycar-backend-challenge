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
  @Column(name = "vehicle_code")
  private String code;
  
  @Column(name = "vehicle_brand")
  private String make;
  
  @Column(name = "vehicle_model")
  private String model;
  
  @Column(name = "vehicle_power_in_ps")
  private Integer kW;
  
  @Column(name = "vehicle_year")
  private String year;
  
  @Column(name = "vehicle_color")
  private String color;
  
  @Column(name = "vehicle_price")
  private Long price;
  
  
}