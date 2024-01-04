package com.example.caso.repositories;

import com.example.caso.entities.Useror;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<Useror,Integer> {
    public Useror findByUserName(String userName);
    public Useror findUserorByUserName(String username);
    @Query("select count(u.userName) from Useror u where u.userName = :username")
    public int buscarUsername(@Param("username") String nombre);

    @Query ("select count (u.userName) from Useror u")
    public int cantidadUsuario();
}