class SentenceComplete {
	static BinarySearchTree = new BinarySearchTree();
	public static void main(String[] args) {
        if(args.length != 1) {
        	System.out.println("use: java SentenceComplete filename.txt");
        	exit(1);
        }
        readData(args[1]);
	}

	static void readData(String filename) {

	}
}