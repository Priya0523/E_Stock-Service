package com.fse.stcokdetails.Repository;


import com.fse.stcokdetails.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}