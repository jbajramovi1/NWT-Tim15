package com.springjpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
	public User findByEmail(String email);
	public Optional<User> findUserById(Integer id);
	public User findByUsername(String username);
	public List<User> findAll();
	public boolean existsById(Integer id);
}
