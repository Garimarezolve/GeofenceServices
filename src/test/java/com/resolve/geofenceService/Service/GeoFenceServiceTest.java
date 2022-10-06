package com.resolve.geofenceService.Service;

import com.resolve.geofenceService.dto.ResponseDto;
import com.resolve.geofenceService.entity.GeoFenceEntity;
import com.resolve.geofenceService.repository.GeoFenceRepository;
import com.resolve.geofenceService.service.GeoFenceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class GeoFenceServiceTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    GeoFenceRepository geoFenceRepository;
    @InjectMocks
    GeoFenceService geoFenceService;
    GeoFenceEntity geoFenceEntity= new GeoFenceEntity();
    List<GeoFenceEntity> geos = new ArrayList<>();
    @BeforeEach
    public void setup() {
        geoFenceEntity.setId(3L);
        geoFenceEntity.setRadius(10000.0);
        geoFenceEntity.setLatitude(10.0);
        geoFenceEntity.setLongitude(11.0);
        geos.add(geoFenceEntity);
    }
    @Test
    void createGeofence(){
        given(geoFenceRepository.save(Mockito.any())).willReturn(geoFenceEntity);
        GeoFenceEntity geoFenceResponse= (GeoFenceEntity) geoFenceService.createGeofence(geoFenceEntity).getData();
        Assertions.assertEquals(geoFenceEntity.getId(),geoFenceResponse.getId());
    }
    @Test
    void getGeoFence(){
        given(geoFenceRepository.findAll()).willReturn(geos);
        List<GeoFenceEntity>geoFenceResponse= (List<GeoFenceEntity>) geoFenceService.getGeoFences().getData();
        Assertions.assertEquals(geos.size(),geoFenceResponse.size());
    }
    @Test
    void updateGeoFence(){
        geoFenceEntity.setLatitude(987.99);
        given(geoFenceRepository.findById(Mockito.any())).willReturn(Optional.of(geoFenceEntity));
        given(geoFenceRepository.save(geoFenceEntity)).willReturn(geoFenceEntity);
        ResponseDto geoModelResponse = geoFenceService.updateGeoFence(geoFenceEntity);
        Assertions.assertEquals(200,geoModelResponse.getCode());
    }

    @Test
    void deleteGeo() {
        given(geoFenceRepository.findById(Mockito.any())).willReturn(Optional.of(geoFenceEntity));
        ResponseDto geoModelResponse =  geoFenceService.deleteGeoFence(geoFenceEntity.getId());
        Assertions.assertEquals(200,geoModelResponse.getCode());
    }

    @Test
    void updateGeo_failed() {
        geoFenceEntity.setId(9L);
        geoFenceEntity.setLongitude(11.23);
        given(geoFenceRepository.findById(Mockito.any())).willReturn(Optional.empty());
        ResponseDto geoModelResponse = geoFenceService.updateGeoFence(geoFenceEntity);
        Assertions.assertEquals(404,geoModelResponse.getCode());
    }


}
