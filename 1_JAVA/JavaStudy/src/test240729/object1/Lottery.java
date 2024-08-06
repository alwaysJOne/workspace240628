package test240729.object1;

public class Lottery {
	private String name;
	private String phone;
	public Lottery() {
		super();
	}
	public Lottery(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Lottery [name=" + name + ", phone=" + phone + "]";
	}
	@Override
	public int hashCode() {
		String str = this.name + this.phone;
		return str.hashCode();
	}
	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Lottery) {
			Lottery lo = (Lottery)obj;
			if(this.name.equals(lo.getName()) &&
					this.phone.equals(lo.getPhone())) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
}
