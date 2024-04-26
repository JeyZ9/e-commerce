package com.app.paymentgitproject.repository;

import com.app.paymentgitproject.model.AuthenticationToken;
import com.app.paymentgitproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findTokenByUser(User user);

    AuthenticationToken findTokenByToken(String token);
}
