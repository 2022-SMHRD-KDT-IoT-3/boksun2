package kr.boksun.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
/*
 * vo = dto
롬복 lombok : getter setter 생성자등을 자동으로 만들어주는 라이브러리

C:\eGovFrame-3.10.0\bin\jdk8u242-b08\bin 롬복jdk를 이 경로로 옮겨준다

cmd 
cd C:\eGovFrame-3.10.0\bin\jdk8u242-b08\bin
java -jar lombok.jar
설치 후 종료 재실행
 */
@Data
@AllArgsConstructor // 전체 데이터를 아규먼트로 갖는 생성자 생성
@NoArgsConstructor  //기본생성자 생성
@ToString
public class BoardVO {
	private int idx;		 // 번호
	@NonNull
	private String title;	 // 제목
	@NonNull
	private String contents; // 내용
	private int count;		 // 조회수
	@NonNull
	private String writer; 	 // 작성자
	private String indate;	 // 작성일
	
	
}
