package com.kys.securityTest.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kys.securityTest.model.dto.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, String>{
	
    UserDTO findByUserEmailAndUserPw(String userId, String userPw);

    Optional<UserDTO> findByUserEmail(String userEmail);
}
