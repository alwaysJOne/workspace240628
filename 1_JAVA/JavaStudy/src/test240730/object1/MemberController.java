package test240730.object1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class MemberController {
	HashMap map = new HashMap();
	
	public boolean joinMembership(String id, Member m) {
		if(map.get(id) == null) { // id를 key로 값을 가져왔을 때 값이 없다면
			map.put(id, m);
			return true;
		}
		return false;
	}
	
	public String login(String id, String password) {
		Member m = (Member)map.get(id);
		if(m != null) {
			if(m.getPassword().equals(password)) {
				return m.getName();
			}
		}
		
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		Member m = (Member)map.get(id);
		if(m != null && m.getPassword().equals(oldPw)) {
			m.setPassword(newPw);
			return true;
		}
		return false;
	}
	
	public void changeName(String id, String newName) {
		Member m = (Member)map.get(id);
		if(m != null) {
			m.setName(newName);
		}
	}
	
	public TreeMap sameName(String name) {
		TreeMap result = new TreeMap(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		//map.keySet() -> id가 모여있는 set자료구조
		for(Object id : map.keySet()) {
			Member m = (Member)map.get(id);
			if(m.getName().equals(name)) {
				result.put(id, m.getName());
			}
		}
		
		return result;
	}
}
