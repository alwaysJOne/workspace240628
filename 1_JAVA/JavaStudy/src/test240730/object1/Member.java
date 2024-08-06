package test240730.object1;

public class Member {
	private String name;
	private String password;

	public Member() {
		super();
	}

	public Member(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", password=" + password + "]";
	}
}
