package com.example.yssyk_cool.entity;

import com.example.yssyk_cool.enums.TypeComplex;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import javax.persistence.*;
import javax.validation.constraints.Max;
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

    @ManyToMany
    @JoinColumn(name = "review_id")
    List<Review> reviews = new ArrayList<>();
}
