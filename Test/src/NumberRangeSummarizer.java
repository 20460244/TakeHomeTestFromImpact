import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberRangeSummarizer {
    //collect the input
    static Collection<Integer> collect(String input) 
    {   
      // Collection<Integer> set;
       // Collection<Integer> nas = Collections.EMPTY_LIST;
        
        //empty collection
        if(input == ""){
            System.out.println("The collection is empty");
            return Collections.emptyList();
        }
        // Split input String using a comma to form a fixed list of numbers
        String[] splittedInput = input.split(",");

        //store sorted number in ascending order
        SortedSet<Integer> sortedInput = new TreeSet<Integer>();
        
        
       int i = 0;
       while(i < (splittedInput.length)){
        sortedInput.add(Integer.parseInt(splittedInput[i])); 
        i++;
       }
        return sortedInput; //sorted collection
    }
    
 //get the summarized string  
 static String summarizeCollection(Collection<Integer> input) {
 int len = input.size(); // input size
 //empty collection
 if(input.isEmpty()){
    System.out.println("The summarizeCollection is empty");
    return  "";
  }
      
    List<Integer> inputList = new ArrayList<Integer>();
      
    // Add the input to the inputList
     for(int i : input)
     inputList.add(i);
    
     // List to store summarized results
     List<String> summarizeResult = new ArrayList<String>();
 
     //inital value on the list 
     int start = inputList.get(0);
        
        // grouping the sequential numbers
         for (int i =0 ; i < len; i++){
         if ((i+1 == len)||(inputList.get(i)+1)!= inputList.get(i+1)){
            if (inputList.get(i) != start) summarizeResult.add( start + "-" + inputList.get(i));
            else summarizeResult.add(start + "");
            if( i+1 != len) start = inputList.get(i+1); 
           }
         }  
       
     // convert String list to String
      String result = summarizeResult.stream().map(Object::toString)
     .collect(Collectors.joining(", "));

    return result;

    }


    @Test
    public void TestGroupingNumbersIntoRange() {
        assertEquals("1-4", NumberRangeSummarizer.summarizeCollection(collect("1,2,3,4")));
    }

    @Test
    public void TestExpectedResults()
    {
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", NumberRangeSummarizer.summarizeCollection(collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31")));

    }

    @Test
    public void TestSortedAndUnsortedumbers()
    {
        //Unsorted numbers
        assertEquals("1, 3, 5, 7-9, 15, 21", NumberRangeSummarizer.summarizeCollection(collect("1,3,15,7,21,8,9,5")));
        //Sorted numbers
        assertEquals("1, 3, 5, 7-9, 15, 21", NumberRangeSummarizer.summarizeCollection(collect("1,3,5,7,8,9,15,21")));

    }

    @Test
    public void TestEmptyCollection()
    {
        assertEquals( "", NumberRangeSummarizer.summarizeCollection(collect("")));
    }

    @Test
    public void TestDuplicateNumbers()
    {
        assertEquals("1, 3, 5, 7-9, 15, 21", NumberRangeSummarizer.summarizeCollection(collect("1,3,3,3,3,5,7,7,8,9,9,9,9,15,21")));
    }

    @Test
    public void TestNegativeInputNumbers()
    {
        assertEquals("-9, -3, 2-3, 7, 9, 15, 21", NumberRangeSummarizer.summarizeCollection(collect("-9,-3,2,3,7,9,15,21")));
        assertEquals("-11, -9, -3--2, 7, 9", NumberRangeSummarizer.summarizeCollection(collect("-11,-9,-3,-2,7,9,")));
    }

    @Test
    public void TestSingleInput()
    {
       
        assertEquals("1",NumberRangeSummarizer.summarizeCollection(collect("1")));
    }

}

    
    
        