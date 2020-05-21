package com.heycar.vehicle.challenge.controller;

import com.heycar.vehicle.challenge.exception.HeyCarResponseEntity;
import com.heycar.vehicle.challenge.rest.model.Vehicle;
import com.heycar.vehicle.challenge.service.HeyCarVehicleService;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ResourceUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class HeyCarVehicleControllerTest {
    private static final String CSV_MOCK_DATA_PATH = "classpath:uploadCsvTestData.csv";
    private static final String CSV_MOCK_DATA_WITH_BAD_RECORDS_PATH = "classpath:uploadCsvTestDataPartial.csv";

    @InjectMocks
    HeyCarVehicleController heyCarVehicleController;

    @BeforeTest
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUploadCsvSuccess() throws IOException {
        HeyCarVehicleService heyCarVehicleService = Mockito.mock(HeyCarVehicleService.class);
        ReflectionTestUtils.setField(heyCarVehicleController,"heyCarVehilceService", heyCarVehicleService);

        MockMultipartFile mockMultipartFile = new MockMultipartFile("uploadCsvTestData.csv",
                new FileInputStream(ResourceUtils.getFile(CSV_MOCK_DATA_PATH)));

        HeyCarResponseEntity responseEntity = heyCarVehicleController.uploadVehicles("1234", mockMultipartFile);
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals(responseEntity.getCode(), HttpStatus.CREATED);
        Assert.assertEquals(responseEntity.getMessage(), "Uploaded Successfully");
        Assert.assertTrue(responseEntity.getSkippedRecords().isEmpty());

        Mockito.verify(heyCarVehicleService, Mockito.times(1))
                .createOrUpdateVehicles(Mockito.anyString(), Mockito.anyList());
    }

    @Test
    public void testUploadCsvPartialSuccess() throws IOException {
        HeyCarVehicleService heyCarVehicleService = Mockito.mock(HeyCarVehicleService.class);
        ReflectionTestUtils.setField(heyCarVehicleController,"heyCarVehilceService", heyCarVehicleService);

        MockMultipartFile mockMultipartFile = new MockMultipartFile("uploadCsvTestDataPartial.csv",
                new FileInputStream(ResourceUtils.getFile(CSV_MOCK_DATA_WITH_BAD_RECORDS_PATH)));

        HeyCarResponseEntity responseEntity = heyCarVehicleController.uploadVehicles("1234", mockMultipartFile);
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals(responseEntity.getCode(), HttpStatus.CREATED);
        Assert.assertEquals(responseEntity.getMessage(), "Partially Uploaded with some failures. Please check the skipped records");
        Assert.assertFalse(responseEntity.getSkippedRecords().isEmpty());
        Assert.assertEquals(responseEntity.getSkippedRecords().size(), 1);

        Mockito.verify(heyCarVehicleService, Mockito.times(1))
                .createOrUpdateVehicles(Mockito.anyString(), Mockito.anyList());
    }

    @Test
    public void testUploadCsvUnableToReadFile() throws IOException {
        HeyCarVehicleService heyCarVehicleService = Mockito.mock(HeyCarVehicleService.class);
        ReflectionTestUtils.setField(heyCarVehicleController,"heyCarVehilceService", heyCarVehicleService);

        MockMultipartFile mockMultipartFile = Mockito.mock(MockMultipartFile.class);
        Mockito.when(mockMultipartFile.getInputStream()).thenThrow(IOException.class);

        HeyCarResponseEntity responseEntity = heyCarVehicleController.uploadVehicles("1234", mockMultipartFile);
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals(responseEntity.getCode(), HttpStatus.BAD_REQUEST);

        Mockito.verify(heyCarVehicleService, Mockito.never())
                .createOrUpdateVehicles(Mockito.anyString(), Mockito.anyList());
    }

    @Test
    public void testUploadJson() {
        HeyCarVehicleService heyCarVehicleService = Mockito.mock(HeyCarVehicleService.class);
        ReflectionTestUtils.setField(heyCarVehicleController,"heyCarVehilceService", heyCarVehicleService);

        heyCarVehicleController.uploadVehicles("1234", Arrays.asList(constructMockVehicle()));
        Mockito.verify(heyCarVehicleService, Mockito.times(1))
                .createOrUpdateVehicles(Mockito.anyString(), Mockito.anyList());
    }

    @Test
    public void testSearch() {
        HeyCarVehicleService heyCarVehicleService = Mockito.mock(HeyCarVehicleService.class);
        ReflectionTestUtils.setField(heyCarVehicleController,"heyCarVehilceService", heyCarVehicleService);

        heyCarVehicleController.search("renault", null, null, null);
        Mockito.verify(heyCarVehicleService, Mockito.times(1))
                .getVehiclesBySearch(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
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
