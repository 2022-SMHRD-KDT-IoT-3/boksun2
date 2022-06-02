package kr.boksun.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
}
