package kr.boksun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface BoardMapper {
	//xml 쿼리문 id와 메서드명이 동일해야한다.
	//Mapper의 역할 Controller(POJO)와 xml을 연결해주는 중간다리 역할
	
	/*@Select("select * from board order by indate desc")*/
	//@Select 어노테이션을 사용하면 mapper.xml에 안하고도 가능.
	// boardList()메서드가 위에 쿼리를 사용한다는 것
	// 그러나 이것은 똑같이 sql을 자바에 결합해서 사용하기때문에 의미가 없음. 사용x
	// 결합도가 높아짐. 유지보수 시 어려움. 
	public List<BoardVO> boardList();   
	
	public void boardInsert(BoardVO vo);

	public BoardVO boardContents(int idx);

	public void boardUpdate(BoardVO vo);
	
	public void boardDelete(int idx);
	 
	public void count(int idx);
}
