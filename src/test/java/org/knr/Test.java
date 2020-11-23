package org.knr;

import java.util.List;

import org.knr.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class Test {
	@Autowired
	MongoTemplate mongoTemplate;
	
	@org.junit.jupiter.api.Test
	public void insrtTest() {
		Board board = new Board(3L, "title3", "content3", "user03");
		mongoTemplate.insert(board);
		log.info("board insert"+board);
		
	}
	
	@org.junit.jupiter.api.Test
	public void selectAllTest() {
		//java.util.List<Board> list = mongoTemplate.findAll(Board.class, "board");
		java.util.List<Board> list = mongoTemplate.findAll(Board.class, "board");
		list.forEach(board->log.info("board: "+board));
	}
	
	@org.junit.jupiter.api.Test
	public void findCriteriaTest() {
		Criteria criteria = new Criteria("writer");
		criteria.is("user");
		Query query = new Query(criteria);
		List<Board> list = mongoTemplate.find(query, Board.class);
		list.forEach(board->log.info("board: "+board));
	}
	
	@org.junit.jupiter.api.Test
	public void updateTest() {
		Criteria criteria = new Criteria("bno");
		criteria.is(1l);
		Query query = new Query(criteria);
		Update update = new Update();
		update.set("content", "내용1입니다");
		update.set("title", "title1입니다");
		mongoTemplate.updateFirst(query, update, Board.class);
		
	}
}
