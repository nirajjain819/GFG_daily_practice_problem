/**
 * GFG 60-Day Streak Challenge - Day 4
 * Date: February 16, 2026
 *
 * Problem: Maximum number of overlapping Intervals
 * Difficulty: Hard
 * Link: https://www.geeksforgeeks.org/problems/maximum-number-of-overlapping-intervals/1
 *
 * Topics: Arrays, Sorting, Intervals, Two Pointer, Sweep Line
 * Pattern: Interval Overlap + Two Pointer / Sweep Line
 *
 * Problem Statement:
 * Given an array of intervals arr[][] where each interval is represented
 * by [start, end] (inclusive), return the maximum number of intervals
 * that overlap at any point in time.
 *
 * Test Results:
 * ✅ Test Cases Passed: 1115/1115
 * ✅ Accuracy: 100%
 * ✅ Time: 0.66 seconds
 * ✅ Points: 8/8
 * ✅ Total Score: 126
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
 * Idea: For every start point, count how many intervals contain it.
 * Check each interval's start against all other intervals.
 *
 * Steps:
 * 1. For each interval i, count how many intervals j overlap with it
 *    (where start[j] <= start[i] <= end[j])
 * 2. Track maximum count found
 *
 * Drawback: O(n²) - Times out for large inputs
 * Use only for small inputs or understanding the problem
 */
class SolutionBruteForce {
    public static int overlapInt(int[][] arr) {
        int n = arr.length;
        int maxOverlap = 0;

        // Check every interval's start point
        for (int i = 0; i < n; i++) {
            int count = 0;
            int point = arr[i][0]; // Use start of interval i as check point

            // Count how many intervals contain this point
            for (int j = 0; j < n; j++) {
                if (arr[j][0] <= point && point <= arr[j][1]) {
                    count++;
                }
            }

            maxOverlap = Math.max(maxOverlap, count);
        }

        return maxOverlap;
    }
}
// Time:  O(n²) - nested loops
// Space: O(1)  - no extra space


// =====================================================================
// APPROACH 2: BETTER - SWEEP LINE WITH EVENTS
// Time: O(n log n) | Space: O(n)
// =====================================================================
/**
 * Sweep Line Approach:
 *
 * Idea: Create events for each start (+1) and end (-1).
 * Sort events by time. Sweep through counting active intervals.
 *
 * Steps:
 * 1. Create events: (time, type) where type is +1 for start, -1 for end
 * 2. Sort events by time (if tie, process starts before ends)
 * 3. Sweep through events, tracking current overlap count
 * 4. Return maximum count
 *
 * Better than brute force! But uses extra space.
 */
class SolutionSweepLine {
    public static int overlapInt(int[][] arr) {
        int n = arr.length;

        // Create events list: [time, type]
        // type: +1 for start, -1 for end
        int[][] events = new int[2 * n][2];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            events[idx++] = new int[]{arr[i][0], 1};   // Start event
            events[idx++] = new int[]{arr[i][1], -1};  // End event
        }

        // Sort by time; if same time, start (+1) before end (-1)
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // Sort by time
            return b[1] - a[1]; // If same time, start before end
        });

        // Sweep through events
        int overlap = 0;
        int maxOverlap = 0;

        for (int[] event : events) {
            overlap += event[1]; // +1 for start, -1 for end
            maxOverlap = Math.max(maxOverlap, overlap);
        }

        return maxOverlap;
    }
}
// Time:  O(n log n) - sorting events
// Space: O(n)       - events array


// =====================================================================
// APPROACH 3: OPTIMAL - TWO POINTER ON SORTED ARRAYS
// Time: O(n log n) | Space: O(n)
// =====================================================================
/**
 * Two Pointer Approach (Optimal - Clean Implementation):
 *
 * Key Insight:
 * Think of intervals as meeting room bookings:
 * - When a meeting starts → need one more room (overlap++)
 * - When a meeting ends → free one room (overlap--)
 * - Maximum rooms needed = maximum overlapping intervals
 *
 * Steps:
 * 1. Separate start[] and end[] times from intervals
 * 2. Sort both arrays independently
 * 3. Use two pointers i (on start[]) and j (on end[])
 * 4. If start[i] <= end[j]: New meeting started (overlap++, i++)
 *    Else: Meeting ended (overlap--, j++)
 * 5. Track maximum overlap throughout
 *
 * Why this works:
 * By sorting starts and ends separately, we know the chronological
 * order of all start and end events. Two pointers efficiently simulate
 * the sweep line without creating explicit event objects.
 */
class Solution {
    public static int overlapInt(int[][] arr) {
        int n = arr.length;

        // Step 1: Separate start and end times
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < arr.length; i++) {
            start[i] = arr[i][0]; // Extract start times
            end[i] = arr[i][1];   // Extract end times
        }

        // Step 2: Sort both arrays independently
        Arrays.sort(start); // All start times in order
        Arrays.sort(end);   // All end times in order

        // Step 3: Two pointer sweep
        int i = 0;           // Pointer for start array (next meeting to start)
        int j = 0;           // Pointer for end array (next meeting to end)
        int overlap = 0;     // Current number of overlapping intervals
        int maxOverlap = 0;  // Maximum overlap seen so far

        // Process all events
        while (i < start.length && j < end.length) {
            if (start[i] <= end[j]) {
                // A new interval starts before/when another ends
                // → One more overlap
                overlap++;
                maxOverlap = Math.max(overlap, maxOverlap);
                i++; // Move to next start time
            } else {
                // An interval ended before next one starts
                // → One less overlap
                overlap--;
                j++; // Move to next end time
            }
        }

        return maxOverlap;
    }
}
// Time:  O(n log n) - dominated by sorting
// Space: O(n)       - start[] and end[] arrays


/**
 * Example Walkthrough (Optimal Approach):
 *
 * Input: [[1,8], [2,5], [5,6], [3,7]]
 *
 * Step 1: Extract
 * start[] = [1, 2, 5, 3]
 * end[]   = [8, 5, 6, 7]
 *
 * Step 2: Sort
 * start[] = [1, 2, 3, 5]
 * end[]   = [5, 6, 7, 8]
 *
 * Step 3: Two Pointer
 * i=0, j=0: start[0]=1 <= end[0]=5 → overlap=1, maxOverlap=1, i=1
 * i=1, j=0: start[1]=2 <= end[0]=5 → overlap=2, maxOverlap=2, i=2
 * i=2, j=0: start[2]=3 <= end[0]=5 → overlap=3, maxOverlap=3, i=3
 * i=3, j=0: start[3]=5 <= end[0]=5 → overlap=4, maxOverlap=4, i=4
 * i=4: Loop ends (i >= start.length)
 *
 * Result: 4 ✅
 *
 * Input: [[1,2], [2,4], [3,6]]
 *
 * start[] = [1, 2, 3]
 * end[]   = [2, 4, 6]
 *
 * i=0, j=0: start[0]=1 <= end[0]=2 → overlap=1, max=1, i=1
 * i=1, j=0: start[1]=2 <= end[0]=2 → overlap=2, max=2, i=2
 * i=2, j=0: start[2]=3 > end[0]=2  → overlap=1, j=1
 * i=2, j=1: start[2]=3 <= end[1]=4 → overlap=2, max=2, i=3
 * i=3: Loop ends
 *
 * Result: 2 ✅
 */


/**
 * Complexity Comparison:
 *
 * ┌────────────────┬────────────┬────────────┐
 * │ Approach       │ Time       │ Space      │
 * ├────────────────┼────────────┼────────────┤
 * │ Brute Force    │ O(n²)      │ O(1)       │
 * │ Sweep Line     │ O(n log n) │ O(n)       │
 * │ Two Pointer    │ O(n log n) │ O(n)       │
 * └────────────────┴────────────┴────────────┘
 *
 * Two Pointer is preferred:
 * - Same time complexity as Sweep Line
 * - Cleaner code
 * - Easier to understand
 * - No extra event objects created
 */


/**
 * Key Learnings:
 *
 * 1. Meeting Room Analogy:
 *    Think of intervals as meeting bookings.
 *    Start = someone enters, End = someone leaves.
 *    Max people at once = max overlapping intervals.
 *
 * 2. Separate Arrays Trick:
 *    Sorting start[] and end[] separately is more efficient
 *    than sorting interval pairs and then processing.
 *
 * 3. Two Pointer on Different Arrays:
 *    Two pointers don't always work on the SAME array.
 *    Here, they work on two DIFFERENT sorted arrays.
 *
 * 4. Sweep Line Pattern:
 *    Useful for any problem where you need to track
 *    "how many active events at any point in time"
 *
 * 5. Comparing Approaches:
 *    Always think brute force → better → optimal
 *    Understand WHY each step improves the previous.
 */


/**
 * Related Problems:
 *
 * 1. Meeting Rooms (Easy) - Day 3:
 *    Can one person attend all meetings?
 *    This is the simpler version of today's problem
 *
 * 2. Meeting Rooms II (Medium):
 *    Find minimum meeting rooms required
 *    Essentially the same as today's problem!
 *
 * 3. Minimum Platforms (Medium):
 *    Train station problem - same concept
 *    Minimum platforms = maximum overlapping trains
 *
 * 4. Employee Free Time (Hard):
 *    Find time slots when all employees are free
 *    Uses similar interval merging techniques
 *
 * 5. Car Pooling (Medium):
 *    Maximum passengers at any point
 *    Sweep line on pickup/dropoff events
 */


/**
 * Common Mistakes:
 *
 * 1. Sorting intervals together (not separately):
 *    If you sort intervals by start time, you lose the ability
 *    to efficiently find the next end time.
 *    SOLUTION: Separate start[] and end[], sort independently.
 *
 * 2. Off-by-one in overlap condition:
 *    Problem says intervals are inclusive [start, end]
 *    So start[i] == end[j] still means overlap!
 *    Use <= not <
 *
 * 3. Not tracking maxOverlap inside loop:
 *    You must update maxOverlap at every step, not just at end.
 *    The maximum might occur at any intermediate point.
 *
 * 4. Jumping to optimal without understanding brute force:
 *    Always understand the naive approach first.
 *    It helps verify correctness of optimal solution.
 */
