package com.example.yssyk_cool.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "file_complexes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileComplex extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "file_id",nullable = false)
    FileMulti fileMulti;

    @ManyToOne
    @JoinColumn(name = "complex_id",nullable = false)
    Complex complexes;
}
