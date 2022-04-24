package org.example.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.dao.UserFacade;
import org.example.github.api.GitHubDataService;
import org.example.user.api.UserService;
import org.example.user.exception.NoSuchUserException;
import org.example.user.type.request.UserDataRequest;
import org.example.user.type.response.UserDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService {

	private final UserFacade userFacade;
	private final GitHubDataService gitHubDataService;

	@Override
	public UserDataResponse getUserDataResponse(UserDataRequest request) {
		Objects.requireNonNull(request);
		var gitHubUserDataWithCalculationsOptional = gitHubDataService.getGitHubUserDataWithCalculations(request.getLogin());

		if(gitHubUserDataWithCalculationsOptional.isEmpty()) {
			throw new NoSuchUserException(request.getLogin());
		}

		var gitHubUserDataWithCalculations = gitHubUserDataWithCalculationsOptional.get();
		userFacade.incrementRequestCountOrCreate(gitHubUserDataWithCalculations.getLogin());

		return UserDataResponse.from(gitHubUserDataWithCalculations);
	}

}
