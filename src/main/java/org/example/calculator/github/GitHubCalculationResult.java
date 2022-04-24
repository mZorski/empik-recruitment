package org.example.calculator.github;

import lombok.EqualsAndHashCode;
import org.example.calculator.api.CalculationResult;

import java.math.BigDecimal;
import java.util.Objects;

@EqualsAndHashCode
public final class GitHubCalculationResult implements CalculationResult<BigDecimal> {

	private final BigDecimal result;

	private GitHubCalculationResult(BigDecimal result) {
		Objects.requireNonNull(result);
		this.result = result;
	}

	@Override
	public BigDecimal getResult() {
		return result;
	}

	static GitHubCalculationResult zero() {
		return new GitHubCalculationResult(BigDecimal.ZERO);
	}

	static GitHubCalculationResult from(BigDecimal result) {
		return new GitHubCalculationResult(result);
	}

}
