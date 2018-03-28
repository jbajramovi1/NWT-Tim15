package com.springjpa.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
	public User findByEmail(String email);
	public User findByIdKorisnika(Integer id);
	public List<User> findAll();
	public boolean existsByIdKorisnika(Integer id);
}
