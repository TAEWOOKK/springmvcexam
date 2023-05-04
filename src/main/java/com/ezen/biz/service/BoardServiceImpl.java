package com.ezen.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.common.Log4jAdvice;
import com.ezen.biz.common.LogAdvice;
import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired//따로 객체 생성 x
	private BoardDAO boardDAO;
	//private LogAdvice log;
	//private Log4jAdvice log;
	
	public BoardServiceImpl() {
		//log = new LogAdvice();
		// 로깅 클래스의 변경에 따른 수정
		//log = new Log4jAdvice();
	}
	
	
	@Override
	public void insertBoard(BoardVO vo) {
		
		//log.printLog();
		//log.printLogging();
		
		//after-throwing 테스트를 위해 강제로 에외 발생 
//		if (vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		
//		}
		// 트랜잭션 관리 테스트 : 동일한 스퀀스 번호를 등록
		boardDAO.insertBoard(vo);
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		//log.printLog();
		//log.printLogging();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		//log.printLog();
		//log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		
		
		
		return boardDAO.getBoard(vo);
		
		
	}

	@Override
	public List<BoardVO> getBoardList() {
		//log.printLog();
		//log.printLogging();
		return boardDAO.getBoardList();
		
		
	}

}
