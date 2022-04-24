package org.example.user.api;

import org.example.user.type.request.UserDataRequest;
import org.example.user.type.response.UserDataResponse;

public interface UserService {

	UserDataResponse getUserDataResponse(UserDataRequest request);
}
