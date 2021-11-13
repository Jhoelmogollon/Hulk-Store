package com.kardex.hulkstore.domain.repository;

import com.kardex.hulkstore.persistence.crud.UsersCRUDRepo;
import com.kardex.hulkstore.persistence.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepo {

    private UsersCRUDRepo usersCRUDRepo;

    public List<Users> getAll() { return (List<Users>) usersCRUDRepo.findAll(); }

    public Optional<Users> getById(String idUser) { return usersCRUDRepo.findById(idUser);}

    public Optional<Users> getByPhoneNumber(int phoneNumber) {
        return usersCRUDRepo.findByPhoneNumber(phoneNumber);
    }

    public Optional<Users> getByEmail(String email) {
        return usersCRUDRepo.findByEmail(email);
    }

    public Users save(Users newUsers) {
        return usersCRUDRepo.save(newUsers);
    }

    public void deleteById(String idUsers) {
        usersCRUDRepo.deleteById(idUsers);
    }

    public void deleteByEntity(Users users) {
        usersCRUDRepo.delete(users);
    }
}
