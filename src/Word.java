/***************************************************************************
* Author: Ziting Shen
* Date: 10/04/2015
*
* This program is the Word class used to store the Ngram data. It can store
* the word, the frequency and the volumn each year, and the total volumn and
* frequency.
*/
import java.util.ArrayList;
class Word implements Comparable<Word>{
    private String word;
    private ArrayList<YearCount> count = new ArrayList<YearCount>();
    private int totalFrequency = 0;
    private int totalVolume = 0;

    // constructors
    Word(String w) {
        word = w;
    }

    Word(String w, int y, int f, int v) {
        word = w;
        add(y, f, v);
    }

    // add the data of another year to an existing object
    public void add(int y, int f, int v) {
        if((f < 0) || (v < 0))
            System.out.println("Please give valid frequency and volume!");
        else {
            count.add(new YearCount(y, f, v));
            totalFrequency += f;
            totalVolume += v;
        }
    }

    // comparator
    public int compareTo(Word other) {
        return Integer.compare(totalFrequency, other.getFrequency());
    }

    // accessor
    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return totalFrequency;
    }

    public int getVolume() {
        return totalVolume;
    }

    // help print out the word
    public String toString() {
        return word + "\" has appeared " + totalFrequency + " times in " 
        + totalVolume + " volumes in " + count.size() + " years.";
    }

  // a nested class to store the year and the corresponding frequency and
  // volumn
    private class YearCount {
        int year;
        int frequency;
        int volume;

        // constructors
        YearCount(int y, int f, int v) {
            year = y;
            frequency = f;
            volume = v;
        }
    }

    // optional tester
    public static void main(String[] args) {
        Word w1 = new Word("goaway", 1989, 3, 2);
        Word w2 = new Word("don't", 1996, 12, 3);
        w1.add(2001, 4, 1);
        w1.add(2003, -3, 2);
        System.out.println("tester!");
        System.out.println(w1);
        System.out.println(w1.compareTo(w2));
    }
}