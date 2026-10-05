public class Alpha {
	Character alpha;
	Integer ascii;
	
	public Alpha(Character c, Integer a) {
		alpha = c;
		ascii = a;
	}
	
	@Override
	public String toString() {
		return alpha + ":" + ascii.toString();
	}
	
	public Character alpha() { return alpha; }
	public Integer ascii() { return ascii; }
}