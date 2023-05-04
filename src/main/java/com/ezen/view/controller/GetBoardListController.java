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

		System.out.println("�Խñ� ��� ��ȸ ó��");

		BoardDAO boardDao = new BoardDAO();
		List<BoardVO> boardList = boardDao.getBoardList();
		
		ModelAndView modelAndView = new ModelAndView();
		// DB���� ��ȸ�� ������ ȭ�鿡 �����ϱ� ���� ���尴ü�� ����
		modelAndView.addObject("boardList", boardList);
		modelAndView.setViewName("getBoardList");
		
		return modelAndView;
	}
}
