package com.heycar.vehicle.challenge.service;

import com.heycar.vehicle.challenge.dao.VehicleDAO;
import com.heycar.vehicle.challenge.model.Vehicle;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class HeyCarVehicleServiceTest {

    @InjectMocks
    HeyCarVehicleService heyCarVehicleService;

    @BeforeTest
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createOrUpdateVehicles() {
        VehicleDAO vehicleDAO = Mockito.mock(VehicleDAO.class);
        ReflectionTestUtils.setField(heyCarVehicleService, "vehicleDAO", vehicleDAO);
        heyCarVehicleService.createOrUpdateVehicles("1234",  Arrays.asList(constructRestMockVehicle()));

        Mockito.verify(vehicleDAO, Mockito.times(1))
                .saveAllVehicles((List<Vehicle>) Mockito.anyIterableOf(Vehicle.class));
    }

    @Test
    public void getVehiclesByMake() {
        VehicleDAO vehicleDAO = Mockito.mock(VehicleDAO.class);
        Mockito.when(vehicleDAO.findAllByMake(Mockito.anyString()))
                .thenReturn(Arrays.asList(constructMockVehicle()));

        ReflectionTestUtils.setField(heyCarVehicleService,"vehicleDAO", vehicleDAO);
        heyCarVehicleService.getVehiclesBySearch("renault", null, null, null);

        Mockito.verify(vehicleDAO, Mockito.times(1))
                .findAllByMake(Mockito.anyString());
    }

    @Test
    public void getVehiclesByModel() {
        VehicleDAO vehicleDAO = Mockito.mock(VehicleDAO.class);
        Mockito.when(vehicleDAO.findAllByModel(Mockito.anyString()))
        .thenReturn(Arrays.asList(constructMockVehicle()));

        ReflectionTestUtils.setField(heyCarVehicleService,"vehicleDAO", vehicleDAO);
        heyCarVehicleService.getVehiclesBySearch(null, "megane", null, null);

        Mockito.verify(vehicleDAO, Mockito.times(1))
                .findAllByModel(Mockito.anyString());
    }

    @Test
    public void getVehiclesByYear() {
        VehicleDAO vehicleDAO = Mockito.mock(VehicleDAO.class);
        Mockito.when(vehicleDAO.findAllByYear(Mockito.anyString()))
        .thenReturn(Arrays.asList(constructMockVehicle()));

        ReflectionTestUtils.setField(heyCarVehicleService,"vehicleDAO", vehicleDAO);
        heyCarVehicleService.getVehiclesBySearch(null, null, "2014", null);

        Mockito.verify(vehicleDAO, Mockito.times(1))
                .findAllByYear(Mockito.anyString());
    }

    @Test
    public void getVehiclesByColor() {
        VehicleDAO vehicleDAO = Mockito.mock(VehicleDAO.class);
        Mockito.when(vehicleDAO.findAllByColor(Mockito.anyString()))
        .thenReturn(Arrays.asList(constructMockVehicle()));

        ReflectionTestUtils.setField(heyCarVehicleService,"vehicleDAO", vehicleDAO);
        heyCarVehicleService.getVehiclesBySearch(null, null, null, "red");

        Mockito.verify(vehicleDAO, Mockito.times(1))
                .findAllByColor(Mockito.anyString());
    }

    @Test
    public void getAll() {
        VehicleDAO vehicleDAO = Mockito.mock(VehicleDAO.class);
        ReflectionTestUtils.setField(heyCarVehicleService,"vehicleDAO", vehicleDAO);
        heyCarVehicleService.getVehiclesBySearch(null, null, null, null);

        Mockito.verify(vehicleDAO, Mockito.times(1))
                .findAll();
    }

    private Vehicle constructMockVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setCode("a");
        vehicle.setMake("renault");
        vehicle.setModel("megane");
        vehicle.setKW(132);
        vehicle.setYear("2014");
        vehicle.setColor("red");
        vehicle.setPrice(Long.parseLong("13990"));
        return vehicle;
    }
    
    private com.heycar.vehicle.challenge.rest.model.Vehicle constructRestMockVehicle() {
      com.heycar.vehicle.challenge.rest.model.Vehicle vehicle = new com.heycar.vehicle.challenge.rest.model.Vehicle();
      vehicle.setCode("a");
      vehicle.setMake("renault");
      vehicle.setModel("megane");
      vehicle.setKW(132);
      vehicle.setYear("2014");
      vehicle.setColor("red");
      vehicle.setPrice(Long.parseLong("13990"));
      return vehicle;
  }
}
