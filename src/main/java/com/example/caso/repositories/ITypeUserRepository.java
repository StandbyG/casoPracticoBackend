package com.example.caso.repositories;

import com.example.caso.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface ITypeUserRepository extends JpaRepository<Roles,Integer> {

    @Query(value = "select r.type_account, count(u.user_name)\n" +
            "\n" +
            "from Useror u inner join Roles r \n" +
            "\n" +
            "on u.id_user=r.useror \n"+
            "\n" +
            " group by r.type_account" , nativeQuery = true )
    public List<String[]> cantidadUsuarioRol();
}
