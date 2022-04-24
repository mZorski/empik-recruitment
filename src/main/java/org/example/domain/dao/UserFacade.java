package org.example.domain.dao;

import lombok.RequiredArgsConstructor;
import org.example.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserFacade {

	private final UserRepository userRepository;

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public void incrementRequestCountOrCreate(String login) {
		userRepository.findById(login).ifPresentOrElse(user -> {
			user.incrementRequestCount();
			userRepository.save(user);
		}, () -> userRepository.save(new User(login, 1L)));
	}

}
