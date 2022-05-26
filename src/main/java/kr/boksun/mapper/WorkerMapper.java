package kr.boksun.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkerMapper {
	
	public WorkerVO idCheckWorker(String worker_id);  // 복지사 아이디 중복 체크

	public void joinWorkerInsert(WorkerVO vo);  // 복지사 회원가입
	
	public WorkerVO loginWorkerSelect(WorkerVO vo);  // 복지사 로그인
	

}
