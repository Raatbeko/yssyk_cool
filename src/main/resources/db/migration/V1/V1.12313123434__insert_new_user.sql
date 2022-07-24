insert into users(create_time,user_name,email,password)
values(now(),'admin','admin@mail.com','$2y$10$GddmCLgKdLtKe8ldd/lmy.DeYv64Yb9lv3uyK8vCMTOOveWWyhQZm'),
      (now(),'user','user@mail.com','$2y$10$GddmCLgKdLtKe8ldd/lmy.DeYv64Yb9lv3uyK8vCMTOOveWWyhQZm'),
      (now(),'provider','provider@mail.com','$2y$10$GddmCLgKdLtKe8ldd/lmy.DeYv64Yb9lv3uyK8vCMTOOveWWyhQZm');

insert into user_roles(create_time,user_id,role_id)
values(now(),1,1),
      (now(),2,2),
      (now(),3,3);
