package com.example.yssyk_cool.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @JoinColumn(name = "location_id", nullable = false)
    Location location;

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

    @ManyToOne
    @JoinColumn(name = "type_complex")
    CommonReference typeComplex;

    @ManyToMany
    @JoinColumn(name = "review_id")
    List<Review> reviews = new ArrayList<>();

}
