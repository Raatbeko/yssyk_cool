package com.example.yssyk_cool.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "complexes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Complex extends BaseEntity {
    @Column(nullable = false)
    String complexName;

    @ManyToOne
    @JoinColumn(name = "location_id")
    Location location;

    @Column(name = "average_price")
    String averagePrice;

    @ManyToOne
    @JoinColumn(name = "contact_info_id")
    ContactInfo contactInfo;

    @ManyToOne
    @JoinColumn(name = "created_by")
    User user;

}
