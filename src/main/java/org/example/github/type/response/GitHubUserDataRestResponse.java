package org.example.github.type.response;

import lombok.Data;
import org.example.github.type.GitHubAccountType;

import java.net.URL;
import java.time.Instant;

@Data
public class GitHubUserDataRestResponse {
	private String login;
	private Long id;
	private URL avatarUrl;
	private String name;
	private GitHubAccountType type;
	private long followers;
	private long publicRepos;
	private Instant createdAt;
}
