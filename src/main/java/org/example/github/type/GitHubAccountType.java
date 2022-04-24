package org.example.github.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GitHubAccountType {

	USER("User"),
	ORGANIZATION("Organization");

	private final String value;


	@Override
	public String toString() {
		return value;
	}
}
