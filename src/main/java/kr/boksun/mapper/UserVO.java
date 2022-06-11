package kr.boksun.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVO {
	
	private String user_id;
	private String user_name;
	private String user_birthdate;
	private String user_gender;
	private String user_joindate;
	private String user_addr;
	private String user_phone;
	private String worker_id;
	private String user_empn;
	private String user_access;
	private String user_disease;
	
    public UserVO(String user_id, String user_access) {
    	super();
    	this.user_id = user_id;
    	this.user_access = user_access;
	}

	public UserVO(String user_id) {
	    super();
	    this.user_id = user_id;
	}

}
