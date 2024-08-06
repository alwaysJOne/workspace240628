package test240719.object1;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] animalArr = new Animal[5];
		
		animalArr[0] = new Dog("횐둥이", "시고르자브종", 20);
		animalArr[1] = new Cat("럭키", "먼치킨","우리집", "횐색");
		animalArr[2] = new Dog("멍구", "풍산개", 20);
		animalArr[3] = new Dog("개똥이", "진돗개", 20);
		animalArr[4] = new Cat("휴지", "스코티쉬폴드","옆집", "회색");
	
		for(Animal ani : animalArr) {
			ani.speak();
		}

	}

}
