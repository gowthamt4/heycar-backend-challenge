package com.heycar.vehicle.challenge.exception;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HeyCarResponseEntity implements Serializable{
  
  private String message;
  private HttpStatus code;
  private List<String> skippedRecords;
}
