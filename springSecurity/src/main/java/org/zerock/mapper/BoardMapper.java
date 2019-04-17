package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.domain.BoardVO;



public interface BoardMapper {
	
	@Select("SELECT * from tbl_board where bno >0 order by bno desc")
	public List<BoardVO> getList();
	
	@Insert("insert into tbl_board (title, content, writer)\r\n" + 
			"		values(#{title},#{content},#{writer})")
	public void insert (BoardVO board);
	
	
	
	
	public void insertSelectKey(BoardVO board);
	
	
	@Select("select bno, title,content, writer, regdate, viewcnt\r\n" + 
			"		from tbl_board\r\n" + 
			"		where bno=#{bno}")
	public BoardVO read(Integer bno);
	
	
	@Delete("delete from tbl_board where bno=#{bno}")
	public int delete(Integer bno);
	
	@Update("update tbl_board set title =#{title}, content=#{content}\r\n" + 
			"		where bno=#{bno}")
	public int update (BoardVO board);
	
}
