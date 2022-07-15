package com.example.yssyk_cool.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contact_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactInfo extends BaseEntity {

    @Column(name = "phone_number",nullable = false)
    String phoneNumber;

    @Column(name = "telegram")
    String telegramAccountName;

    String email;

}
