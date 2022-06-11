package kr.boksun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.boksun.mapper.UserMapper;
import kr.boksun.mapper.UserVO;

@Controller
public class UserController {

	@Inject
	private UserMapper mapper;

	// 장애인 아이디 중복 체크
	@RequestMapping("/idCheckUser.do")
	public @ResponseBody UserVO idCheckUser(String user_id) {
		System.out.println("장애인 아이디 중복체크");
		UserVO vo = mapper.idCheckUser(user_id);
		return vo;
	}

	// 장애인 회원가입 요청
	@RequestMapping("/joinUserInsert.do")
	public @ResponseBody String joinUserInsert(UserVO vo, HttpServletResponse response) throws IOException {
		System.out.println("장애인 회원가입 요청");
		System.out.println(vo.toString());
		mapper.joinUserInsert(vo);

		PrintWriter out = response.getWriter();
		out.print("join_user_succeed");

		return null;
	}

	// 장애인 로그인 조회
	@RequestMapping("/loginUserSelect.do")
	public @ResponseBody UserVO loginUserSelect(UserVO vo) {
		System.out.println("장애인 로그인 조회");
		UserVO info = mapper.loginUserSelect(vo);
		return info;
	}

	// 장애인 전체 목록
	@RequestMapping("/userList.do")
	public @ResponseBody List<UserVO> userList(String worker_id) {
		System.out.println("장애인 목록 비동기 통신!");
		List<UserVO> list = mapper.userList(worker_id);

		System.out.println(worker_id);
		/*
		 * for (int i = 0; i < list.size(); i++) {
		 * System.out.println(list.get(i).toString()); }
		 */
		return list;
	}

	// 장애인 선택 조회
	@RequestMapping("/userChoice.do")
	public @ResponseBody UserVO userChoice(String user_id) {
		System.out.println("장애인 선택 조회");
		UserVO info = mapper.userChoice(user_id);
		return info;
	}
	
	// 장애인 정보 수정
	@RequestMapping("/updateUser.do")
	public @ResponseBody String updateUser(UserVO vo, HttpServletResponse response) throws IOException {
		System.out.println("장애인 정보 수정");
		System.out.println(vo.toString());
		mapper.updateUser(vo);
		
		PrintWriter out = response.getWriter();
		out.print("update_user_succeed");

		return null;
	}
	
	
	// 약보관함 최근 접촉시간
    @ResponseBody
    @RequestMapping("/mkbox2.do")
    public void init(@RequestBody HashMap<String, Object> map) {
		System.out.println(map.get("USER_ID"));
		System.out.println(map.get("USER_ACCESS"));
        
	    String user_id = (String)map.get("USER_ID");
	    String user_access = (String)map.get("USER_ACCESS");
	    System.out.println(user_id + " / " +user_access);
	    
	    UserVO info = new UserVO(user_id, user_access);
	    System.out.println(info.toString());
	    
	    mapper.userAccessUpdate(info);
   }
    
    
    // 긴급버튼 : 푸시 알림(파이어베이스)
    @ResponseBody
    @RequestMapping(value = "/warning.do", produces = "application/text; charset=UTF-8")
    public String warning(@RequestBody HashMap<String, Object> map) {

//	          System.out.println(map.get("USER_ID"));
//	          System.out.println(map.get("MED_BOX"));
//	          System.out.println(map.get("MED_ALARM"));

    	String user_id = (String) map.get("USER_ID");
	
    	UserVO war = new UserVO(user_id);
	
    	UserVO result = mapper.mediWarning(war);
	  
    	String name = result.getUser_name();
    	System.out.println(name);

      return name;

   }
}
