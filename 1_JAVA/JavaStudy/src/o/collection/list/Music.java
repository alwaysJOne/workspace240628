package o.collection.list;

import java.util.Objects;

public class Music {
	private String title;
	private String artist;
	public Music() {
		super();
	}
	public Music(String title, String artist) {
		super();
		this.title = title;
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "Music [title=" + title + ", artist=" + artist + "]";
	}
	
	@Override
	public int hashCode() {
	
		return Objects.hash(artist, title);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Music) { // 외부에서 넘겨받은 데이터가 나와 동일한 객체인지 확인
			Music m = (Music)obj; // 동일하다면 다운캐스팅
			//비교하고싶은 필드를 직접비교
			if(this.artist.equals(m.getArtist()) &&
					this.title.equals(m.getTitle())) {
				return true;
			}
		}
		return false;
	}
	
	
}
