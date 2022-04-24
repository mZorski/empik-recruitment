package org.example.github;

import lombok.RequiredArgsConstructor;
import org.example.calculator.github.FollowersAndPublicReposBasedCalculator;
import org.example.github.api.GitHubDataService;
import org.example.github.type.GitHubUserData;
import org.example.github.type.GitHubUserDataWithCalculations;
import org.example.github.type.response.GitHubUserDataRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GitHubDataServiceImpl implements GitHubDataService {

	private final Logger logger = LoggerFactory.getLogger(GitHubDataServiceImpl.class);
	private final RestTemplate restTemplate;

	@Override
	public Optional<GitHubUserData> getGitHubUserData(String login) {
		return getGitHubUserDataResponse(login).map(GitHubUserData::new);
	}

	@Override
	public Optional<GitHubUserDataWithCalculations> getGitHubUserDataWithCalculations(String login) {
		return getGitHubUserData(login).map(gitHubUserData -> new GitHubUserDataWithCalculations(gitHubUserData, new FollowersAndPublicReposBasedCalculator().calculate(gitHubUserData)));
	}

	private boolean isValidLogin(String login) {
		return login != null && login.length() < 40 && login.matches("^\\w+-?\\w+$");
	}

	private Optional<GitHubUserDataRestResponse> getGitHubUserDataResponse(String login) {
		if(!isValidLogin(login)) {
			return Optional.empty();
		}

		GitHubUserDataRestResponse response = null;
		try {
			response = restTemplate.getForObject("/users/{login}", GitHubUserDataRestResponse.class, login);
		} catch(RestClientException e) {
			logger.error(String.format("Failed to fetch user data for login: %s", login), e);
		}

		return Optional.ofNullable(response);
	}

}
