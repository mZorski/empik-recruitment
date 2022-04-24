package org.example.rest;

import lombok.RequiredArgsConstructor;
import org.example.rest.type.response.UserDataResponseDTO;
import org.example.user.api.UserService;
import org.example.user.exception.NoSuchUserException;
import org.example.user.type.request.UserDataRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/users", consumes = {MediaType.ALL_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserDataController {

	private final Logger logger = LoggerFactory.getLogger(UserDataController.class);
	private final UserService userService;

	@GetMapping("/{login}")
	@ResponseBody
	public UserDataResponseDTO login(@PathVariable("login") String login) {
		logger.debug("(GET) /{login}: {}", login);

		var result = userService.getUserDataResponse(new UserDataRequest(login));
		return new UserDataResponseDTO(result);
	}

	@ExceptionHandler(NoSuchUserException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNoSuchUserException(NoSuchUserException exception) {
		return exception.getMessage();
	}

}
