package com.heycar.vehicle.challenge.service;

import com.heycar.vehicle.challenge.dao.VehicleDAO;
import com.heycar.vehicle.challenge.rest.model.Vehicle;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

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
        heyCarVehicleService.createOrUpdateVehicles("1234",  Arrays.asList(constructMockVehicle()));

        Mockito.verify(vehicleDAO, Mockito.times(1))
                .saveAll(Mockito.anyIterable());
    }

    @Test
    public void getVehiclesByMake() {
        VehicleDAO vehicleDAO = Mockito.mock(VehicleDAO.class);
        Mockito.when(vehicleDAO.findAllByMake(Mockito.anyString(), Mockito.any(Pageable.class)))
                .thenReturn(Page.empty());

        ReflectionTestUtils.setField(heyCarVehicleService,"vehicleDAO", vehicleDAO);
        heyCarVehicleService.getVehiclesBySearch("renault", null, null, null);

        Mockito.verify(vehicleDAO, Mockito.times(1))
                .findAllByMake(Mockito.anyString(), Mockito.any());
    }

    @Test
    public void getVehiclesByModel() {
        VehicleDAO vehicleDAO = Mockito.mock(VehicleDAO.class);
        Mockito.when(vehicleDAO.findAllByModel(Mockito.anyString(), Mockito.any(Pageable.class)))
                .thenReturn(Page.empty());

        ReflectionTestUtils.setField(heyCarVehicleService,"vehicleDAO", vehicleDAO);
        heyCarVehicleService.getVehiclesBySearch(null, "megane", null, null);

        Mockito.verify(vehicleDAO, Mockito.times(1))
                .findAllByModel(Mockito.anyString(), Mockito.any());
    }

    @Test
    public void getVehiclesByYear() {
        VehicleDAO vehicleDAO = Mockito.mock(VehicleDAO.class);
        Mockito.when(vehicleDAO.findAllByYear(Mockito.anyString(), Mockito.any(Pageable.class)))
                .thenReturn(Page.empty());

        ReflectionTestUtils.setField(heyCarVehicleService,"vehicleDAO", vehicleDAO);
        heyCarVehicleService.getVehiclesBySearch(null, null, "2014", null);

        Mockito.verify(vehicleDAO, Mockito.times(1))
                .findAllByYear(Mockito.anyString(), Mockito.any());
    }

    @Test
    public void getVehiclesByColor() {
        VehicleDAO vehicleDAO = Mockito.mock(VehicleDAO.class);
        Mockito.when(vehicleDAO.findAllByColor(Mockito.anyString(), Mockito.any(Pageable.class)))
                .thenReturn(Page.empty());

        ReflectionTestUtils.setField(heyCarVehicleService,"vehicleDAO", vehicleDAO);
        heyCarVehicleService.getVehiclesBySearch(null, null, null, "red");

        Mockito.verify(vehicleDAO, Mockito.times(1))
                .findAllByColor(Mockito.anyString(), Mockito.any());
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
}
