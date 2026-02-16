/**
 * GFG 60-Day Streak Challenge - Day 3
 * Date: February 15, 2026
 * 
 * Problem: Meeting Rooms
 * Difficulty: Easy
 * Link: https://www.geeksforgeeks.org/problems/meeting-rooms/1
 * 
 * Topics: Arrays, Sorting, Intervals, Greedy
 * Pattern: Interval Scheduling
 * 
 * Problem Statement:
 * Given a 2D array arr[][] where:
 * - arr[i][0] represents the starting time of the i-th meeting
 * - arr[i][1] represents the ending time of the i-th meeting
 * 
 * Task: Check if it is possible for a person to attend all the meetings
 * such that they can attend only one meeting at a particular time.
 * 
 * Note: A person can attend a meeting if its starting time is greater than
 * or equal to the previous meeting's ending time.
 * 
 * Approach:
 * The key insight is that after sorting meetings by start time, we only need
 * to check if consecutive meetings overlap. If meeting[i] doesn't overlap with
 * meeting[i+1], it won't overlap with any later meetings either.
 * 
 * Algorithm:
 * 1. Sort the meetings by start time
 * 2. Iterate through consecutive meeting pairs
 * 3. If any current meeting's end time > next meeting's start time → overlap
 * 4. Return false if overlap found, true otherwise
 * 
 * Why Sorting Works:
 * After sorting by start time, if meeting A ends before meeting B starts,
 * and meeting B starts before meeting C, then meeting A also ends before
 * meeting C starts (transitive property). This eliminates the need to check
 * all pairs.
 * 
 * Example Walkthrough:
 * Input: arr[][] = [[1,4], [10,15], [7,10]]
 * 
 * Step 1: Sort by start time
 * [[1,4], [7,10], [10,15]]
 * 
 * Step 2: Check consecutive pairs
 * - [1,4] vs [7,10]: 4 ≤ 7 ✓ (No overlap)
 * - [7,10] vs [10,15]: 10 ≤ 10 ✓ (No overlap - can attend if equal)
 * 
 * Step 3: Return true (all meetings can be attended)
 * 
 * Example 2:
 * Input: arr[][] = [[2,4], [9,12], [6,10]]
 * 
 * Step 1: Sort by start time
 * [[2,4], [6,10], [9,12]]
 * 
 * Step 2: Check consecutive pairs
 * - [2,4] vs [6,10]: 4 ≤ 6 ✓ (No overlap)
 * - [6,10] vs [9,12]: 10 > 9 ✗ (Overlap! Second meeting ends after third starts)
 * 
 * Step 3: Return false (cannot attend all meetings)
 * 
 * Time Complexity: O(n log n)
 * - Sorting: O(n log n)
 * - Linear scan: O(n)
 * - Overall dominated by sorting
 * 
 * Space Complexity: O(1)
 * - In-place sorting
 * - Only using constant extra space for variables
 * 
 * Test Results:
 * ✅ Test Cases Passed: 1111/1111
 * ✅ Accuracy: 100%
 * ✅ Time Taken: 0.39 seconds
 * ✅ Points Scored: 2/2
 * ✅ Total Score: 114
 * 
 * Author: Niraj Jain
 * GitHub: https://github.com/nirajjain819
 * Codolio: https://codolio.com/profile/nirajjain819
 */

import java.util.*;

class Solution {
    
    /**
     * Check if a person can attend all meetings
     * 
     * @param arr 2D array where arr[i][0] = start time, arr[i][1] = end time
     * @return true if all meetings can be attended, false otherwise
     */
    static boolean canAttend(int[][] arr) {
        // Edge case: No meetings or single meeting
        if (arr == null || arr.length <= 1) {
            return true;
        }
        
        // Step 1: Sort meetings by start time
        // Using lambda comparator: (a,b) -> a[0] - b[0]
        // This sorts based on the first element (start time) of each array
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        int n = arr.length;
        
        // Step 2: Check for overlaps in consecutive meetings
        // After sorting, if meeting[i] doesn't overlap with meeting[i+1],
        // it won't overlap with any meeting[j] where j > i+1
        for (int i = 0; i < n - 1; i++) {
            // Get current meeting's end time
            int currEnd = arr[i][1];
            
            // Get next meeting's start time
            int nextStart = arr[i + 1][0];
            
            // Check for overlap
            // If current meeting ends AFTER next meeting starts → overlap
            // Note: currEnd == nextStart is OK (person can attend back-to-back)
            if (currEnd > nextStart) {
                return false;  // Found overlap, cannot attend all
            }
        }
        
        // No overlaps found, can attend all meetings
        return true;
    }
}

/**
 * Example Test Cases:
 * 
 * Test 1:
 * Input: arr[][] = [[1,4], [10,15], [7,10]]
 * Output: true
 * Explanation:
 * After sorting: [[1,4], [7,10], [10,15]]
 * [1,4] ends at 4, [7,10] starts at 7 (4 < 7) ✓
 * [7,10] ends at 10, [10,15] starts at 10 (10 = 10) ✓
 * All meetings can be attended
 * 
 * Test 2:
 * Input: arr[][] = [[2,4], [9,12], [6,10]]
 * Output: false
 * Explanation:
 * After sorting: [[2,4], [6,10], [9,12]]
 * [2,4] ends at 4, [6,10] starts at 6 (4 < 6) ✓
 * [6,10] ends at 10, [9,12] starts at 9 (10 > 9) ✗
 * Overlap between [6,10] and [9,12], cannot attend all
 */

/**
 * Key Learnings:
 * 
 * 1. Interval Scheduling Pattern:
 *    This is a classic interval scheduling problem. The pattern of sorting
 *    intervals by start time and checking consecutive pairs is fundamental.
 * 
 * 2. Sorting as Optimization:
 *    Sorting transforms an O(n²) problem into O(n log n).
 *    Without sorting: Check all pairs = n(n-1)/2 comparisons
 *    With sorting: Check n-1 consecutive pairs
 * 
 * 3. Transitive Property:
 *    After sorting, if A doesn't overlap B, and B doesn't overlap C,
 *    then A doesn't overlap C. This eliminates redundant checks.
 * 
 * 4. Lambda Comparators in Java:
 *    Arrays.sort(arr, (a,b) -> a[0] - b[0]) is concise way to sort 2D arrays
 *    Alternative: Arrays.sort(arr, Comparator.comparingInt(a -> a[0]))
 * 
 * 5. Edge Case: Equal Times:
 *    When currEnd == nextStart, person can attend both (back-to-back)
 *    Only currEnd > nextStart indicates overlap
 * 
 * 6. Pattern Recognition:
 *    This pattern appears in many interval problems:
 *    - Merge Intervals
 *    - Insert Interval
 *    - Non-overlapping Intervals
 *    - Minimum Meeting Rooms (Meeting Rooms II)
 *    - Minimum Platforms
 */

/**
 * Alternative Approaches:
 * 
 * 1. Brute Force (Not Recommended):
 * ```java
 * for (int i = 0; i < n; i++) {
 *     for (int j = i+1; j < n; j++) {
 *         if (overlap(arr[i], arr[j])) 
 *             return false;
 *     }
 * }
 * return true;
 * ```
 * Time: O(n²), Space: O(1)
 * Works but inefficient for large inputs
 * 
 * 2. Using TreeMap (Overkill):
 * Store intervals in TreeMap sorted by start time
 * Time: O(n log n), Space: O(n)
 * Same time complexity but uses extra space unnecessarily
 * 
 * 3. Sort by End Time (Also Works):
 * Can also sort by end time and check if next start >= current end
 * Time: O(n log n), Space: O(1)
 * Equivalent to our approach
 */

/**
 * Related Problems:
 * 
 * 1. Merge Intervals (Medium):
 *    Given intervals, merge all overlapping intervals
 *    Same sorting technique, different merging logic
 * 
 * 2. Insert Interval (Medium):
 *    Insert a new interval and merge if necessary
 *    Uses interval scheduling concepts
 * 
 * 3. Non-overlapping Intervals (Medium):
 *    Find minimum intervals to remove to make rest non-overlapping
 *    Greedy + Interval scheduling
 * 
 * 4. Meeting Rooms II (Medium):
 *    Find minimum number of meeting rooms required
 *    Extension of this problem - uses sweep line or priority queue
 * 
 * 5. Minimum Platforms (Medium):
 *    Find minimum railway platforms needed
 *    Similar to Meeting Rooms II
 */

/**
 * Common Mistakes:
 * 
 * 1. Forgetting to Sort:
 *    Without sorting, checking consecutive pairs doesn't work
 *    Must sort first!
 * 
 * 2. Wrong Overlap Condition:
 *    Using currEnd >= nextStart instead of currEnd > nextStart
 *    Equal times are allowed (back-to-back meetings)
 * 
 * 3. Off-by-One Error:
 *    Loop should be i < n-1, not i < n
 *    Otherwise you'll access arr[i+1] out of bounds
 * 
 * 4. Not Handling Edge Cases:
 *    Empty array, single meeting, null input
 *    Always check these first
 * 
 * 5. Assuming Pre-sorted Input:
 *    Never assume input is sorted unless stated
 *    Always sort yourself
 */

/**
 * Performance Optimization Tips:
 * 
 * 1. In-place Sorting:
 *    Arrays.sort() modifies original array (saves space)
 *    If you need original, make a copy first
 * 
 * 2. Early Return:
 *    Return false as soon as overlap found
 *    Don't continue checking unnecessarily
 * 
 * 3. Simple Comparator:
 *    (a,b) -> a[0] - b[0] is faster than complex comparisons
 *    Use subtraction for integer comparisons
 * 
 * 4. Avoid Object Creation:
 *    Use primitives instead of Integer objects where possible
 *    Reduces garbage collection overhead
 */
