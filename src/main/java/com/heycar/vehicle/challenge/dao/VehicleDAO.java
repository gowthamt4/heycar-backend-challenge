package com.heycar.vehicle.challenge.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.heycar.vehicle.challenge.QueryConstants;
import com.heycar.vehicle.challenge.model.Vehicle;


@Repository
@SuppressWarnings("unchecked")
public class VehicleDAO  {
  
  @PersistenceContext
  private EntityManager entityManager;

  public VehicleDAO(final EntityManager entityManager) {
      this.entityManager = entityManager;
  }
  
  public List<Vehicle> findAllByMake(final String make) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_MAKE);
    query.setParameter("make", make);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByModel(final String model) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_MODEL);
    query.setParameter("model", model);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByYear(final String year) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_YEAR);
    query.setParameter("year", year);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByColor(final String color) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_COLOR);
    query.setParameter("color", color);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByMakeModel(final String make, final String model) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_MAKE_MODEL);
    query.setParameter("make", make);
    query.setParameter("model", model);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByModelYear(final String model, final String year) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_MODEL_YEAR);
    query.setParameter("model", model);
    query.setParameter("year", year);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByMakeYear(final String make, final String year) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_MAKE_YEAR);
    query.setParameter("make", make);
    query.setParameter("year", year);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByMakeColor(final String make, final String color) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_MAKE_COLOR);
    query.setParameter("make", make);
    query.setParameter("color", color);
    return (List<Vehicle>) query.getResultList();
  }
  
  public void saveAllVehicles(final List<Vehicle> vehicles) {
    vehicles.forEach(vehicle ->{entityManager.persist(vehicle);});
  }

  public List<Vehicle> findAllByYearColor(String year, String color) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_YEAR_COLOR);
    query.setParameter("color", color);
    query.setParameter("year", year);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByModelColor(String model, String color) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_MODEL_COLOR);
    query.setParameter("model", model);
    query.setParameter("color", color);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByMakeModelYear(String make, String model, String year) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_MAKE_MODEL_YEAR);
    query.setParameter("make", make);
    query.setParameter("model", model);
    query.setParameter("year", year);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByMakeModelColor(String make, String model, String color) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_MAKE_MODEL_COLOR);
    query.setParameter("make", make);
    query.setParameter("model", model);
    query.setParameter("color", color);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByMakeYearColor(String make, String year, String color) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_MAKE_YEAR_COLOR);
    query.setParameter("make", make);
    query.setParameter("year", year);
    query.setParameter("color", color);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByModelYearColor(String model, String year, String color) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_MODEL_YEAR_COLOR);
    query.setParameter("model", model);
    query.setParameter("year", year);
    query.setParameter("color", color);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAllByMakeModelYearColor(String make, String model, String year, String color) {
    final Query query = entityManager.createQuery(QueryConstants.GET_VEHICLES_BY_MAKE_MODEL_YEAR_COLOR);
    query.setParameter("model", model);
    query.setParameter("make", make);
    query.setParameter("year", year);
    query.setParameter("color", color);
    return (List<Vehicle>) query.getResultList();
  }
  
  public List<Vehicle> findAll() {
    final Query query = entityManager.createQuery(QueryConstants.GET_ALL_VEHICLES);
    return (List<Vehicle>) query.getResultList();
  }
}
