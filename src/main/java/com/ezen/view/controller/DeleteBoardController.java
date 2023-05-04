package com.ezen.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("게시글 삭제 처리");
		String seq = request.getParameter("seq");

		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDao = new BoardDAO();
		boardDao.deleteBoard(vo);
		
		List<BoardVO> boardList = boardDao.getBoardList();
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("boardList", boardList);
		modelAndView.setViewName("redirect:getBoardList.do");
		return modelAndView;

	}

}
