package com.resolve.geofenceService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.resolve.geofenceService.ApplicationConstantTest;
import com.resolve.geofenceService.entity.GeoFenceEntity;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GeoFenceControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    GeoFenceController geoFenceController;

    @Test
    public void createGoFence() throws  Exception{

        GeoFenceEntity geoFenceTest = new GeoFenceEntity();
        geoFenceTest.setLatitude(89.90);
        geoFenceTest.setLongitude(878.9);
        geoFenceTest.setRadius(79.99);

        mockMvc.perform(MockMvcRequestBuilders
                .post(ApplicationConstantTest.CONTROLLER_BASE_URL + "/createGeo")
                .content(asJsonString(geoFenceTest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    @Test
    void getGeofence() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(ApplicationConstantTest.CONTROLLER_BASE_URL + "/getGeos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateGoFence() throws  Exception{

        GeoFenceEntity geoFenceTest = new GeoFenceEntity();
        geoFenceTest.setId(2L);
        geoFenceTest.setLatitude(89.90);
        geoFenceTest.setLongitude(878.9);
        geoFenceTest.setRadius(79.99);

        mockMvc.perform(MockMvcRequestBuilders
                        .put(ApplicationConstantTest.CONTROLLER_BASE_URL + "/updateGeo")
                        .content(asJsonString(geoFenceTest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    @Test
    public void deleteGoFence() throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders
                        .delete(ApplicationConstantTest.CONTROLLER_BASE_URL +"/deleteGeo/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());

    }

    public static String asJsonString(final  Object obj){
        try{
            return  new ObjectMapper().writeValueAsString(obj);
        }catch (Exception ex){
            throw  new RuntimeException(ex);
        }
    }
}
