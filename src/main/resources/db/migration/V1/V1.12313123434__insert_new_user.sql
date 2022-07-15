insert into users(create_time,user_name,email,password)
values(now(),'admin','admin@mail.com','$2y$10$GddmCLgKdLtKe8ldd/lmy.DeYv64Yb9lv3uyK8vCMTOOveWWyhQZm'),
      (now(),'user','user@mail.com','$2y$10$GddmCLgKdLtKe8ldd/lmy.DeYv64Yb9lv3uyK8vCMTOOveWWyhQZm'),
      (now(),'provider','provider@mail.com','$2y$10$GddmCLgKdLtKe8ldd/lmy.DeYv64Yb9lv3uyK8vCMTOOveWWyhQZm');

insert into user_roles(create_time,user_id,role_id)
values(now(),1,1),
      (now(),2,2),
      (now(),3,3);

insert into contact_info(create_time,email,phone_number,telegram)
values(now(),'mail@mail.com','+78787887877','@telegram'),
      (now(),'buld@mail.com','31237456787','@mult'),
      (now(),'reason@mail.com','+998789997','@reason');

insert into locations(create_time,street_name,url_google_map,area_id,city_id)
values(now(),'Toktonalieva','jakdf1234124hfjahsjfdkha',1,2),
      (now(),'Bokonbaeva','ja123412536fjahsjfdkha',3,4),
      (now(),'Razakova','jakdfa8596574352kha',2,2);

insert into complexes(create_time,average_price,complex_name,contact_info_id,location_id,created_by)
values(now(),'12500','Manas',1,1,2),
      (now(),'1000$','Complex',2,2,2),
      (now(),'2000','Brat',3,3,2);