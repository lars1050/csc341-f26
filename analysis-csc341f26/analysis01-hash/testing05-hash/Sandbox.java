import java.util.LinkedList;
import java.util.Iterator;

class Sandbox {
	public static void main(String[] args) {

		String amy = "amy";
		System.out.println(Integer.valueOf(amy.charAt(0)));

		@SuppressWarnings("unchecked")
		LinkedList<MyPair>[] mylist = (LinkedList<MyPair>[]) new LinkedList[5];

		for (int i=0; i<mylist.length; i++) {
			mylist[i] = new LinkedList<MyPair>();
		}
		MyPair p1 = new MyPair("1","A");
		MyPair p2 = new MyPair("2","B");
		MyPair p3 = new MyPair("3","C");

		mylist[0].add(p1);
		mylist[0].add(p2);
		mylist[0].add(p3);

		MyPair mp = find("2",mylist[0]);
		System.out.printf("%s %s\n",mp.key,mp.value);
		mp.value = "blah";

		System.out.println("\n did it change ????");
		for (MyPair mkv : mylist[0]) {
			System.out.printf("%s %s\n",mkv.key,mkv.value);
		}
	}

	public static class MyPair {
		String key;
		String value;
		MyPair(String k, String v) {
			key = k;
			value = v;
		}
	}

	public static MyPair find(String key, LinkedList<MyPair> llist) {
		Iterator<MyPair> it = llist.iterator();
		while (it.hasNext()) {
			MyPair mp = it.next();
			System.out.printf("%s %s\n",mp.key,mp.value);
			if (mp.key.equals(key)) {
				return mp;
			}
		}
		return null;
	}
}
