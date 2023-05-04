package com.ezen.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("게시글 목록 조회 처리");

		BoardDAO boardDao = new BoardDAO();
		List<BoardVO> boardList = boardDao.getBoardList();
		
		ModelAndView modelAndView = new ModelAndView();
		// DB에서 조회한 내용을 화면에 전달하기 위해 내장객체에 저장
		modelAndView.addObject("boardList", boardList);
		modelAndView.setViewName("getBoardList");
		
		return modelAndView;
	}
}
