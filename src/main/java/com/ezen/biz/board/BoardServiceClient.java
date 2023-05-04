package com.ezen.biz.board;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.service.BoardService;

public class BoardServiceClient {

	private static BoardService boardService;

	public static void main(String[] args) {
		// ������ �����̳� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// boardService ��ü ���� ��û
		// �Ʒ��� ������ @Autowired�� ��� ó��
		boardService = (BoardService) container.getBean("boardService");

		// �Խñ� ���
		BoardVO board = new BoardVO();
		board.setSeq(9999);
		board.setTitle("�Խñ� ����");
		board.setWriter("�庸��");
		board.setContent("������ ���� �Խñ��Դϴ�.");

		// �Խñ� �Է� �׽�Ʈ
		 boardService.insertBoard(board);

		// �Խñ� ��� ��ȸ
		List<BoardVO> boardList = boardService.getBoardList();

		System.out.println("<<< �Խñ� ��� >>>");
		for (BoardVO vo : boardList) {

			System.out.println(vo);

		}

		BoardVO vo1 = new BoardVO();
		vo1.setSeq(3);
		System.out.println("<<< �Խñ� ����ȸ >>>");
		System.out.println(boardService.getBoard(vo1));

		container.close();

	}

}
