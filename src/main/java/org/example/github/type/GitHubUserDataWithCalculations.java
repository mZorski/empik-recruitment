package org.example.github.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.example.calculator.github.GitHubCalculationResult;
import org.example.github.type.response.GitHubUserDataRestResponse;

@Getter
@EqualsAndHashCode
public class GitHubUserDataWithCalculations extends GitHubUserData {

	private final GitHubCalculationResult calculationResult;

	public GitHubUserDataWithCalculations(GitHubUserDataRestResponse gitHubUserDataRestResponse, GitHubCalculationResult calculationResult) {
		super(gitHubUserDataRestResponse);
		this.calculationResult = calculationResult;
	}

	public GitHubUserDataWithCalculations(GitHubUserData gitHubUserData, GitHubCalculationResult calculationResult) {
		super(gitHubUserData);
		this.calculationResult = calculationResult;
	}
}
