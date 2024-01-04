package com.example.caso.serviceimplements;
import com.example.caso.entities.Useror;
import com.example.caso.repositories.IUserRepository;
import com.example.caso.servicesinterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImplement(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        passwordEncoder = new BCryptPasswordEncoder();
    }

    //private EventsRepository eR;
    @Override
    public void insert(Useror user) {
        String encoderPassword = this.passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(encoderPassword);
        if(user.getEnabled() == null)
            user.setEnabled(true);
        uR.save(user);
    }

    @Override
    public List<Useror> list() {
        return uR.findAll();
    }

    @Override
    public void delete(int idUser) {
        uR.deleteById(idUser);
    }

    @Override
    public Useror findByUserName(String userName)
    {
        return uR.findByUserName(userName);
    }

    @Override
    public Useror findById(int id) {
        return uR.findById(id).orElse(new Useror());
    }

}
