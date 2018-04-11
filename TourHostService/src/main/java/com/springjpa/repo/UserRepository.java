package com.springjpa.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByIdKorisnika(Integer id);
}