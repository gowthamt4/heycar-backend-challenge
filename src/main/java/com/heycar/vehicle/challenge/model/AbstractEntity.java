package com.heycar.vehicle.challenge.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
public class AbstractEntity implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 236794961301801635L;

  @Column(name = "create_dts", updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @Basic(fetch = FetchType.LAZY)
  private Date created;
  
  @Column(name = "updt_dts")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModified;
  
  protected AbstractEntity() {
    this.lastModified = new Date();
  }
  
  @PrePersist
  void beforeCreate() {       
      this.setCreated(new Date());
      this.setLastModified(this.getCreated());
  }
  
  @PreUpdate
  void beforeUpdate() {
      this.setLastModified(new Date());
  }
}
