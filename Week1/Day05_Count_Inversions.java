/**
 * GFG 60-Day Streak Challenge - Day 5
 * Date: February 17, 2026
 *
 * Problem: Count Inversions
 * Difficulty: Medium
 * Link: https://www.geeksforgeeks.org/problems/inversion-of-array/1
 *
 * Topics: Arrays, Merge Sort, Divide and Conquer, Sorting
 * Pattern: Modified Merge Sort
 *
 * Problem Statement:
 * Given an array of integers arr[]. Find the Inversion Count in the array.
 *
 * Inversion Count: The number of pairs of elements (i, j) such that
 * i < j and arr[i] > arr[j]
 *
 * In other words, count how many pairs are "out of order".
 *
 * Example:
 * arr[] = [2, 4, 1, 3, 5]
 * Inversions: (2,1), (4,1), (4,3)
 * Count = 3
 *
 * Test Results:
 * ✅ Test Cases Passed: 1115/1115
 * ✅ Accuracy: 100%
 * ✅ Time: 0.77 seconds
 * ✅ Points: 4/4
 * ✅ Total Score: 130
 *
 * Author: Niraj Jain
 * GitHub: https://github.com/nirajjain819
 * Codolio: https://codolio.com/profile/nirajjain819
 */

import java.util.*;

// =====================================================================
// APPROACH 1: BRUTE FORCE
// Time: O(n²) | Space: O(1)
// =====================================================================
/**
 * Brute Force Approach:
 *
 * Idea: Check every pair (i, j) where i < j.
 * If arr[i] > arr[j], it's an inversion.
 *
 * Steps:
 * 1. Use nested loops to check all pairs
 * 2. For each i, check all j > i
 * 3. Count when arr[i] > arr[j]
 *
 * Drawback: O(n²) - Times out for large inputs (n > 10^5)
 * Use only for small arrays or understanding the problem
 */
class SolutionBruteForce {
    static long inversionCount(int arr[]) {
        int n = arr.length;
        long count = 0;

        // Check every pair (i, j) where i < j
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // If arr[i] > arr[j], it's an inversion
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
// Time:  O(n²) - nested loops checking all pairs
// Space: O(1)  - no extra space used


// =====================================================================
// APPROACH 2: BETTER - USING BINARY INDEXED TREE (BIT) / FENWICK TREE
// Time: O(n log n) | Space: O(max_element)
// =====================================================================
/**
 * Binary Indexed Tree Approach:
 *
 * Idea: As we traverse the array, for each element, count how many
 * elements seen so far are greater than current element.
 *
 * Steps:
 * 1. Coordinate compression (if needed for large values)
 * 2. Process elements from right to left
 * 3. For each element, query BIT for count of larger elements
 * 4. Update BIT with current element
 *
 * Better than brute force but complex to implement.
 * Not commonly asked in interviews.
 */
// Implementation skipped for brevity - Merge Sort is preferred


// =====================================================================
// APPROACH 3: OPTIMAL - MODIFIED MERGE SORT
// Time: O(n log n) | Space: O(n)
// =====================================================================
/**
 * Modified Merge Sort Approach (OPTIMAL):
 *
 * Key Insight:
 * Merge Sort naturally compares elements from left and right subarrays.
 * When we find left[i] > right[j] during merge, we know that ALL
 * remaining elements in left subarray are also greater than right[j].
 *
 * This allows us to count multiple inversions in one comparison!
 *
 * Algorithm:
 * 1. Divide: Split array into two halves
 * 2. Conquer: Recursively count inversions in each half
 * 3. Combine: Count inversions across halves while merging
 *
 * Total inversions = left_inversions + right_inversions + cross_inversions
 *
 * Why this works:
 * - Left half inversions: pairs within left subarray
 * - Right half inversions: pairs within right subarray
 * - Cross inversions: pairs where i is in left, j is in right
 *
 * The merge step efficiently counts cross inversions!
 */
class Solution {
    /**
     * Main function to count inversions
     */
    static long inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Modified Merge Sort that counts inversions
     *
     * @param arr array to sort and count inversions
     * @param left starting index
     * @param right ending index
     * @return number of inversions in range [left, right]
     */
    static long mergeSort(int[] arr, int left, int right) {
        long count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            // Count inversions in left half
            count += mergeSort(arr, left, mid);

            // Count inversions in right half
            count += mergeSort(arr, mid + 1, right);

            // Count inversions across left and right halves
            // This happens during the merge step
            count += merge(arr, left, mid, right);
        }

        return count;
    }

    /**
     * Merge two sorted subarrays and count inversions
     *
     * @param arr array containing both subarrays
     * @param left start of left subarray
     * @param mid end of left subarray (start of right is mid+1)
     * @param right end of right subarray
     * @return number of inversions found during merge
     */
    static long merge(int[] arr, int left, int mid, int right) {
        // Calculate sizes of two subarrays
        int n1 = mid - left + 1;  // Size of left subarray
        int n2 = right - mid;      // Size of right subarray

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Merge the temp arrays back and count inversions
        int i = 0;     // Initial index of left subarray
        int j = 0;     // Initial index of right subarray
        int k = left;  // Initial index of merged array
        long inversions = 0;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                // No inversion: element from left is smaller or equal
                arr[k++] = L[i++];
            } else {
                // INVERSION FOUND!
                // L[i] > R[j], which means all remaining elements
                // in L (from i to n1-1) are also greater than R[j]
                //
                // Example: L = [4, 5, 6], R = [1, 2, 3]
                // When L[0]=4 > R[0]=1:
                // - (4, 1) is an inversion
                // - (5, 1) is an inversion
                // - (6, 1) is an inversion
                // Total: 3 inversions = (n1 - i)
                inversions += (n1 - i);
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements of L[], if any
        while (i < n1) {
            arr[k++] = L[i++];
        }

        // Copy remaining elements of R[], if any
        while (j < n2) {
            arr[k++] = R[j++];
        }

        return inversions;
    }
}
// Time:  O(n log n) - T(n) = 2T(n/2) + O(n) → Master Theorem
// Space: O(n)       - Temporary arrays in merge + O(log n) recursion stack


/**
 * Example Walkthrough:
 *
 * Input: arr = [2, 4, 1, 3, 5]
 *
 * Step 1: Split
 *          [2, 4, 1, 3, 5]
 *         /               \
 *    [2, 4, 1]         [3, 5]
 *    /      \          /     \
 * [2, 4]    [1]      [3]     [5]
 *  /  \
 * [2] [4]
 *
 * Step 2: Merge and Count (bottom-up)
 *
 * Level 1:
 * - Merge [2] and [4]: No inversions (2 < 4)
 * - Result: [2, 4]
 *
 * Level 2:
 * - Merge [2, 4] and [1]:
 *   - 2 > 1 → inversions += 2 (both 2 and 4 > 1)
 *   - 4 > 1 → already counted above
 *   - Result: [1, 2, 4], inversions = 2
 *
 * - Merge [3] and [5]: No inversions (3 < 5)
 *   - Result: [3, 5]
 *
 * Level 3:
 * - Merge [1, 2, 4] and [3, 5]:
 *   - 1 < 3 → no inversion
 *   - 2 < 3 → no inversion
 *   - 4 > 3 → inversions += 1 (only 4 > 3)
 *   - Result: [1, 2, 3, 4, 5], inversions = 1
 *
 * Total inversions = 2 + 0 + 1 = 3 ✅
 *
 * Inversions found: (2,1), (4,1), (4,3)
 */


/**
 * Complexity Comparison:
 *
 * ┌────────────────┬────────────┬────────────┬─────────────┐
 * │ Approach       │ Time       │ Space      │ Interview?  │
 * ├────────────────┼────────────┼────────────┼─────────────┤
 * │ Brute Force    │ O(n²)      │ O(1)       │ No (TLE)    │
 * │ BIT/Fenwick    │ O(n log n) │ O(max)     │ Rarely      │
 * │ Merge Sort     │ O(n log n) │ O(n)       │ YES ✅      │
 * └────────────────┴────────────┴────────────┴─────────────┘
 *
 * Modified Merge Sort is THE standard solution:
 * - Optimal time complexity
 * - Reasonable space complexity
 * - Clean and elegant
 * - Demonstrates Divide & Conquer understanding
 */


/**
 * Key Learnings:
 *
 * 1. Modifying Standard Algorithms:
 *    You can modify well-known algorithms (like Merge Sort) to solve
 *    new problems. This is a common pattern in competitive programming.
 *
 * 2. Counting During Merge:
 *    The key insight: when L[i] > R[j], ALL elements from i to end
 *    of left subarray form inversions with R[j].
 *    Count them all at once: (n1 - i)
 *
 * 3. Divide and Conquer:
 *    Total inversions = inversions in left + inversions in right
 *                     + inversions across left and right
 *
 * 4. Why Not Simple Sort?
 *    If you just sort the array, you lose position information.
 *    Merge Sort maintains relative positions while sorting, allowing
 *    us to count inversions.
 *
 * 5. Long vs Int:
 *    For n = 10^5, max inversions = n*(n-1)/2 ≈ 5*10^9
 *    This exceeds INT_MAX (2^31 - 1 ≈ 2*10^9)
 *    So we use LONG for the count!
 */


/**
 * Related Problems:
 *
 * 1. Count of Smaller Numbers After Self (LeetCode Hard):
 *    For each element, count how many smaller elements are to its right.
 *    Same technique: Modified Merge Sort
 *
 * 2. Reverse Pairs (LeetCode Hard):
 *    Count pairs where i < j and arr[i] > 2 * arr[j]
 *    Similar approach with modified condition
 *
 * 3. Count of Range Sum (LeetCode Hard):
 *    Count subarrays with sum in [lower, upper]
 *    Uses merge sort on prefix sums
 *
 * 4. Kendall Tau Distance:
 *    Measure similarity between two rankings
 *    Inversion count between two permutations
 *
 * 5. Bubble Sort Swaps:
 *    Minimum swaps needed in bubble sort = inversion count
 */


/**
 * Real-World Applications:
 *
 * 1. Recommendation Systems:
 *    Measure how similar two users' preferences are
 *    Lower inversion count = more similar rankings
 *
 * 2. Collaborative Filtering:
 *    Find users with similar taste
 *    Compare ranking inversions
 *
 * 3. Sortedness Metric:
 *    Measure how "sorted" an array is
 *    0 inversions = fully sorted
 *    n*(n-1)/2 inversions = reverse sorted
 *
 * 4. Data Analysis:
 *    Detect anomalies in time series data
 *    High inversion count = unusual ordering
 */


/**
 * Common Mistakes:
 *
 * 1. Using INT instead of LONG:
 *    For large arrays, inversion count can exceed INT_MAX
 *    Always use LONG for the result
 *
 * 2. Forgetting to count all inversions:
 *    When L[i] > R[j], count is (n1 - i), not just 1
 *    This is THE key optimization!
 *
 * 3. Not preserving original array:
 *    If you need original array later, make a copy
 *    Our solution modifies the array in-place
 *
 * 4. Off-by-one in merge:
 *    Be careful with array indices in merge function
 *    Left subarray: [left, mid]
 *    Right subarray: [mid+1, right]
 *
 * 5. Recursion base case:
 *    When left >= right, no inversions possible
 *    Return 0 (or don't recurse at all)
 */


/**
 * Interview Tips:
 *
 * 1. Always start with brute force:
 *    Explain O(n²) solution first
 *    Shows you understand the problem
 *
 * 2. Mention time complexity:
 *    "This is too slow for n=10^5, we need O(n log n)"
 *
 * 3. Build up to merge sort:
 *    "We can use divide and conquer..."
 *    "Merge sort naturally compares elements..."
 *
 * 4. Explain the key insight:
 *    "When left[i] > right[j], all remaining left elements
 *     are also greater, so we count (n1-i) inversions"
 *
 * 5. Code cleanly:
 *    Separate mergeSort and merge functions
 *    Add comments for clarity
 */
