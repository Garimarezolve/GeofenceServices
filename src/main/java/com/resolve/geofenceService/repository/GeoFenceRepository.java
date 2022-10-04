package com.resolve.geofenceService.repository;

import com.resolve.geofenceService.entity.GeoFenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoFenceRepository extends JpaRepository<GeoFenceEntity, Long> {
}
