package org.example.user.type.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.calculator.api.CalculationResult;
import org.example.github.type.GitHubAccountType;
import org.example.github.type.GitHubUserDataWithCalculations;

import java.net.URL;
import java.time.Instant;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDataResponse {

	private final Long id;
	private final String login;
	private final String name;
	private final GitHubAccountType type;
	private final URL avatarUrl;
	private final Instant createdAt;
	private final CalculationResult<?> calculationResult;

	public static UserDataResponse from(GitHubUserDataWithCalculations gitHubUserDataWithCalculations) {
		return new UserDataResponse(
			gitHubUserDataWithCalculations.getId(),
			gitHubUserDataWithCalculations.getLogin(),
			gitHubUserDataWithCalculations.getName(),
			gitHubUserDataWithCalculations.getType(),
			gitHubUserDataWithCalculations.getAvatarUrl(),
			gitHubUserDataWithCalculations.getCreatedAt(),
			gitHubUserDataWithCalculations.getCalculationResult());
	}
}
