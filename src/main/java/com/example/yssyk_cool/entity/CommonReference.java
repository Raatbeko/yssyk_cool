package com.example.yssyk_cool.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "common_reference")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonReference extends BaseEntity{

    Long typeCode;

    @ManyToOne
    @JoinColumn(name = "type_id")
    CommonReferenceType commonReferenceType;

    @Column(name = "title",unique = true,nullable = false)
    String title;
}
