package kr.boksun.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MedicineVO {
	
	private int med_seq;
	private String user_id;
	private String med_box;
	private String med_name;
	private String med_hosp;
	private String med_way;
	private String med_times;
	private String med_date;
	private String med_alarm;
	private String med_update;
	private String med_memo;
	
	public MedicineVO(String user_id, String med_box) {
	      super();
	      this.user_id = user_id;
	      this.med_box = med_box;
	}

	public MedicineVO(String user_id, String med_box, String med_alarm) {
	      super();
	      this.user_id = user_id;
	      this.med_box = med_box;
	      this.med_alarm = med_alarm;
	 }

	 public MedicineVO(String user_id) {
	      super();
	      this.user_id = user_id;
	 }

}
