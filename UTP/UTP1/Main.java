/**
 *
 *  @author Klukowski Emil S27944
 *
 */

package zad1;



import java.util.*;

import static zad1.ListCreator.collectFrom;


public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);
    System.out.println(test1(src1));

    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv" );
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {
    Selector<Integer> sel = new Selector<Integer>(){
      @Override
      public boolean select(Integer element) {
        return element<10;
      }
    };
    /*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */


    Mapper<Integer, Integer> map = new Mapper<Integer, Integer>() {
      @Override
      public Integer map(Integer element) {
        return element+10;
      }
    };/*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */


    return   /*<-- zwrot wyniku
      uzyskanego przez wywołanie statycznej metody klasy ListCreator:
     */  collectFrom(src).when(sel).mapEvery(map);
  }

  public List<Integer> test2(List<String> src) {
    Selector<String> sel = new Selector<String>() {
      @Override
      public boolean select(String element) {
        return element.length()>3;
      }
    };/*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */

    Mapper<String, Integer> map = new Mapper<String, Integer>() {
      @Override
      public Integer map(String element) {
        return element.length()+10;
      }
    }; /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
    return   /*<-- zwrot wyniku
      uzyskanego przez wywołanie statycznej metody klasy ListCreator:
     */  collectFrom(src).when(sel).mapEvery(map);
  }

  public static void main(String[] args) {
    new Main();
  }
}
