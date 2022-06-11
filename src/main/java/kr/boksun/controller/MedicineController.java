package kr.boksun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.boksun.mapper.MedicineMapper;
import kr.boksun.mapper.MedicineVO;
import kr.boksun.mapper.UserVO;

@Controller
public class MedicineController {

	@Inject
	private MedicineMapper mapper;
	
	// 보관함 업데이트 요청 (장애인)
	@RequestMapping("/mediBoxUpdate.do")
	public String mediBoxUpdate(MedicineVO vo, HttpServletResponse response) throws IOException {
		System.out.println("보관함 업데이트 요청 - 장애인");
		System.out.println(vo.toString());
		mapper.mediBoxUpdate(vo);
		
		PrintWriter out = response.getWriter();
		out.print("User mediBoxUpdate Success");

		return null;
	}
	
	// 보관함 업데이트 요청 (복지사)
	@RequestMapping("/mediBoxUpdateW.do")
	public String mediBoxUpdateW(MedicineVO vo, HttpServletResponse response) throws IOException {
		System.out.println("보관함 업데이트 요청 - 복지사");
		System.out.println(vo.toString());
		mapper.mediBoxUpdateW(vo);
		
		PrintWriter out = response.getWriter();
		out.print("Worker mediBoxUpdate Success");

		return null;
	}
	
	
	// 보관함 사용 조회 요청
	@RequestMapping("mediBoxSelect.do")
	public@ResponseBody List<MedicineVO> mediBoxSelect(String user_id) {
		System.out.println("보관함 사용 조회 요청");
		System.out.println(user_id);
		
		List<MedicineVO> mlist = mapper.mediBoxSelect(user_id);
		for(int i = 0; i < mlist.size(); i++) {
			System.out.println(mlist.get(i).toString());
		}
		return mlist;
	}
	
	
	// 보관함 정보 조회 요청
	@RequestMapping("mediBoxInfoSelect.do")
	public @ResponseBody MedicineVO mediBoxInfoSelect(MedicineVO mvo) {
		System.out.println("보관함 정보 조회 요청");
		System.out.println(mvo.toString());
		
		MedicineVO mInfo = mapper.mediBoxInfoSelect(mvo);
		return mInfo;
	}
	
	
	
   // 라즈베리 json
   // 보관함 음성 출력
   @ResponseBody
   @RequestMapping(value = "/mkbox.do", produces = "application/text; charset=UTF-8")
   public String init(@RequestBody HashMap<String, Object> map) {

      System.out.println(map);
      System.out.println(map.get("USER_ID"));
      System.out.println(map.get("MED_BOX"));

      String user_id = (String) map.get("USER_ID");
      String med_box = (String) map.get("MED_BOX");

      MedicineVO mvo2 = new MedicineVO(user_id, med_box);

      MedicineVO result = mapper.mediBoxInfoSelect(mvo2);

      String name = result.getMed_name();
      String way = result.getMed_way();

      return med_box.substring(3) + "번 보관함 입니다," + name + "," + way + "후, 드세요.";

   }
   
   
   // 보관함 알람 출력
   @ResponseBody
    @RequestMapping(value="/alarm.do", produces="application/text; charset=UTF-8")
    public String times(@RequestBody HashMap<String, Object> map) {
       
//	        System.out.println(map.get("USER_ID"));
//	        System.out.println(map.get("MED_BOX"));
//	        System.out.println(map.get("MED_ALARM"));
        
        String user_id = (String)map.get("USER_ID");
        String med_box = (String)map.get("MED_BOX");
        String med_alarm = (String)map.get("MED_ALARM");
        
        System.out.println("raspberry : " + med_alarm);
        
        MedicineVO avo = new MedicineVO(user_id, med_box);
        
        
        MedicineVO result = mapper.mediAlarmSelect(avo);
        System.out.println("result : " + result);
        
        String alarm = result.getMed_alarm();
        System.out.println(alarm);
        
       
        if(alarm != "#") {
           if(med_alarm.equals(alarm)) {
              System.out.print("시간이 일치합니다.");
              return "현재 시간," + med_alarm.substring(0, 2) + "시," + med_alarm.substring(3,5) + "분," + med_box.substring(3) + "번, 보관함 약을, 복용하세요.";
              // return "현재 시간," + alarm.substring(0, 2) + "시," + alarm.substring(3,5) + "분," + med_box.substring(3) + "번, 보관함 약을, 복용하세요.";
           } else {
              System.out.println("시간이 일치하지 않습니다.");
              return "0";
           }
           
        } else {
           return "0";
        }
   }

	
}
