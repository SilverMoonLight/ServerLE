package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.dataentity.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {

}
