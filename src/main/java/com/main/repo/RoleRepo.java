package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.dataentity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
