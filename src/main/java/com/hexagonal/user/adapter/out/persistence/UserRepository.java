package com.hexagonal.user.adapter.out.persistence;


import com.hexagonal.user.application.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByName(String name);

  @Query("select u from User u where u.name = :name")
  User findByNameCustomQuery(@Param("name") String name);

  @Query(value = "select * from user as u where u.name = :name", nativeQuery = true)
  User findByNameNativeQuery(@Param("name") String name);

}
