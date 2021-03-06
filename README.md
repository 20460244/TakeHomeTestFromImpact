# TakeHomeTestFromImpact

# Task
Implement this Interface to produce a comma delimited list of numbers,
grouping the numbers into a range when they are sequential.


 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
 * Result: "1, 3, 6-8, 12-15, 21-24, 31"
 
 # The code will be evaluated on
 *   - functionality
 *   - style
 *   - robustness
 *   - best practices
 *   - unit tests

# Solution
Following situations are supported by the solution:
 *   - Empty Collection or Input
 *   - Sorted and unsorted numbers
 *   - Negative input numbers
 *   - Duplicate numbers
 *   - Expected results
 *   - Single input


# Test unit
Junit jupiter Testing was used to verify the solution obtained using the two implemented functions: summarizeCollection() and collect(). File TestNumberRangeSummarizer.jar contains the tests.

