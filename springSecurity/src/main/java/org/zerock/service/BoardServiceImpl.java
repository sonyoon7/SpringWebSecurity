package org.zerock.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;


@Service
@AllArgsConstructor  //생성자 만듬
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod=@__({@Autowired}))  //setter를 통한 주입 
	private BoardMapper mapper; //interface
	
	
	@Override
	public void register(BoardVO board) {
		mapper.insert(board);
		
	}

	@Override
	public BoardVO get(Integer bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Integer bno) {
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList() {
		return  mapper.getList();
	}
	
	
	

}
