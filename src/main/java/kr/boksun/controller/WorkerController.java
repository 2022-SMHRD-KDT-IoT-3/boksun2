package kr.boksun.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.boksun.mapper.UserVO;
import kr.boksun.mapper.WorkerMapper;
import kr.boksun.mapper.WorkerVO;

@Controller
public class WorkerController {

	@Inject
	private WorkerMapper mapper;

	/*
	 * // 복지사 회원가입 페이지
	 * 
	 * @RequestMapping("/joinWorker.do") public void joinWorker() {
	 * System.out.println("복지사 회원가입 페이지"); }
	 */

	// 복지사 아이디 중복 체크
	@RequestMapping("/idCheckWorker.do")
	public @ResponseBody WorkerVO idCheckWorker(String worker_id) {
		System.out.println("복지사 아이디 중복체크");
		System.out.println(worker_id);

		WorkerVO vo = mapper.idCheckWorker(worker_id);

		return vo;
	}

	// 복지사 회원가입 요청
	@RequestMapping("/joinWorkerInsert.do")
	public String joinWorkerInsert(WorkerVO vo, HttpServletResponse response) throws IOException {
		System.out.println("복지사 회원가입 요청");
		System.out.println(vo.toString());
		mapper.joinWorkerInsert(vo);

		PrintWriter out = response.getWriter();
		out.print("join_worker_succeed");

		return null;
	}

	// 복지사 로그인 조회
	@RequestMapping("/loginWorkerSelect.do")
	public @ResponseBody WorkerVO loginWorkerSelect(WorkerVO vo) {
		System.out.println("복지사 로그인 조회");
		WorkerVO info = mapper.loginWorkerSelect(vo);
		return info;
	}
	
	

}
