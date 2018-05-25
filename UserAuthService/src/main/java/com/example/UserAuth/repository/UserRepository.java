package com.example.UserAuth.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.UserAuth.model.User;
 
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
	public User findByUsername (String name);
}
