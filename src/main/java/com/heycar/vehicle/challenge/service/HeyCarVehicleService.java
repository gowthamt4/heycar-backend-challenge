package com.heycar.vehicle.challenge.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.heycar.vehicle.challenge.dao.VehicleDAO;
import com.heycar.vehicle.challenge.rest.model.Vehicle;

@Service
@Transactional
public class HeyCarVehicleService {

  @Autowired
  private VehicleDAO vehicleDAO;


  public void createOrUpdateVehicles(String dealerId, List<Vehicle> vehicles) {
    vehicleDAO.saveAllVehicles(vehicles.stream().map(v -> {
      com.heycar.vehicle.challenge.model.Vehicle vehicle =
          new com.heycar.vehicle.challenge.model.Vehicle();
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
    if (make != null && model == null && year == null && color == null) {
      return vehicleDAO.findAllByMake(make).stream().map(this::mapToVehicleObject)
          .collect(Collectors.toList());
    } else if (make == null && model != null && year == null && color == null) {
      return vehicleDAO.findAllByModel(model).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make == null && model == null && year != null && color == null) {
      return vehicleDAO.findAllByYear(year).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make == null && model == null && year == null && color != null) {
      return vehicleDAO.findAllByColor(color).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make != null && model != null && year == null && color == null) {
      return vehicleDAO.findAllByMakeModel(make, model).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make == null && model != null && year != null && color == null) {
      return vehicleDAO.findAllByModelYear(model, year).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make == null && model == null && year != null && color != null) {
      return vehicleDAO.findAllByYearColor(year, color).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make != null && model == null && year == null && color != null) {
      return vehicleDAO.findAllByMakeColor(make, color).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make == null && model != null && year == null && color != null) {
      return vehicleDAO.findAllByModelColor(model, color).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make != null && model == null && year != null && color == null) {
      return vehicleDAO.findAllByMakeYear(make, year).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make != null && model != null && year != null && color == null) {
      return vehicleDAO.findAllByMakeModelYear(make, model, year).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make != null && model != null && year == null && color != null) {
      return vehicleDAO.findAllByMakeModelColor(make, model, color).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make != null && model == null && year != null && color != null) {
      return vehicleDAO.findAllByMakeYearColor(make, year, color).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make == null && model != null && year != null && color != null) {
      return vehicleDAO.findAllByModelYearColor(model, year, color).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else if (make != null && model != null && year != null && color != null) {
      return vehicleDAO.findAllByMakeModelYearColor(make, model, year, color).stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    } else {
      return vehicleDAO.findAll().stream()
          .map(this::mapToVehicleObject).collect(Collectors.toList());
    }
  }

  private Vehicle mapToVehicleObject(final com.heycar.vehicle.challenge.model.Vehicle vehicle) {
    Vehicle restModel = new Vehicle();
    restModel.setCode(vehicle.getCode());
    restModel.setColor(vehicle.getColor());
    restModel.setKW(vehicle.getKW());
    restModel.setMake(vehicle.getMake());
    restModel.setModel(vehicle.getModel());
    restModel.setPrice(vehicle.getPrice());
    restModel.setYear(vehicle.getYear());
    return restModel;
  }

}
