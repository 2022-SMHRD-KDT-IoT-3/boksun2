package kr.boksun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	
	public UserVO idCheckUser(String user_id);  // 장애인 아이디 중복 체크

	public void joinUserInsert(UserVO vo);  // 장애인 회원가입
	
	public UserVO loginUserSelect(UserVO vo);  // 장애인 로그인
	
	public List<UserVO> userList(String worker_id);  // 장애인 전체 목록
	
	public UserVO userChoice(String user_id);  // 장애인 선택 조회

	public void serialJoin(UserVO vo);  // 시리얼 번호 회원가입

}
