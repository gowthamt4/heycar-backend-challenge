package com.heycar.vehicle.challenge.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.heycar.vehicle.challenge.exception.HeyCarResponseEntity;
import com.heycar.vehicle.challenge.rest.model.Vehicle;
import com.heycar.vehicle.challenge.service.HeyCarVehicleService;

@RestController
@RequestMapping(path = "/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HeyCarVehicleController {

  private final static Logger logger = LoggerFactory.getLogger(HeyCarVehicleController.class);

  @Autowired
  private HeyCarVehicleService heyCarVehilceService;

  @PostMapping("vehicle_listings/upload_csv/{dealer_id}")
  public HeyCarResponseEntity uploadVehicles(@PathVariable("dealer_id") String dealerId,
      @RequestParam("file") MultipartFile file) {
    List<String> errors = new ArrayList<String>();
    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
      
      Consumer<String> addError = (String s) -> errors.add(s);
      List<Vehicle> vehicles = bufferedReader.lines().skip(1).map(line -> mapToVehicle(line, addError))
          .filter(Objects::nonNull).collect(Collectors.toList());
      heyCarVehilceService.createOrUpdateVehicles(dealerId, vehicles);
     if(errors.isEmpty()) {
       return new HeyCarResponseEntity("Uploaded Successfully", HttpStatus.CREATED, errors);
     } else {
       return new HeyCarResponseEntity("Partially Uploaded with some failures. Please check the skipped records", HttpStatus.CREATED, errors);
     }
    } catch (IOException e) {
      logger.error("Not able to read the file {}", e.getMessage());
      return new HeyCarResponseEntity("Not able to parse the file", HttpStatus.BAD_REQUEST, errors);
    }
  }


  @PostMapping(path = "vehicle_listings/upload/{dealer_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(code = HttpStatus.CREATED)
  public void uploadVehicles(@PathVariable(name = "dealer_id") String dealerId,
      @Valid @RequestBody List<Vehicle> vehicles) {
    heyCarVehilceService.createOrUpdateVehicles(dealerId, vehicles);
  }

  @GetMapping("vehicles/search")
  public List<Vehicle> search(@RequestParam(required = false) String make,
      @RequestParam(required = false) String model, @RequestParam(required = false) String year,
      @RequestParam(required = false) String color) {

    return heyCarVehilceService.getVehiclesBySearch(make, model, year, color);
  }

  private Vehicle mapToVehicle(String line , Consumer<String> addError) {
    String[] vehicleData = line.split(",");
    if (vehicleData.length < 6) {
      addError.accept(line);
      logger.error("Not a valid record or Minimum number of fields are missing in line {}",  line);
      return null;
    }
    String[] makeModelData = vehicleData[1].split("/");
    Vehicle vehicle = new Vehicle();
    vehicle.setCode(vehicleData[0]);
    vehicle.setMake(makeModelData[0]);
    vehicle.setModel(makeModelData[1]);
    vehicle.setKW(Integer.valueOf(vehicleData[2]));
    vehicle.setYear(vehicleData[3]);
    vehicle.setColor(vehicleData[4]);
    vehicle.setPrice(Long.parseLong(vehicleData[5]));
    return vehicle;
  }
}
