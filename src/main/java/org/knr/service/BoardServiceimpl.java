package org.knr.service;

import java.util.List;

import org.knr.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceimpl implements BoardService{

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public void regisert(Board board) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(board);
	}

	@Override
	public List<Board> findAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Board.class, "board");
	}

	@Override
	public Board find(Long bno) {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria("bno");
		criteria.is(bno);
		Query query = new Query(criteria);
		return mongoTemplate.findOne(query, Board.class);
	}

	@Override
	public void modify(Board board) {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria("bno");
		criteria.is(board.getBno());
		Query query = new Query(criteria);
		Update update = new Update();
		update.set("title", board.getTitle());
		update.set("content", board.getContent());
		update.set("writer", board.getWriter());
		mongoTemplate.updateFirst(query, update, Board.class);
		
	}

	@Override
	public void remove(Long bno) {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria("bno");
		criteria.is(bno);
		Query query = new Query(criteria);
		mongoTemplate.remove(query, Board.class);
	}

	
}
