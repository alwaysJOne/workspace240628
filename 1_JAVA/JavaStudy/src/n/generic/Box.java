package n.generic;

import java.util.Arrays;

public class Box<T>{
	private T[] obArr; //어떤 것들을 담을지 알 수 없음 => 객체
	private int size;
	
	public Box() {
		super();
	}
	
	public T[] getObArr() {
		return obArr;
	}
	public void setObArr(T[] obArr) {
		this.obArr = obArr;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Box [obArr=" + Arrays.toString(obArr) + ", size=" + size + "]";
	}
}
