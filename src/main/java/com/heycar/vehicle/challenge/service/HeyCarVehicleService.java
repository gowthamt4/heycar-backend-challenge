package com.heycar.vehicle.challenge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.heycar.vehicle.challenge.dao.VehicleDAO;
import com.heycar.vehicle.challenge.rest.model.Vehicle;

@Service
public class HeyCarVehicleService {

  @Autowired
  private VehicleDAO vehicleDAO;
  
  
  public void createOrUpdateVehicles(String dealerId, List<Vehicle> vehicles) {
    vehicleDAO.saveAll(vehicles.stream().map(v -> {
      com.heycar.vehicle.challenge.model.Vehicle vehicle = new com.heycar.vehicle.challenge.model.Vehicle();
      vehicle.setDealerId(dealerId);
      vehicle.setCode(v.getCode());
      vehicle.setColor(v.getColor());
      vehicle.setKW(v.getKW());
      vehicle.setMake(v.getMake());
      vehicle.setModel(v.getModel());
      vehicle.setPrice(v.getPrice());
      vehicle.setYear(v.getYear());
      return vehicle;
    }).collect(Collectors.toList()));
  }
   

  public List<Vehicle> getVehiclesBySearch(String make, String model, String year, String color) {
    Pageable pageable = Pageable.unpaged();
    if(make != null && model == null && year == null && color == null) {
      return vehicleDAO.findAllByMake(make, pageable).getContent().stream().map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if(make == null && model != null && year == null && color == null) {
      return vehicleDAO.findAllByModel(model, pageable).getContent().stream().map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if(make == null && model == null && year != null && color == null) {
      return vehicleDAO.findAllByYear(year, pageable).getContent().stream().map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if(make == null && model == null && year == null && color != null) {
      return vehicleDAO.findAllByColor(color, pageable).getContent().stream().map(this::mapToVehicleObject).collect(Collectors.toList());
    } else {
      return vehicleDAO.findAll().stream().map(this::mapToVehicleObject).collect(Collectors.toList());
    }
  }
  
  private Vehicle mapToVehicleObject(final com.heycar.vehicle.challenge.model.Vehicle vehicle) {
    Vehicle restModel = new Vehicle();
    restModel.setCode(vehicle.getCode());
    restModel.setColor(vehicle.getColor());
    restModel.setKW(vehicle.getKW());
    restModel.setMake(vehicle.getMake());
    restModel.setModel(vehicle.getModel());

    return restModel;
  }

}
