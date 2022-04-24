package org.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@Column(name = "LOGIN")
	private String login;

	@Column(name = "REQUEST_COUNT", nullable = false)
	private Long requestCount;

	public void incrementRequestCount() {
		requestCount++;
	}
}
