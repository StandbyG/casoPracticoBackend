package com.example.caso.controllers;

import com.example.caso.dtos.UserDTO;
import com.example.caso.entities.Useror;
import com.example.caso.servicesinterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService uS;
    @PostMapping
    public void registrar(@RequestBody UserDTO dto){
        ModelMapper m = new ModelMapper();
        Useror u =m.map(dto, Useror.class);
        uS.insert(u);
    }
    @GetMapping
    public List<UserDTO>listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/user-por-id/{id}")
    public UserDTO findById(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        UserDTO dto=m.map(uS.findById(id),UserDTO.class);
        return dto;
    }
    @DeleteMapping("/{idUser}")
    public void eliminar(@PathVariable ("idUser") Integer idUser){
        uS.delete(idUser);
    }

    public void modificar(@RequestBody UserDTO dto){
        ModelMapper m = new ModelMapper();
        Useror u =m.map(dto,Useror.class);
        uS.insert(u);
    }

    @GetMapping("/{userName}")
    public UserDTO findByUserName (@PathVariable("userName") String userName){
        ModelMapper m=new ModelMapper();
        UserDTO dto=m.map(uS.findByUserName(userName),UserDTO.class);
        return dto;
    }

  /* @PostMapping("/{userId}/follow-event/{eventId}")
    public  ResponseEntity<String> followEvent(@PathVariable int userId, @PathVariable int eventId) {
        eS.followEvent(userId, eventId);
        return ResponseEntity.ok("Usuario ha seguido el evento exitosamente.");
    }

    @PostMapping("/{userId}/unfollow-event/{eventId}")
    public ResponseEntity<String> unfollowEvent(@PathVariable int userId, @PathVariable int eventId) {
        eS.unfollowEvent(userId, eventId);
        return ResponseEntity.ok("Usuario ha dejado de seguir el evento exitosamente.");
    }*/
}
