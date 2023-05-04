package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("�α��� ó��");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);

		UserDAO userDao = new UserDAO();
		UserVO user = userDao.getUser(vo);
		
		
		//ȭ�� ���� ó��
		ModelAndView modelAndView = new ModelAndView();
		
		
		if (user != null) {
			modelAndView.setViewName("redirect:getBoardList.do");
		} else {
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

}
