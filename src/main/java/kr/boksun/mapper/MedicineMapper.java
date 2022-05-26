package kr.boksun.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MedicineMapper {
	
	// 보관함 정보 등록
	public void mediBoxInsert(MedicineVO vo);

}
