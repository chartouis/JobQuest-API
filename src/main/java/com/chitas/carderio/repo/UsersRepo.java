package com.chitas.carderio.repo;

import com.chitas.carderio.model.Card;
import com.chitas.carderio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    @Query("SELECT u.cards FROM User u WHERE u.username = :username")
    List<Card> findCardsByUsername(@Param("username") String username);
}

