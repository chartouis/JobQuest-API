package com.chitas.carderio.repo;

import com.chitas.carderio.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepo extends JpaRepository<Card, Long> {
}
