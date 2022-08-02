CREATE TABLE roles (
                       id bigint NOT NULL,
                       create_time timestamp NOT NULL,
                       update_time timestamp NULL,
                       name_role varchar(255) NOT NULL,
                       CONSTRAINT roles_pkey PRIMARY KEY (id),
                       CONSTRAINT uk_huvt67m8co70tcbe9yogs1yan UNIQUE (name_role)
);
CREATE TABLE users (
                       id bigserial NOT NULL,
                       create_time timestamp NOT NULL,
                       update_time timestamp NULL,
                       email varchar(255) NOT NULL,
                       is_active bool default false,
                       user_name varchar(255) NOT NULL,
                       "password" varchar(255) NOT NULL,
                       CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
                       CONSTRAINT uk_k8d0f2n7n88w1a16yhua64onx UNIQUE (user_name),
                       CONSTRAINT users_pkey PRIMARY KEY (id)
);
CREATE TABLE user_roles (
                            id bigserial NOT NULL,
                            create_time timestamp NOT NULL,
                            update_time timestamp NULL,
                            role_id int8 NOT NULL,
                            user_id int8 NOT NULL,
                            CONSTRAINT user_roles_pkey PRIMARY KEY (id),
                            CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES roles(id),
                            CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE common_reference_type (
                                       id bigserial NOT NULL,
                                       create_time timestamp NOT NULL,
                                       update_time timestamp NULL,
                                       code_type int8 NULL,
                                       title varchar(255) NULL,
                                       CONSTRAINT common_reference_type_pkey PRIMARY KEY (id)
);
CREATE TABLE common_reference (
                                  id bigserial NOT NULL,
                                  create_time timestamp NOT NULL,
                                  update_time timestamp NULL,
                                  code_type int8 NULL,
                                  title varchar(255) NOT NULL,
                                  type_id int8 NULL,
                                  CONSTRAINT common_reference_pkey PRIMARY KEY (id),
                                  CONSTRAINT uk_33m5lx8b84rmuribxhknkkfo UNIQUE (title),
                                  CONSTRAINT fkkw831yyjhqulf1qwyndlme41u FOREIGN KEY (type_id) REFERENCES common_reference_type(id)
);
CREATE TABLE locations (
                           id bigserial NOT NULL,
                           create_time timestamp NOT NULL,
                           update_time timestamp NULL,
                           street_name varchar(255) NULL,
                           url_google_map varchar(255) NULL,
                           area_id int8 NULL,
                           city_id int8 NOT NULL,
                           CONSTRAINT locations_pkey PRIMARY KEY (id),
                           CONSTRAINT fkmb1rru8yodl83ngwflnvsj01d FOREIGN KEY (area_id) REFERENCES common_reference(id),
                           CONSTRAINT fkteslq4werhfmc9on4sx4sssmu FOREIGN KEY (city_id) REFERENCES common_reference(id)
);
CREATE TABLE files (
                       id bigserial NOT NULL,
                       create_time timestamp NOT NULL,
                       update_time timestamp NULL,
                       "type" varchar(255) NULL,
                       path varchar(255) NULL,
                       url varchar(255) NULL,
                       CONSTRAINT files_pkey PRIMARY KEY (id)
);
CREATE TABLE contact_info (
                              id bigserial NOT NULL,
                              create_time timestamp NOT NULL,
                              update_time timestamp NULL,
                              email varchar(255) NULL,
                              phone_number varchar(255) NOT NULL,
                              telegram varchar(255) NULL,
                              CONSTRAINT contact_info_pkey PRIMARY KEY (id)
);
CREATE TABLE complexes (
                           id bigserial NOT NULL,
                           created_by int8 NULL,
                           deleted_at timestamp without time zone,
                           deleted_by bigint references users (id),
                           create_time timestamp NOT NULL,
                           update_time timestamp NULL,
                           complex_name varchar(255) NOT NULL,
                           about_complex text NULL,
                           contact_info_id int8 NOT NULL,
                           type_complex bigint references common_reference(id) NOT NULL,
                           CONSTRAINT complexes_pkey PRIMARY KEY (id),
                           CONSTRAINT fklhsc6ddk4to49jmmwfqimp9m7 FOREIGN KEY (created_by) REFERENCES users(id),
                           CONSTRAINT fkmtcab2yb8jg0m3rkeafqv4w04 FOREIGN KEY (contact_info_id) REFERENCES contact_info(id)
);
CREATE TABLE reviews (
                         id bigserial NOT NULL,
                         create_time timestamp NOT NULL,
                         update_time timestamp NULL,
                         deleted_at timestamp without time zone,
                         deleted_by bigint references users (id),
                         created_by int8 NULL,
                         grade int8 NOT NULL,
                         review varchar(255) NULL,
                         complex_id int8 NOT NULL,
                         CONSTRAINT reviews_pkey PRIMARY KEY (id),
                         CONSTRAINT fkbhr9u7onobphbqso88pv0t82d FOREIGN KEY (created_by) REFERENCES users(id),
                         CONSTRAINT fk98ajl7pm083gfirfpkkka3hlx FOREIGN KEY (complex_id) REFERENCES complexes(id)
);

CREATE TABLE file_complexes (
                                id bigserial NOT NULL,
                                create_time timestamp NOT NULL,
                                update_time timestamp NULL,
                                complex_id int8 NOT NULL,
                                file_id int8 NOT NULL,
                                CONSTRAINT file_complexes_pkey PRIMARY KEY (id),
                                CONSTRAINT fk6q149sjr7pw8dqrqmcl6wsepd FOREIGN KEY (file_id) REFERENCES files(id),
                                CONSTRAINT fk98ajl7pm083gfirfpkkka3hlx FOREIGN KEY (complex_id) REFERENCES complexes(id)
);
CREATE TABLE complexes_reviews (
                                   complex_id int8 NOT NULL,
                                   reviews_id int8 NOT NULL,
                                   CONSTRAINT fkgbem52cfqubl2brwgig8q370l FOREIGN KEY (reviews_id) REFERENCES reviews(id),
                                   CONSTRAINT fkj38p8c77g5vndetkd0uq27hak FOREIGN KEY (complex_id) REFERENCES complexes(id)
);