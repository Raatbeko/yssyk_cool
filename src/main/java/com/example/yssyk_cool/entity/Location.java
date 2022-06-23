package com.example.yssyk_cool.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Location extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "city_id",nullable = false)
    CommonReference city;

    @ManyToOne
    @JoinColumn(name = "area_id")
    CommonReference area;

    @Column(name = "street_name")
    String streetName;

    @Column(name = "url_google_map")
    String urlGoogleMap;
}
