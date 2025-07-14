package org.testboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.testboard.domain.BoardVO;

public interface BoardMapper {
	
	@Select("SELECT * FROM tbl_board WHERE bno > 0") 
	public List<BoardVO> getList(); // 추상메서드

	public List<BoardVO> getList2();
	public void insert(BoardVO board); // xml에서 쿼리 작성
	
	public void insertSelectKey(BoardVO board); // xml에서 쿼리 작성
	

}
