package test240709.object1;

public class Member {
	//필드
	private String memberId;
	private String memberPwd;
	private String memberName;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	//기본생성자
	public Member() {}
	
	//아이디, 비밀번호, 이름을 넘겨받아 초기화하는 생성자
	public Member(String id, String pwd, String name) {
		this.memberId = id;
		this.memberPwd = pwd;
		this.memberName = name;
	}
	//메소드
	
	//memberName의 필드값을 넘겨받은 name값으로 변경
	public void changeName(String name) {
		this.memberName = name;
	}
	//memberName의 값을 출력하는 메소드
	public void printName() {
		System.out.println(this.memberName);
	}
}
