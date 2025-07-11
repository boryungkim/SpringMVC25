package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;
import org.mbc.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service // 이 클래스는 서비스 계층임을 명시한다
@AllArgsConstructor //생성자 자동주입
@Log4j2 //로깅처리용

public class BoardServiceImpl implements BoardService{
	//조원이 실행문을 생성하는 용도로 활용 implements BoardService (구현클래스)

	private BoardMapper mapper; //db쿼리용 객체
	
	
	@Override
	public void register(BoardVO board) {
		// 객체가 넘어오면 매퍼를 이용해서 데이터베이스에 등록함
		
		log.info("BoardServiceImpl.register 메서드 실행......");
		
		mapper.insertSelectKey(board);
		log.info("정상등록 후 리스트 출력테스트....");
		mapper.getList();
		log.info("==============");
		
		
		
	}

	
	
	
	@Override
	public BoardVO get(Long bno) {
		// 게시물의 번호가 들어가면 매퍼의 select문이 동작해야 한다
		
		log.info("BoardServiceImpl.get메서드 실행....");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// 프론트에서 객체가 넘어오면 매퍼를 통해서 update 쿼리가 실행된다
		log.info("BoardServiceImpl.modify메서드 실행....");
		
		return mapper.update(board) ==1;
	}

	@Override
	public boolean remove(Long bno) {
		// 프론트에서 번호가 넘어오면 매퍼를 통해서 delete 쿼리가 실행된다
		
		log.info("BoardServiceImpl.remove메서드 실행");
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList() {
		// getList()메서드가 호출되면 매퍼에 getList2()를 호춣한다
		
		log.info("BoardServiceImpl.getList 메서드 실행..... ");

		return mapper.getList2();
	}

	
	
	
}
