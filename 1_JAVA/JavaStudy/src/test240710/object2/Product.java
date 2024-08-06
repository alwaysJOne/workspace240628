package test240710.object2;

public class Product {
	private String pName;
	private int price;
	private String brand;
	
	public Product() {
		super();
	}
	
	
	
	public Product(String pName, int price, String brand) {
		super();
		this.pName = pName;
		this.price = price;
		this.brand = brand;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void information() {
		System.out.println("제품 : "  + this.pName);
		System.out.println("가격 : "  + this.price);
		System.out.println("브랜드 : "  + this.brand);
	}
}
