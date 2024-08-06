package test240717.object2;

public class LibraryController {
	private Member mem = null;
	private Book[] bList = new Book[5];
	
	
	public LibraryController() {
		super();
		
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}

	public void insertMember(Member mem) {
		this.mem = mem;
	}
	
	public Member myInfo() {
		return this.mem;
	}
	
	public Book[] selectAll() {
		return this.bList;
	}
	
	//제목에 keyword가 포함된 모든 책 검사
	public Book[] searchBook(String keyword) {
		Book[] tmpBookList = new Book[5];
		
		int index = 0;
		
		for(int i=0; i<bList.length; i++) {
		
			if (bList[i] == null) {
				break;
			}
			
			String title = bList[i].getTitle();
			if(title.indexOf(keyword) != -1) {
				tmpBookList[index] = bList[i];
				index++;
			}
		}
		
		return tmpBookList;
	}
	
	public int rentBook(int index) {
		int result = 0;
		Book b = bList[index];
		
		if (b instanceof AniBook) {
			int accessAge = ((AniBook) b).getAccessAge();
			int memberAge = this.mem.getAge();
			if(accessAge > memberAge) {
				result = 1;
			}

		} else if(b instanceof CookBook) {
			if(((CookBook)b).isCoupon()) {
				this.mem.setCouponCount(this.mem.getCouponCount() + 1);
				result = 2;
			}
		}
		
		return result;
	}
}
