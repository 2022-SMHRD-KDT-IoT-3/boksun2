package kr.boksun.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkerVO {
	
	private String worker_id;
	private String worker_pw;
	private String worker_name;
	private String worker_license;
	private String worker_organization;
	private String worker_tel;
	private String worker_phone;
	private String worker_area;
	private String woker_joindate;

}