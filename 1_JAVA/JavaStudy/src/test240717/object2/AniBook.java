package test240717.object2;

public class AniBook extends Book{
	private int accessAge;

	public AniBook() {
		super();
	}

	public AniBook(String title, String author, String publisher, int accessAge) {
		super(title, author, publisher);
		this.accessAge = accessAge;
	}

	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}

	@Override
	public String toString() {
		return "[" + super.toString() + "], accessAge="+ accessAge + "]";
	}
}
