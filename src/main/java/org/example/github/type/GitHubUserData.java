package org.example.github.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.example.github.type.response.GitHubUserDataRestResponse;

import java.net.URL;
import java.time.Instant;

@Getter
@EqualsAndHashCode
public class GitHubUserData {

	private final String login;
	private final Long id;
	private final URL avatarUrl;
	private final String name;
	private final GitHubAccountType type;
	private final long followers;
	private final long publicRepos;
	private final Instant createdAt;

	public GitHubUserData(GitHubUserDataRestResponse gitHubUserDataRestResponse) {
		this.login = gitHubUserDataRestResponse.getLogin();
		this.id = gitHubUserDataRestResponse.getId();
		this.avatarUrl = gitHubUserDataRestResponse.getAvatarUrl();
		this.name = gitHubUserDataRestResponse.getName();
		this.type = gitHubUserDataRestResponse.getType();
		this.followers = gitHubUserDataRestResponse.getFollowers();
		this.publicRepos = gitHubUserDataRestResponse.getPublicRepos();
		this.createdAt = gitHubUserDataRestResponse.getCreatedAt();
	}

	protected GitHubUserData(GitHubUserData gitHubUserData) {
		this.login = gitHubUserData.getLogin();
		this.id = gitHubUserData.getId();
		this.avatarUrl = gitHubUserData.getAvatarUrl();
		this.name = gitHubUserData.getName();
		this.type = gitHubUserData.getType();
		this.followers = gitHubUserData.getFollowers();
		this.publicRepos = gitHubUserData.getPublicRepos();
		this.createdAt = gitHubUserData.getCreatedAt();
	}

}
