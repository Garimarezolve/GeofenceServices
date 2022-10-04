package com.resolve.geofenceService.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "geo_fence")
@Getter
@Setter
public class GeoFenceEntity  extends  AuditEntity{

    @Id
    @GeneratedValue(generator = "geo_generator")
    private Long Id;
    @NotNull
    @Digits(integer = 6, fraction = 7, message = "at max 7 precision allowed")
    private Double longitude;
    @NotNull
    @Digits(integer = 6, fraction = 7, message = "at max 7 precision allowed")
    private Double latitude;
    @NotNull
    @Digits(integer = 6, fraction = 7, message = "at max 7 precision allowed")
    private Double radius;

}
