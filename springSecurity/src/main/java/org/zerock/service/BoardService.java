package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	
	public void register (BoardVO board);
	
	public BoardVO get(Integer bno);
	public boolean modify(BoardVO board);
	public boolean remove(Integer bno);
	
	public List<BoardVO>getList();

}
