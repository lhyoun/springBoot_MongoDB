package org.knr.service;

import java.util.List;

import org.knr.domain.Board;

public interface BoardService {

	public void regisert(Board board);
	public List<Board> findAll();
	public Board find(Long bno);
	public void modify(Board board);
	public void remove(Long bno);
	
}
