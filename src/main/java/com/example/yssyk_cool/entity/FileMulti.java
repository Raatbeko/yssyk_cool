package com.example.yssyk_cool.entity;

import com.example.yssyk_cool.util.FileType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "files")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileMulti extends BaseEntity {
    @Column(name = "path")
    String path;

    @Column(name = "url")
    String url;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    FileType fileType;

}
