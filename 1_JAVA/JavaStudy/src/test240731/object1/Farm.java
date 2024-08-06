package test240731.object1;

import java.util.Objects;

public class Farm {
	private String kind;

	public Farm() {
		super();
	}

	public Farm(String kind) {
		super();
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "Farm [kind=" + kind + "]";
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(this.getKind());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Farm) {
			Farm f = ((Farm)obj);
			if(f.getKind().equals(this.getKind())){
				return true;
			}
		}
		return false;
	}
	
}
