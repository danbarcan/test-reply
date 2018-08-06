package dan.springboot.controller;

import dan.springboot.model.Car;
import dan.springboot.service.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CarController.class, secure = false)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Service service;

    static Car mockCar;

    static {
        mockCar = new Car();
        mockCar.setId(1);
        mockCar.setCurrentLocation(1d);
        mockCar.setEngine("diesel");
        mockCar.setInfotainmentSystem("bose");
        mockCar.setModel("320d");
    }

    @Test
    public void retrieveCars() throws Exception {

        Mockito.when(service.retrieveAllCars()).thenReturn(Arrays.asList(new Car[]{mockCar}));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/cars").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "[{\"id\":1,\"model\":\"320d\",\"engine\":\"diesel\",\"infotainmentSystem\":\"bose\",\"interiorDesign\":null,\"currentLocation\":1.0}]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void retrieveCar() throws Exception {

        Mockito.when(service.retrieveCar(Mockito.anyInt())).thenReturn(mockCar);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/cars/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"id\":1,\"model\":\"320d\",\"engine\":\"diesel\",\"infotainmentSystem\":\"bose\",\"interiorDesign\":null,\"currentLocation\":1.0}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }
}
