package com.example.yssyk_cool.repository;

import com.example.yssyk_cool.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "select u.* from users u where u.user_name =:findByUserNameAndEMail or u.email =:findByUserNameAndEMail")
    User findByUserNameAndEMail(String findByUserNameAndEMail);

}
