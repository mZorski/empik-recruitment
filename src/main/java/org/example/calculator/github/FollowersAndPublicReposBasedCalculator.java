package org.example.calculator.github;

import org.example.github.type.GitHubUserData;

import java.math.BigDecimal;
import java.math.MathContext;

public final class FollowersAndPublicReposBasedCalculator implements GitHubCalculator {

	private static final BigDecimal SIX = new BigDecimal(6);
	private static final BigDecimal TWO = new BigDecimal(2);

	@Override
	public GitHubCalculationResult calculate(GitHubUserData gitHubUserData) {
		if(gitHubUserData.getFollowers() == 0) {
			return GitHubCalculationResult.zero();
		}

		return GitHubCalculationResult.from(calculatePrivate(gitHubUserData));
	}

	private BigDecimal calculatePrivate(GitHubUserData gitHubUserData) {
		return calculate(toBigDecimal(gitHubUserData.getFollowers()), toBigDecimal(gitHubUserData.getPublicRepos()));
	}

	private BigDecimal calculate(BigDecimal numberOfFollowers, BigDecimal numberOfPublicRepos) {
		return SIX.divide(numberOfFollowers, MathContext.DECIMAL64).multiply(TWO.add(numberOfPublicRepos));
	}

	private BigDecimal toBigDecimal(long value) {
		return new BigDecimal(value);
	}
}
