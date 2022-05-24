package kr.boksun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.boksun.mapper.BoardMapper;
import kr.boksun.mapper.BoardVO;
//0.서블릿이 아닌 java파일
//1.스프링에선 Controller를 POJO라고 부른다.
//2.어노테이션을 달아서 프론트컨트롤러라고 알려준다.
@Controller
public class BoardController {
	
	//@Autowired (알아서 객체 연결) 최근에는 @Inject를 사용( 기능은 같으나 성능이 더 업그레이드됌)
	//결합도 낮추는 방법 dependency injection(의존성주입) 애너테이션 
	@Autowired   
	private BoardMapper mapper;
	
	// web/boardList.do라고 요청했을때 실행되는 메소드
	@RequestMapping("/boardList.do")
	public void boardList(Model model) {
		System.out.println("[launch boardList]");
		
		List<BoardVO> list = mapper.boardList();
		System.out.println(list);
		
		// 번호, 제목, 내용, 조회수, 작성자, 작성자, 작성일
		//foward방식으로 전송방식을 해야되고 redirect로하면 값을 꺼낼수 없다 
		//그 이유는 새로고침되버리므로 request객체가 새로 된다                                                             
		model.addAttribute("list", list);
		//return "boardList"; 
		// 메소드이름과 똑같은 스트링을 리턴해준다면 지워도 된다.
		// 스프링 기능으로 자동으로 반환해준다. 그래서 메소드 타입도
		// void타입으로 변경해도 된다.
	}
	
	// web/boardInsertForm.do라고 요청했을때 실행되는 메소드
	@RequestMapping("/boardinsertForm.do")
	public void boardInsertForm() {
		System.out.println("[boardinsertForm.do]");
		//return "boardinsertForm"; 
		// 메소드이름과 똑같은 스트링을 리턴해준다면 지워도 된다.
		// 스프링 기능으로 자동으로 반환해준다. 그래서 메소드 타입도
		// void타입으로 변경해도 된다.
	}
	
	// web/boardInsert.do 라고 요청했을때 실행되는 메소드
	@RequestMapping("/boardInsert.do")
	public String boardInsert(BoardVO vo) {
		System.out.println("[글쓰기 기능 실행]");
		System.out.println(vo.toString());
		
		mapper.boardInsert(vo);
		
		//리다이렉트 하는 법 (인설트하고 다시 셀렉트를 해야 메인리스트에서 정보가 보임)
		return "redirect:/boardList.do";
		// 얘는 메소드 이름과 return해주는 위치가 달라서 지우면 안됀다. 
		// 따라서, 메서드 타입을 void로 변경할 수 없다.
	}
	
	// web/boardContents.do 라고 요청했을때 실행되는 메소드
	@RequestMapping("/boardContents.do")
	public String boardContents(int idx, Model model) {
		System.out.println("[글보기 기능 실행]");
		BoardVO vo = mapper.boardContents(idx);
		mapper.count(idx);
		model.addAttribute("vo",vo);
		return "boardContents";
	}
	//게시글고유번호 제목 내용
	@RequestMapping("/boardUpdate.do")
	public String boardUpdate(BoardVO vo) {
		System.out.println("[글수정 기능 실행]");
		mapper.boardUpdate(vo);
		System.out.println(vo);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping("/boardDelete.do")
	public String boardDelete(int idx) {
		System.out.println("[글수정 기능 실행]");
		System.out.println("sdsd");
		mapper.boardDelete(idx);
		System.out.println(idx);
		return "redirect:/boardList.do";
	}
}