package test240718.object2;

public abstract class SmartPhone implements CellPhone, TouchDisplay{
	private String maker;

	public SmartPhone() {
		super();
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public abstract String printInformation();
		
}
