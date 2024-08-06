package test240731.object1;

import java.util.Objects;

public class Vegetable extends Farm{
	private String name;

	public Vegetable() {
		super();
	}

	public Vegetable(String kind, String name) {
		super(kind);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.getKind() + ": " + this.name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name, super.getKind());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vegetable) {
			Vegetable v = ((Vegetable)obj);
			if(v.getName().equals(this.getName()) && v.getKind().equals(super.getKind())){
				return true;
			}
		}
		return false;
	}
}
