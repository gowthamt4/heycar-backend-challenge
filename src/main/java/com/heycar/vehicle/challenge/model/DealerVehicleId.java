package com.heycar.vehicle.challenge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DealerVehicleId implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = -2137186113308712140L;

  @NotNull
  @Column(name = "dealer_id")
  private String dealerId;
  
  @NotNull
  @Column(name = "code")
  private String code;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((code == null) ? 0 : code.hashCode());
    result = prime * result + ((dealerId == null) ? 0 : dealerId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    DealerVehicleId other = (DealerVehicleId) obj;
    if (code == null) {
      if (other.code != null) return false;
    } else if (!code.equals(other.code)) return false;
    if (dealerId == null) {
      if (other.dealerId != null) return false;
    } else if (!dealerId.equals(other.dealerId)) return false;
    return true;
  }

  
  
}
