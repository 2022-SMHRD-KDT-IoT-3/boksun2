package kr.boksun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MedicineMapper {
	
	// 보관함 정보 업데이트(장애인)
	public void mediBoxUpdate(MedicineVO vo);
	
	// 보관함 정보 등록 요청 (복지사)
	public void mediBoxUpdateW(MedicineVO vo);
	
	// 보관함 사용 정보 조회
	public List<MedicineVO> mediBoxSelect(String user_id);

	// 보관함 정보 조회
	public MedicineVO mediBoxInfoSelect(MedicineVO mvo);

}
