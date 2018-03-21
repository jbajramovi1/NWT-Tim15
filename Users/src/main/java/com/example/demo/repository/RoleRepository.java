package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;

import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {

}
