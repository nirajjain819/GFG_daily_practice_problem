/**
 * GFG 60-Day Streak Challenge - Day 2
 * Date: February 14, 2026
 * 
 * Problem: Chocolate Distribution Problem
 * Difficulty: Easy
 * Link: https://www.geeksforgeeks.org/problems/chocolate-distribution-problem/1
 * 
 * Topics: Arrays, Greedy, Sliding Window, Sorting
 * Pattern: Sort + Sliding Window
 * 
 * Problem Statement:
 * Given an array arr[] of positive integers representing the number of chocolates 
 * in each packet. There are m students. Distribute chocolate packets among m students 
 * such that:
 * 1. Each student gets exactly one packet
 * 2. The difference between maximum chocolates and minimum chocolates given to 
 *    students is minimum
 * 
 * Return the minimum possible difference.
 * 
 * Approach:
 * The key insight is that after sorting, the minimum difference will always be 
 * among contiguous elements. Why? Because sorting brings similar values together.
 * 
 * If we pick non-contiguous elements, the difference will always be larger than 
 * picking contiguous elements.
 * 
 * Algorithm:
 * 1. Sort the array - brings similar values together
 * 2. Use sliding window of size m to check all possible distributions
 * 3. For each window, calculate difference (last - first element)
 * 4. Return the minimum difference found
 * 
 * Example Walkthrough:
 * Input: arr = [3, 4, 1, 9, 56, 7, 9, 12], m = 5
 * 
 * Step 1: Sort → [1, 3, 4, 7, 9, 9, 12, 56]
 * 
 * Step 2: Check all windows of size 5:
 * Window 1: [1, 3, 4, 7, 9]    → diff = 9 - 1 = 8
 * Window 2: [3, 4, 7, 9, 9]    → diff = 9 - 3 = 6  ← Minimum
 * Window 3: [4, 7, 9, 9, 12]   → diff = 12 - 4 = 8
 * Window 4: [7, 9, 9, 12, 56]  → diff = 56 - 7 = 49
 * 
 * Step 3: Return minimum = 6
 * 
 * Time Complexity: O(n log n)
 * - Sorting: O(n log n)
 * - Sliding window: O(n)
 * - Overall dominated by sorting
 * 
 * Space Complexity: O(1)
 * - Only using a few variables
 * - Sorting is in-place (depends on implementation)
 * 
 * Test Results:
 * ✅ Test Cases Passed: 1112/1112
 * ✅ Accuracy: 100%
 * ✅ Time Taken: 0.9 seconds
 * 
 * Author: Niraj Jain
 * GitHub: https://github.com/nirajjain819
 * Codolio: https://codolio.com/profile/nirajjain819
 */

import java.util.*;

class Solution {
    
    /**
     * Main function to find minimum difference in chocolate distribution
     * 
     * @param arr ArrayList of integers representing chocolates in each packet
     * @param m number of students
     * @return minimum possible difference between max and min chocolates
     */
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // Get the size of array
        int n = arr.size();
        
        // Edge cases: 
        // If no students, no packets, or more students than packets
        if (m == 0 || n == 0 || m > n) {
            return 0;
        }
        
        // Step 1: Sort the array
        // This brings similar values together
        // After sorting, minimum difference will be among contiguous elements
        Collections.sort(arr);
        
        // Initialize result with maximum possible value
        int res = Integer.MAX_VALUE;
        
        // Step 2: Use sliding window of size m
        // We need to check all possible distributions of m packets
        // For each window, calculate difference between last and first element
        for (int i = 0; i <= n - m; i++) {
            // Calculate difference for current window
            // arr.get(i + m - 1) → last element of window
            // arr.get(i) → first element of window
            int diff = arr.get(i + m - 1) - arr.get(i);
            
            // Update result if current difference is smaller
            res = Math.min(res, diff);
        }
        
        // Return the minimum difference found
        return res;
    }
}

/**
 * Example Test Cases:
 * 
 * Test 1:
 * Input: arr = [3, 4, 1, 9, 56, 7, 9, 12], m = 5
 * Output: 6
 * Explanation:
 * After sorting: [1, 3, 4, 7, 9, 9, 12, 56]
 * Best window: [3, 4, 7, 9, 9] with difference = 9 - 3 = 6
 * 
 * Test 2:
 * Input: arr = [7, 3, 2, 4, 9, 12, 56], m = 3
 * Output: 2
 * Explanation:
 * After sorting: [2, 3, 4, 7, 9, 12, 56]
 * Best window: [2, 3, 4] with difference = 4 - 2 = 2
 * 
 * Test 3:
 * Input: arr = [3, 4, 1, 9, 56], m = 5
 * Output: 55
 * Explanation:
 * After sorting: [1, 3, 4, 9, 56]
 * Only one possible window: [1, 3, 4, 9, 56]
 * Difference = 56 - 1 = 55
 */

/**
 * Key Learnings:
 * 
 * 1. Greedy Approach:
 *    Sometimes the greedy approach (sort first, then check) is optimal.
 *    Not every problem needs dynamic programming or complex algorithms.
 * 
 * 2. Sliding Window Pattern:
 *    After sorting, use a sliding window to check all possible contiguous
 *    distributions. This is a common pattern in array problems.
 * 
 * 3. Why Sorting Works:
 *    Sorting ensures that similar values are adjacent. Any non-contiguous
 *    selection will have a larger difference than contiguous selection.
 *    
 *    Example: [1, 3, 4, 7, 9]
 *    Contiguous [3, 4, 7]: diff = 4
 *    Non-contiguous [1, 4, 9]: diff = 8
 *    
 *    Contiguous always wins after sorting!
 * 
 * 4. Time-Space Tradeoff:
 *    We trade time (O(n log n) for sorting) for a simpler algorithm
 *    that uses O(1) space. This is often the right tradeoff.
 * 
 * 5. Pattern Category:
 *    This problem combines two patterns:
 *    - Greedy (sort first)
 *    - Sliding Window (check all windows of size m)
 * 
 * 6. Similar Problems:
 *    - Minimize Max Distance to Gas Station
 *    - Allocate Minimum Pages
 *    - Find K Closest Elements
 *    - Koko Eating Bananas
 *    
 *    All use similar "sort + sliding window" or "sort + greedy" patterns.
 */

/**
 * Common Mistakes to Avoid:
 * 
 * 1. Forgetting to sort:
 *    Without sorting, finding minimum difference is O(n²) or worse
 * 
 * 2. Wrong window calculation:
 *    Window end should be (i + m - 1), not (i + m)
 *    Because array is 0-indexed
 * 
 * 3. Off-by-one errors:
 *    Loop should go till (n - m), not (n - m + 1)
 *    Last valid window starts at index (n - m)
 * 
 * 4. Edge cases:
 *    Handle m = 0, n = 0, m > n cases properly
 * 
 * 5. Overthinking:
 *    Don't jump to DP or complex recursion
 *    Sometimes simple greedy + sorting is the answer
 */
