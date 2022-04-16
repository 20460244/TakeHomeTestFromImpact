import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestNumberRangeSummarizer {
    NumberRangeSummarizer result = new NumberRangeSummarizer();

    @Test
    public void TestGroupingNumbersIntoRange() {
        assertEquals("1-4", NumberRangeSummarizer.summarizeCollection(NumberRangeSummarizer.collect("1,2,3,4")));
    }

    @Test
    public void TestExpectedResults()
    {
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", NumberRangeSummarizer.summarizeCollection(NumberRangeSummarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31")));

    }

    @Test
    public void TestSortedAndUnsortedumbers()
    {
        //Unsorted numbers
        assertEquals("1, 3, 5, 7-9, 15, 21", NumberRangeSummarizer.summarizeCollection(NumberRangeSummarizer.collect("1,3,15,7,21,8,9,5")));
        //Sorted numbers
        assertEquals("1, 3, 5, 7-9, 15, 21", NumberRangeSummarizer.summarizeCollection(NumberRangeSummarizer.collect("1,3,5,7,8,9,15,21")));

    }

    @Test
    public void TestEmptyCollection()
    {
        assertEquals( "", NumberRangeSummarizer.summarizeCollection(NumberRangeSummarizer.collect("")));
    }

    @Test
    public void TestDuplicateNumbers()
    {
        assertEquals("1, 3, 5, 7-9, 15, 21", NumberRangeSummarizer.summarizeCollection(NumberRangeSummarizer.collect("1,3,3,3,3,5,7,7,8,9,9,9,9,15,21")));
    }

    @Test
    public void TestNegativeInputNumbers()
    {
        assertEquals("-9, -3, 2-3, 7, 9, 15, 21", NumberRangeSummarizer.summarizeCollection(NumberRangeSummarizer.collect("-9,-3,2,3,7,9,15,21")));
        assertEquals("-11, -9, -3--2, 7, 9", NumberRangeSummarizer.summarizeCollection(NumberRangeSummarizer.collect("-11,-9,-3,-2,7,9,")));
    }

    @Test
    public void TestSingleInput()
    {
       
        assertEquals("1",NumberRangeSummarizer.summarizeCollection(NumberRangeSummarizer.collect("1")));
    }

    
}
