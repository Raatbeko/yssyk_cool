package com.example.yssyk_cool.entity;

import com.example.yssyk_cool.enums.TypeComplex;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @JoinColumn(name = "location_id", nullable = false)
    Location location;

    @Column(name = "average_price")
    String averagePrice;

    @ManyToOne
    @JoinColumn(name = "contact_info_id", nullable = false)
    ContactInfo contactInfo;

    @ManyToOne
    @JoinColumn(name = "created_by")
    User user;

    @OneToOne
    @JoinColumn(name = "deleted_by")
    User deletedBy;

    @Column(name = "deleted_at")
    LocalDateTime deletedAt;

    @Column(name = "types",nullable = false)
    @Enumerated(value = EnumType.STRING)
    TypeComplex typeComplex;

}
