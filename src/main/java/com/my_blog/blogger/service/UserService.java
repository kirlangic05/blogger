package com.my_blog.blogger.service;

import com.my_blog.blogger.model.Useras;
import com.my_blog.blogger.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    UserRepository repo;

    public List<Useras> findAllUsers(){
       return repo.findAll();
    }

    public Useras findUserById(Long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException(id + " -> This id doesn't exist"));
    }

    public Useras saveUser(Useras user){
        return repo.save(user);
    }

    public void deleteUser(Long id){
        repo.deleteById(id);
    }

//    public Useras editUser(Useras user, Long id){
//        user.setId(id);
//        return repo.save(user);
//    }
    public Useras editUser(Useras requestUser,Long id){
        Useras existingUser = repo.findById(requestUser.getId()).orElseThrow(()-> new RuntimeException(id + " -> This id doesn't exist"));
        existingUser.setUsername(requestUser.getUsername());
        existingUser.setEmail(requestUser.getEmail());
        existingUser.setPassword(requestUser.getPassword());
        return repo.save(existingUser);
    }

}
