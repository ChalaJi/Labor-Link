package com.microservice.UserProject.Repository;

import com.microservice.UserProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findBycName(String name);

    @Query(value = "SELECT * FROM user WHERE c_city LIKE %?1%", nativeQuery = true)
    List<User> areCityPrefix(String prefix);
}

