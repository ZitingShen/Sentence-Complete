/***************************************************************************
* Author: Ziting Shen
* Date: 10/04/2015
*
* This program is the Word class used to store the Ngram data. It can store
* the word, the frequency and the volumn each year, and the total volumn and
* frequency.
*/
import java.util.ArrayList;
class Word {
  String word;
  ArrayList<YearCount> count = new ArrayList<YearCount>();
  int totalFrequency = 0;
  int totalVolume = 0;

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
    Word w = new Word("goaway", 1989, 3, 2);
    w.add(2001, 4, 1);
    w.add(2003, -3, 2);
    System.out.println("tester!");
    System.out.println(w);
  }
}