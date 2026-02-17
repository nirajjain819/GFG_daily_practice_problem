/**
 * GFG 60-Day Streak Challenge - Day 1
 * Date: February 13, 2026
 * 
 * Problem: The Painter's Partition Problem-II
 * Difficulty: Hard
 * Link: https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
 * 
 * Topics: Binary Search, Greedy, Arrays
 * Pattern: Binary Search on Answer Space
 * 
 * Problem Statement:
 * Given an array arr[] where each element denotes the length of a board,
 * and an integer k representing the number of painters available.
 * Each painter takes 1 unit of time to paint 1 unit length.
 * 
 * Find the minimum time required to paint all boards where:
 * - Each painter can only paint contiguous boards
 * - All painters work simultaneously
 * 
 * Approach:
 * Instead of trying all possible partitions (exponential time),
 * we use Binary Search on the answer space.
 * 
 * Key Insight:
 * If we can complete painting in time T, we can also complete in time T+1, T+2, etc.
 * If we cannot complete in time T, we also cannot in time T-1, T-2, etc.
 * This monotonic property allows us to use binary search!
 * 
 * Algorithm:
 * 1. Search space: [max(arr), sum(arr)]
 *    - min time = max element (one painter does the longest board)
 *    - max time = sum of all (one painter does everything)
 * 
 * 2. For each mid value, check if allocation is possible
 *    - Greedily assign boards to painters
 *    - If current painter's time exceeds mid, assign to next painter
 *    - Check if we can manage with k painters
 * 
 * 3. If possible with mid time, try smaller time (search left)
 *    Otherwise, increase time (search right)
 * 
 * Time Complexity: O(n * log(sum of array))
 * - Binary search: O(log(sum))
 * - Validation for each mid: O(n)
 * 
 * Space Complexity: O(1)
 * - No extra space used
 * 
 * Author: Niraj Jain
 * GitHub: https://github.com/nirajjain819
 */

class Solution {
    
    /**
     * Helper function to check if allocation is possible with given max time
     * Uses greedy approach to assign boards to painters
     * 
     * @param md maximum time allowed per painter
     * @param arr array of board lengths
     * @return number of painters needed, or Integer.MAX_VALUE if impossible
     */
    private int check(int md, int[] arr) {
        int n = arr.length;        // Total number of boards
        int sm = 0;                // Current painter's accumulated time
        int k = 1;                 // Number of painters used (start with 1)
        
        // Iterate through all boards
        for (int i = 0; i < n; i++) {
            // If single board exceeds max time, allocation is impossible
            // Return MAX_VALUE to indicate impossibility
            if (arr[i] > md)
                return Integer.MAX_VALUE;
            
            // Add current board time to current painter's workload
            sm += arr[i];
            
            // If adding this board exceeds max time for current painter
            if (sm > md) {
                k++;                // Need a new painter
                sm = arr[i];        // New painter starts with current board
            }
        }
        
        // Return total painters needed for this max time
        return k;
    }
    
    /**
     * Main function to find minimum time required to paint all boards
     * Uses Binary Search on answer space
     * 
     * @param arr array of board lengths
     * @param k number of painters available
     * @return minimum time needed to complete all painting
     */
    public int minTime(int[] arr, int k) {
        // Binary search bounds
        int l = 1;                  // Lower bound: minimum possible time
        int h = 10000000;           // Upper bound: large enough max time (10^7)
        int ans = -1;               // Store the final answer
        
        // Binary search on the answer space
        while (l <= h) {
            // Calculate mid value (potential answer to test)
            int md = l + (h - l) / 2;    // Prevents integer overflow
            
            // Check how many painters are needed if max time = md
            int paintersNeeded = check(md, arr);
            
            // If we can do it with k or fewer painters
            if (k >= paintersNeeded) {
                ans = md;           // This is a valid answer
                h = md - 1;         // Try to find even smaller time (search left)
            } else {
                // We need more painters than available
                // So we need more time per painter
                l = md + 1;         // Search for larger time (search right)
            }
        }
        
        return ans;  // Return the minimum time found
    }
}

/**
 * Example Test Cases:
 * 
 * Test 1:
 * Input: arr = [5, 10, 30, 20, 15], k = 3
 * Output: 35
 * Explanation:
 * Painter 1: [5, 10] = 15
 * Painter 2: [30] = 30
 * Painter 3: [20, 15] = 35
 * Max time = 35
 * 
 * Test 2:
 * Input: arr = [10, 20, 30, 40], k = 2
 * Output: 60
 * Explanation:
 * Painter 1: [10, 20, 30] = 60
 * Painter 2: [40] = 40
 * Max time = 60
 * 
 * Test 3:
 * Input: arr = [100, 200, 300, 400], k = 1
 * Output: 1000
 * Explanation:
 * Only one painter, must paint all sequentially
 * Total = 100 + 200 + 300 + 400 = 1000
 */

/**
 * Key Learnings:
 * 
 * 1. Binary Search on Answer Pattern:
 *    When problem asks to minimize maximum or maximize minimum,
 *    think about binary search on the answer space
 * 
 * 2. Greedy Validation:
 *    For each potential answer, use greedy approach to check feasibility
 * 
 * 3. Similar Problems:
 *    - Book Allocation Problem
 *    - Aggressive Cows
 *    - Split Array Largest Sum
 *    - Minimize Max Distance to Gas Station
 * 
 * 4. Pattern Recognition:
 *    If checking "can we do it in X time/space" is easier than
 *    finding optimal X, use binary search on X
 */
