import java.util.Random;
import java.util.ArrayList;

/** Maker of Auggie objects for testing purposed. */
public class AuggieFactory {

	// combined with "user" to make unique username
	private static int nextUser = 1000;
	
	private static Random rand = new Random();
	
	/** 
	* Create a single Auggie with random name and role
	* @param uname username of Auggie
	* @return newly constructed Auggie object
	*/
	public static Auggie makeAuggie(String uname) {
        
        // manufacture the object with random values
        return new Auggie(uname,randomFirst(),randomLast(),randomRole());
	}
	
	/**
	* Create collection of Auggies with unique usernames, random name and role.
	* @param size number of Auggies in collection
	* @return collection of newly manufactured Auggies
	*/
	public static ArrayList<Auggie> makeAuggies(int size) {
	
		// Data structure for storing any number of Auggies
		ArrayList<Auggie> auggies = new ArrayList<>();

		// Create "size" auggies		
		for (int i=0; i<size; i++) {
		
			// Create unique username and increment for next user
    	    String username = "user"+nextUser;
        	nextUser++;
        	
        	auggies.add(new Auggie(username,randomFirst(),randomLast(),randomRole()));
        }
        return auggies;
	}
	
	private static String randomFirst() {
		return firsts[rand.nextInt(firsts.length)];
	}
	private static String randomLast() {
		return lasts[rand.nextInt(lasts.length)];
	}
	private static Role randomRole() {
		return Role.values()[rand.nextInt(Role.values().length)];
	}

	// The following is used to randomly create students for testing purposes.
    private static String[] firsts = { 
        "Amy", "Erik", "Pavel", "Matt", "Abdi", "Zakaria", "Miguel", "Jocelyn", "Adnan", "Luis", "Emily", "Drew", "Everett", "Ayden", "Walta", "Joshua", "Keiran", "Elias", "Faiaz", "Sergio", "Ivan", "Max", "Mohamed", "Ahmed", "May", "Johnny", "Pao", "Jaron", "Liban", "Taha", "Tenley", "Josh", "Xeng", "Gabriel", "Asli", "Hodan", "Jamila", "Amaal", "Ari", "Quinn", "Mohamud", "Derek", "Dori", "Guleid", "Yuva", "Rudwan", "Aisha", "Hamsa", "Ethan", "Talib", "Kwadwo", "Melissa", "Jake", "Chris", "Skyler", "Zach", "Liban", "Taylor", "Liam", "Corey", "Kebba", "Hannah", "Eric", "Jeffrey", "Esmeralda", "Leah", "Halah", "Krystal", "Rahma", "Romeo", "Ivie", "Andy", "Karen", "JeanJacques", "Elisha", "Khadro", "Adna", "Sundus", "Mohamed", "Timothy", "Vinny", "Mayali", "Betelehem", "Ermais", "Matt", "Collin", "Adnan", "Tommy", "Moua", "Long", "Miriam", "Keenan", "Sumayyah", "Nathan", "Matthew", "Angel", "Vivika", "Thor", "Brandon", "Andy", "Erica", "Bailey", "Ariana", "Linus", "Elliott", "Vincent", "Josh", "Sean", "Katelynn", "Saryn", "Bjorn", "Doua", "Amina", "Muna", "Xera", "Khaalid", "Mitchell", "Zach", "Leban", "Chris", "Khalid", "Ryan", "Alinase", "Brian", "Anna", "Zak", "Nikita", "Luke", "Ridwan", "Najma", "Brooklyn", "Ella", "Sarah", "Mackenzie", "Stephanie", "Myles", "Christopher", "Kevin", "Jason", "DivineGift", "Odin", "Katie", "Jacob", "Lucy", "Vincent", "Najma", "Ly", "Ahmed", "Jack", "Ilyaas", "Sabine", "Gwynn", "Ivan", "Grant", "Luis", "Taj", "Gent", "Iymen", "Mubarek", "Jean Jacques", "Emanuel", "Abigail", "Danayt", "Bailey", "Alexander", "Abdullahi","Ati","Bobby","Henry","Will", "Abshir","Javier", "Winnie", "Makena", "Samson", "Zane", "Nafnati", "Lucy", "Keenan", "Andrew", "Tai", "Will", "C.J.", "Javon", "T.J.", "Joe", "Tyrion", "Donovan", "Theo", "Justin", "Mahad", "Michael", "Jordan", "J.J.", "Dwight", "Fabian", "Byron", "Jalen", "Brian", "Josh", "Ivan", "Myles", "Jalen", "Will", "Bo", "Isaiah", "Levi", "Walter"
    };
    
    private static String[] lasts = { 
    	"Larson", "Steinmetz", "Atukorala","Pattanayak", "Haines", "Doree", "Belik", "Zobitz", "Sorensen", "Voyles", "Flint", "Chen", "Chafee", "Crowe", "Averbeck", "Klassin", "Brandl", "Mohamud", "Ahmed", "Xiong", "Memeti", "Lee", "Ng", "Nguyen", "Abdi", "Czech", "Vang", "OKeefe", "Atto", "Leal", "Hersi", "Mohammad", "Abukar", "Mckinnon", "Osman", "Yang", "Yusuf", "Edow", "Kempenich", "Adan", "Ali", "Hagen", "Torres", "Warns", "Beeby", "Gottimukala", "Alvarado","Boyer", "Sati", "Wadhawan", "Vo", "Ramales", "Ali", "Owusu", "Carrillo","Hopper","Lovelace", "Ellis", "Bryan", "Xiong", "Abdullahi", "Abukar", "Adem", "Ahmed", "Bashige", "Belayneh", "Bigwood", "Clark", "Davidson", "Maxmud", "Mccarl", "Mensah", "Mohamed", "Moktar", "Ochoa Martinez", "Saw Tamalar", "Tran", "Xiong","Yusuf", "Vang", "Tamalar","Rodriguez","Pankow", "Mehmeti", "Gyasi", "Griess", "Gisemba", "Garzon", "Edow", "Corneliusen","Calger", "Brown", "Assefa",  "Antonio", "Rohlf"," Angell", "Arafa", "Cotter", "Dhegadub", "Gomez", "Jimenez", "Gorter", "Lee", "Lillehei", "Ma", "Mckinnon", "Ngando", "Randolph", "Shire","Tefera","Woldearegay","Addison", "Allen", "Batty", "Brandel", "Brosmer", "Byrd", "Cashman", "Chambliss", "Chandler", "DePaola", "Felton", "Fries", "Ham", "Hargrave", "Hockenson", "Huber", "Ingram-Dawkins", "Jackson", "Jackson", "Jefferson", "Jones", "Jurgens", "Mason", "McCarthy", "McGlothern", "Moreau", "Murphy", "Nailor", "O'Neill", "Oliver", "Pace", "Price", "Redmond", "Reichard", "Richter", "Rodgers", "Rodriguez", "Rouse", "Rypien", "Scott", "Sims", "Skule", "Smith", "Taimani", "Thomas", "Turner", "Van Ginkel", "Vaughn", "Ward", "Wilson", "Wolford", "Wright", "Yurosek","Sherrod", "Hiedeman", "Carrington", "Carleton", "Fritz", "Smith", "Williams", "Shepard", "Taylor", "McBride", "Collier", "Kliundikova"
    };
}