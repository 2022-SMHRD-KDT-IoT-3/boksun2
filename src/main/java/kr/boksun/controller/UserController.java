package kr.boksun.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.boksun.mapper.UserMapper;
import kr.boksun.mapper.UserVO;

@Controller
public class UserController {

	@Inject
	private UserMapper mapper;
	
	/*
	 * // 회원가입 선택(장애인, 복지사) 페이지
	 * 
	 * @RequestMapping("/join.do") public void join() {
	 * System.out.println("회원가입 페이지 이동"); }
	 * 
	 * // 장애인 회원가입 페이지
	 * 
	 * @RequestMapping("/joinUser.do") public void joinUser() {
	 * System.out.println("장애인 회원가입 페이지"); }
	 */
	
	// 장애인 아이디 중복 체크
	@RequestMapping("/idCheckUser.do")
	public @ResponseBody UserVO idCheckUser(String id) {
		System.out.println("장애인 아이디 중복체크");
		UserVO vo = mapper.idCheckUser(id);
		return vo;
	}

	// 장애인 회원가입 요청
	@RequestMapping("/joinUserInsert.do")
	public String joinUserInsert(UserVO vo) {
		System.out.println("장애인 회원가입 요청");
		System.out.println(vo.toString());
		mapper.joinUserInsert(vo);
		
		return "User_insert_succeed";
	}
	
	/*
	 * // 로그인 페이지
	 * 
	 * @RequestMapping("/login.do") public void login() {
	 * System.out.println("로그인 페이지 이동"); }
	 */
	
	// 장애인 로그인 조회
	@RequestMapping("/loginUserSelect.do")
	public @ResponseBody UserVO loginUserSelect(UserVO vo) {
		System.out.println("장애인 로그인 조회");
		UserVO info = mapper.loginUserSelect(vo);
		return info;
	}
	
	// 장애인 전체 목록
	@RequestMapping("/userList.do")
	public @ResponseBody List<UserVO> userList() {
		System.out.println("장애인 목록 비동기 통신!");
		List<UserVO> list = mapper.userList();
		
		return list;
	}
}
