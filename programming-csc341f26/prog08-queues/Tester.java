public class Tester {	

	public static void main(String[] args) {
	
		String[] stringInput = { "A", "B", "C", "D", "E", "F"};
		Integer[] integerInput = { 10, 20, 30, 40, 50, 60 };
	
		System.out.println("\nTesting Queue String --------------------------------");
		QueueInterface<String> queueString = new Queue<>();
		testFunctionality(queueString, stringInput);
		System.out.println("\nTesting Queue Integer --------------------------------");		
		QueueInterface<Integer> queueInteger = new Queue<>();
		testFunctionality(queueInteger,integerInput);
		
		System.out.println("\nTesting Stack String ---------------------------------");
		queueString = new Stack<String>();
		testFunctionality(queueString, stringInput);
		System.out.println("\nTesting Stack Integer --------------------------------");
		queueInteger = new Stack<Integer>();
		testFunctionality(queueInteger, integerInput);		
	}
	
	public static <T> void testFunctionality(QueueInterface<T> q, T[] input) {
	
		System.out.println("Executing a series of push/pop to go around the Q.");
		q.push(input[0]);
		q.push(input[1]);
		q.push(input[2]);
		System.out.printf("%s %s %s\n",q.pop(),q.pop(),q.pop());
		q.push(input[0]);
		q.push(input[1]);
		q.push(input[2]);
		System.out.printf("%s %s %s\n",q.pop(),q.pop(),q.pop());
		q.push(input[0]);
		q.push(input[1]);
		q.push(input[2]);
		System.out.printf("%s %s %s\n",q.pop(),q.pop(),q.pop());
		q.push(input[0]);
		q.push(input[1]);
		q.push(input[2]);
		q.push(input[3]);
		q.push(input[4]);
		q.push(input[5]);
		System.out.println("toString: "+q);
		
		System.out.println("pop it all back out.");
		while (!q.empty()) {
			System.out.print(q.pop()+" ");
		}
		System.out.println();
	} // end testFunctionality
}