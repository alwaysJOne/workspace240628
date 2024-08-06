package test240726.object2;

import java.util.Comparator;

public class AscTitle implements Comparator<Music>{

	@Override
	public int compare(Music o1, Music o2) {
		//compareTo -> 나자신과 비교해서 크면 1 작으면 -1 동일하면 0
		// o1.getTitle().compareTo(o2.getTitle()) -> 제목이 같으면 0
		
		if (o1.getTitle().compareTo(o2.getTitle()) == 0) {
			return o1.getSinger().compareTo(o2.getSinger());
		}
		return o1.getTitle().compareTo(o2.getTitle());
	}
	
}
