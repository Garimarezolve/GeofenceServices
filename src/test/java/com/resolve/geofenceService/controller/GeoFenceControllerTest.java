package com.resolve.geofenceService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.resolve.geofenceService.entity.GeoFenceEntity;
import org.junit.jupiter.api.Test;
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
    @Test
    public void createGoFence() throws  Exception{

        GeoFenceEntity geoFenceTest = new GeoFenceEntity();
        geoFenceTest.setLatitude(89.90);
        geoFenceTest.setLongitude(878.9);
        geoFenceTest.setRadius(79.99);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/geofence/api/createGeo")
                .content(asJsonString(geoFenceTest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }


    public static String asJsonString(final  Object obj){
        try{
            return  new ObjectMapper().writeValueAsString(obj);
        }catch (Exception ex){
            throw  new RuntimeException(ex);
        }
    }
}
