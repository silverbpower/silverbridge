package dto;

import java.util.HashMap;

public class MemberDTO {

	private String personId;
	private String personName;
	
	public MemberDTO(String personId, String personName) {
		super();
		this.personId = personId;
		this.personName = personName;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
}
