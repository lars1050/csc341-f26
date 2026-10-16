public class Main {
	public static void main(String[] args) {
	
		BasicList blist = new BasicList();
		
		Basic a1 = new Basic("a",1);
		Basic b2 = new Basic("b",2);
		Basic c3 = new Basic("c",3);
		Basic d4 = new Basic("d",4);
		Basic e5 = new Basic("e",5);
		Basic f6 = new Basic("f",6);
		Basic z = new Basic("z",0);
		
		blist.add(a1);
		blist.add(b2);
		blist.add(c3);
		blist.add(d4);
		blist.add(e5);
		
		System.out.println(blist);
		
		blist = new BasicList();
		try {
			blist.add(b2);
			blist.add(a1,0);
			blist.add(d4);
			blist.add(f6);
			blist.add(e5,3);
			blist.add(c3,2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(blist);
	}
}