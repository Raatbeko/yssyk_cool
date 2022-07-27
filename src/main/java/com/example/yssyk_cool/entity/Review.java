package com.example.yssyk_cool.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Review extends BaseEntity {

    @Column(name = "review")
    String review;

    @Column(nullable = false)
    Long grade;

    @ManyToOne
    @JoinColumn(name = "created_by")
    User user;

    @ManyToOne
    @JoinColumn(name = "complex_id")
    Complex complexId;

    @OneToOne
    @JoinColumn(name = "deleted_by")
    User deletedBy;

    @Column(name = "deleted_at")
    LocalDateTime deletedAt;


}
