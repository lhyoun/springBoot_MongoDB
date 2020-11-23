package org.knr.repository;

import org.knr.domain.Board;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardRepository extends MongoRepository<Board, Long> {
	
}
