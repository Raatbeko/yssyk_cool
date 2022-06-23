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

    Long codeType;

    @ManyToOne
    @JoinColumn(name = "type_id")
    CommonReferenceType commonReferenceType;

    @Column(name = "title")
    String title;
}
