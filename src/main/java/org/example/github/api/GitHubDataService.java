package org.example.github.api;

import org.example.github.type.GitHubUserData;
import org.example.github.type.GitHubUserDataWithCalculations;

import java.util.Optional;

public interface GitHubDataService {

	Optional<GitHubUserData> getGitHubUserData(String login);

	Optional<GitHubUserDataWithCalculations> getGitHubUserDataWithCalculations(String login);
}
