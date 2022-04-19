package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.User;
import com.example.teamb4spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

  private final UserRepository userRepository;

  @Override
  public JpaRepository<User, Long> getRepository() {
    return userRepository;
  }
}
