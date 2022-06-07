package kr.boksun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.boksun.mapper.MedicineMapper;
import kr.boksun.mapper.MedicineVO;
import kr.boksun.mapper.UserVO;

@Controller
public class MedicineController {

	@Inject
	private MedicineMapper mapper;
	
	// 보관함 정보 등록 요청
	@RequestMapping("/mediBoxUpdate.do")
	public String mediBoxInsert(MedicineVO vo, HttpServletResponse response) throws IOException {
		System.out.println("보관함 정보 등록 요청");
		System.out.println(vo.toString());
		mapper.mediBoxUpdate(vo);
		
		PrintWriter out = response.getWriter();
		out.print("mediBoxUpdate Success");

		return null;
	}
	
	// 보관함 조회 요청
	@RequestMapping("mediBoxSelect.do")
	public@ResponseBody List<MedicineVO> mediBoxSelect(String user_id) {
		System.out.println("보관함 조회 요청");
		System.out.println(user_id);
		
		List<MedicineVO> mlist = mapper.mediBoxSelect(user_id);
		for(int i = 0; i < mlist.size(); i++) {
			System.out.println(mlist.get(i).toString());
		}
		return mlist;
	}
	
	
}
