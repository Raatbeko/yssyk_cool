insert into roles(id,name_role,create_time)
values
(1,'ROLE_ADMIN',now()),
(2,'ROLE_USER',now()),
(3,'ROLE_PROVIDER',now());

insert into users(create_time,user_name,email,password,is_active)
values(now(),'admin','admin@mail.com','$2y$10$GddmCLgKdLtKe8ldd/lmy.DeYv64Yb9lv3uyK8vCMTOOveWWyhQZm',true),
      (now(),'user','user@mail.com','$2y$10$GddmCLgKdLtKe8ldd/lmy.DeYv64Yb9lv3uyK8vCMTOOveWWyhQZm',true),
      (now(),'provider','provider@mail.com','$2y$10$GddmCLgKdLtKe8ldd/lmy.DeYv64Yb9lv3uyK8vCMTOOveWWyhQZm',true);

insert into user_roles(create_time,user_id,role_id)
values(now(),1,1),
      (now(),2,2),
      (now(),3,3);
