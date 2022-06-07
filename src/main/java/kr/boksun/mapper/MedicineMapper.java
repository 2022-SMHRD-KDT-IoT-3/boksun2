package kr.boksun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MedicineMapper {
	
	// 보관함 정보 등록
	public void mediBoxUpdate(MedicineVO vo);

	public List<MedicineVO> mediBoxSelect(String user_id);

}
