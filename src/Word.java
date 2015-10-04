class Word {
	String word;
	YearCount[] count;
	String category;

	Word(String w) {
		word = w;
	}

	private class YearCount {
		int year;
		int frequency;
		int volume;

		YearCount(int y, int f, int v) {
			year = y;
			frequency = f;
			volume = v;
		}
	}

	// optional tester
	public static void main(String[] args) {
		System.out.println("tester!");
	}
}