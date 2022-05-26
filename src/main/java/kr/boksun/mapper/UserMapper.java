package kr.boksun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	
	public UserVO idCheckUser(String id);  // 장애인 아이디 중복 체크

	public void joinUserInsert(UserVO vo);  // 장애인 회원가입
	
	public UserVO loginUserSelect(UserVO vo);  // 장애인 로그인
	
	public List<UserVO> userList();  // 장애인 전체 목록
}
