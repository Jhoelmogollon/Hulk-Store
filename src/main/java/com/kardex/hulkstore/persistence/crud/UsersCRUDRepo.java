package com.kardex.hulkstore.persistence.crud;

import com.kardex.hulkstore.persistence.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersCRUDRepo extends CrudRepository<Users, String> {

    Optional<Users> findByPhoneNumber(int phoneNumber);

    Optional<Users> findByEmail(String email);
}
