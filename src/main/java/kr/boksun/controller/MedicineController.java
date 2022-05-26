package kr.boksun.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.boksun.mapper.MedicineMapper;
import kr.boksun.mapper.MedicineVO;
import kr.boksun.mapper.UserVO;

@Controller
public class MedicineController {

	@Inject
	private MedicineMapper mapper;

	/*
	 * // 보관함 선택 페이지
	 * 
	 * @RequestMapping("/MediBoxList.do") public void MediBoxList() {
	 * System.out.println("보관함 선택 페이지"); }
	 */
	
	// 보관함 정보 등록 요청
	@RequestMapping("/mediBoxInsert.do")
	public String mediBoxInsert(MedicineVO vo) {
		System.out.println("보관함 정보 등록 요청");
		System.out.println(vo.toString());
		mapper.mediBoxInsert(vo);
		
		return "MediBox_insert_succeed";
	}
	
	
}
