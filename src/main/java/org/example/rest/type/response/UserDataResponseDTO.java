package org.example.rest.type.response;

import org.example.github.type.GitHubAccountType;
import org.example.user.type.response.UserDataResponse;

import java.net.URL;
import java.time.Instant;

public class UserDataResponseDTO {

	public Long id;
	public String login;
	public String name;
	public GitHubAccountType type;
	public URL avatarUrl;
	public Instant createdAt;
	public Object calculations;

	public UserDataResponseDTO(UserDataResponse userDataResponse) {
		this.id = userDataResponse.getId();
		this.login = userDataResponse.getLogin();
		this.name = userDataResponse.getName();
		this.type = userDataResponse.getType();
		this.avatarUrl = userDataResponse.getAvatarUrl();
		this.createdAt = userDataResponse.getCreatedAt();
		this.calculations = userDataResponse.getCalculationResult().getResult();
	}
}
