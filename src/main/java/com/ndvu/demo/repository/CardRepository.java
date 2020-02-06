package com.ndvu.demo.repository;

import com.ndvu.demo.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
