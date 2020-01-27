package dto;

import java.io.Serializable;

public class LoginDTO  implements Serializable{
	private static final long serialVersionUID = -3923270801788163438L;
	private String id;
	private String name;
	private boolean result;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
}
