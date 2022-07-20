package com.kys.securityTest.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kys.securityTest.security.enums.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserDTO {

	@Id	// pk
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_pw")
	private String userPw;
	
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
