package com.resolve.geofenceService.service;

import com.resolve.geofenceService.constant.ApplicationConstants;
import com.resolve.geofenceService.dto.ErrorResponseDto;
import com.resolve.geofenceService.dto.ResponseDto;
import com.resolve.geofenceService.dto.SuccessResponseDto;
import com.resolve.geofenceService.entity.GeoFenceEntity;
import com.resolve.geofenceService.repository.GeoFenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoFenceService {
    @Autowired
    GeoFenceRepository geoFenceRepository;


    /*
    This methods creates new geofence and returns unique id in the response
     */
    public ResponseDto createGeofence(GeoFenceEntity geoFenceEntity) {
        return new SuccessResponseDto(geoFenceRepository.save(geoFenceEntity));
    }

    /*
    This method returns all available geofence in the system.
     */
    public ResponseDto getGeoFences() {
        List<GeoFenceEntity> geoFences = geoFenceRepository.findAll();
        return new SuccessResponseDto(geoFences);
    }

    /*
       This method delete geofence in the system bases on unique geoId.
        */
    public ResponseDto deleteGeoFence(Long geoId) {
        if (geoFenceRepository.findById(geoId).isPresent()) {
            geoFenceRepository.deleteById(geoId);
            return new SuccessResponseDto(ApplicationConstants.HTTP_RESPONSE_SUCCESS_CODE);
        }

        return new ErrorResponseDto(ApplicationConstants.HTTP_RESPONSE_ERROR_CODE_NOT_FOUND, ApplicationConstants.HTTP_RESPONSE_ERROR_CODE_NOT_FOUND_MSG);
    }

    /*
     This method updates geofence data in the system bases on unique geoId.
      */
    public ResponseDto updateGeoFence(GeoFenceEntity geoFenceEntity) {
        return geoFenceRepository.findById(geoFenceEntity.getId()).isPresent()
                ? new SuccessResponseDto(geoFenceRepository.save(geoFenceEntity)) : new ErrorResponseDto(ApplicationConstants.HTTP_RESPONSE_ERROR_CODE_NOT_FOUND, ApplicationConstants.HTTP_RESPONSE_ERROR_CODE_NOT_FOUND_MSG);
    }

}
