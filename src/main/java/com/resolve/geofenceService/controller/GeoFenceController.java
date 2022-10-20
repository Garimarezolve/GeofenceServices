package com.resolve.geofenceService.controller;

import com.resolve.geofenceService.dto.ResponseDto;
import com.resolve.geofenceService.entity.GeoFenceEntity;
import com.resolve.geofenceService.service.GeoFenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/geofence/api")
public class GeoFenceController {

    @Autowired
    GeoFenceService geoFenceService;

    @PostMapping("/Geo")
    public ResponseDto addGeoFence(@Valid @RequestBody GeoFenceEntity request) {
        log.info("creating geofence for request {}", request);
        return geoFenceService.createGeofence(request);
    }

    @GetMapping("/Geos")
    public ResponseDto getGeoFences() {
        log.info("finding geofence list ");
        return geoFenceService.getGeoFences();
    }

    @DeleteMapping("/Geo"+"/{geoId}")
    public ResponseDto deleteGeoFence(@PathVariable final Long geoId) {
        log.info("deleting geofence for {} ", geoId);
        return geoFenceService.deleteGeoFence(geoId);
    }

    @PutMapping("/Geo")
    public ResponseDto updateGeoFence(@Valid @RequestBody GeoFenceEntity request) {
        log.info("updating geofence for {}", request);
        return geoFenceService.updateGeoFence(request);
    }

}
