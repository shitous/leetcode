我有一个感兴趣的城市列表，我的朋友们每个人也有感兴趣的城市列表，如果朋友和我感兴趣的城市占总共他总城市个数的至少一半，就输出他的名字。要求按照相同城市个数排序。
    
public class solution {
    public class Friends implements Comparable <Friends> {
	String name;
	ArrayList<String> list;
	int num; // number of same cities
	Friends (String name, ArrayList<String> list, int num) {
	    this.name = name;
	    this.list = list;
	    this.num = num;
	}
	@Override
	public int compareTo (Friends o) {
	    return Integer.compare(this.num, o.num);
	}
    }
	
    public ArrayList<String> nameofFriends(ArrayList<Friends> friends, ArrayList<String> mine) {
	ArrayList<String> res = new ArrayList<>();
	TreeSet<Friends> set = new TreeSet<>();
	for (int i = 0; i < friends.size(); i++) {
	    ArrayList<String> list = friends.get(i).list;
	    int size = list.size();
	    list.retainAll(mine);
	    if (list.size() >= size/2) {
		friends.get(i).num = list.size();
		set.add(friends.get(i));
	    }
	}
	while (!set.isEmpty()) {
	    res.add(set.last().name);
	    set.remove(set.last());
	}
	return res;
    }
}
