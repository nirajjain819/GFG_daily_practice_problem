# 📋 Solutions Index

Quick reference to all solved problems in chronological order.

---

## 🔍 Filter by Difficulty

- **Easy:** 2 problems
- **Medium:** 1 problem  
- **Hard:** 2 problems

---

## 🏷️ Filter by Topic

### Binary Search (1)
- [Day 1: The Painter's Partition Problem-II](./Week1/Day01_Painters_Partition.java)

### Arrays (5)
- [Day 1: The Painter's Partition Problem-II](./Week1/Day01_Painters_Partition.java)
- [Day 2: Chocolate Distribution Problem](./Week1/Day02_Chocolate_Distribution.java)
- [Day 3: Meeting Rooms](./Week1/Day03_Meeting_Rooms.java)
- [Day 4: Maximum Overlapping Intervals](./Week1/Day04_Maximum_Overlapping_Intervals.java)
- [Day 5: Count Inversions](./Week1/Day05_Count_Inversions.java)

### Merge Sort (1)
- [Day 5: Count Inversions](./Week1/Day05_Count_Inversions.java)

### Divide and Conquer (1)
- [Day 5: Count Inversions](./Week1/Day05_Count_Inversions.java)

### Intervals (2)
- [Day 3: Meeting Rooms](./Week1/Day03_Meeting_Rooms.java)
- [Day 4: Maximum Overlapping Intervals](./Week1/Day04_Maximum_Overlapping_Intervals.java)

### Two Pointer (1)
- [Day 4: Maximum Overlapping Intervals](./Week1/Day04_Maximum_Overlapping_Intervals.java)

### Sweep Line (1)
- [Day 4: Maximum Overlapping Intervals](./Week1/Day04_Maximum_Overlapping_Intervals.java)

### Sliding Window (1)
- [Day 2: Chocolate Distribution Problem](./Week1/Day02_Chocolate_Distribution.java)

### Strings (0)
- Coming soon...

### Dynamic Programming (0)
- Coming soon...

### Graphs (0)
- Coming soon...

### Trees (0)
- Coming soon...

---

## 📅 All Solutions (Chronological)

### Week 1: Feb 13-19, 2026

#### Day 1 - Feb 13, 2026
**Problem:** [The Painter's Partition Problem-II](https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1)  
**Difficulty:** Hard 🔥  
**Topics:** Binary Search, Greedy, Array  
**Key Pattern:** Binary Search on Answer Space  
**Solution:** [View Code](./Week1/Day01_Painters_Partition.java)  
**Status:** ✅ Solved

**Quick Summary:**  
Allocate boards to k painters minimizing maximum time. Used binary search on answer range [max(arr), sum(arr)] and greedy validation.

**Complexity:**
- Time: O(n * log(sum of array))
- Space: O(1)

---

#### Day 2 - Feb 14, 2026
**Problem:** [Chocolate Distribution Problem](https://www.geeksforgeeks.org/problems/chocolate-distribution-problem/1)  
**Difficulty:** Easy ✅  
**Topics:** Arrays, Greedy, Sliding Window, Sorting  
**Key Pattern:** Sort + Sliding Window  
**Solution:** [View Code](./Week1/Day02_Chocolate_Distribution.java)  
**Status:** ✅ Solved

**Quick Summary:**  
Distribute chocolate packets to m students minimizing difference between max and min chocolates. Sort array, use sliding window of size m to find minimum difference.

**Complexity:**
- Time: O(n log n) - dominated by sorting
- Space: O(1)

**Test Results:**
- ✅ 1112/1112 test cases passed
- ✅ 100% accuracy
- ✅ Time: 0.9 seconds

---

#### Day 3 - Feb 15, 2026
**Problem:** [Meeting Rooms](https://www.geeksforgeeks.org/problems/meeting-rooms/1)  
**Difficulty:** Easy ✅  
**Topics:** Arrays, Sorting, Intervals, Greedy  
**Key Pattern:** Interval Scheduling  
**Solution:** [View Code](./Week1/Day03_Meeting_Rooms.java)  
**Status:** ✅ Solved

**Quick Summary:**  
Check if one person can attend all meetings given their time intervals. Sort by start time, then check if consecutive meetings overlap.

**Complexity:**
- Time: O(n log n) - dominated by sorting
- Space: O(1)

**Test Results:**
- ✅ 1111/1111 test cases passed
- ✅ 100% accuracy
- ✅ Time: 0.39 seconds
- ✅ Points: 2/2

---

#### Day 4 - Feb 16, 2026
**Problem:** [Maximum Overlapping Intervals](https://www.geeksforgeeks.org/problems/maximum-number-of-overlapping-intervals/1)  
**Difficulty:** Hard 🔥  
**Topics:** Arrays, Sorting, Two Pointer, Sweep Line, Intervals  
**Key Pattern:** Two Pointer on Sorted Start/End Arrays  
**Solution:** [View Code](./Week1/Day04_Maximum_Overlapping_Intervals.java)  
**Status:** ✅ Solved

**Quick Summary:**  
Find maximum intervals overlapping at any point. Three approaches covered: Brute Force O(n²), Sweep Line O(n log n), Two Pointer O(n log n). Optimal: separate and sort start/end arrays, use two pointers to simulate meeting room bookings.

**Complexity:**
- Time: O(n log n) - dominated by sorting
- Space: O(n) - start[] and end[] arrays

**Test Results:**
- ✅ 1115/1115 test cases passed
- ✅ 100% accuracy
- ✅ Time: 0.66 seconds
- ✅ Points: 8/8
- ✅ Total Score: 126

**Key Insight:** Start = meeting begins (overlap++), End = meeting ends (overlap--)

---

#### Day 5 - Feb 17, 2026
**Problem:** [Count Inversions](https://www.geeksforgeeks.org/problems/inversion-of-array/1)  
**Difficulty:** Medium 🟡  
**Topics:** Arrays, Merge Sort, Divide and Conquer  
**Key Pattern:** Modified Merge Sort  
**Solution:** [View Code](./Week1/Day05_Count_Inversions.java)  
**Status:** ✅ Solved

**Quick Summary:**  
Count pairs (i, j) where i < j and arr[i] > arr[j]. Classic problem solved with modified merge sort. Key insight: when merging, if left[i] > right[j], all remaining elements in left subarray form inversions with right[j]. Count them all at once: (mid - i + 1).

**Complexity:**
- Time: O(n log n) - merge sort
- Space: O(n) - temporary arrays

**Test Results:**
- ✅ 1115/1115 test cases passed
- ✅ 100% accuracy
- ✅ Time: 0.77 seconds
- ✅ Points: 4/4
- ✅ Total Score: 130

**Key Insight:** Divide & Conquer - count inversions in left, right, and across during merge.

---

#### Day 6 - Feb 18, 2026
**Problem:** TBD  
**Status:** ⏳ Pending

---

#### Day 7 - Feb 19, 2026
**Problem:** TBD  
**Status:** ⏳ Pending

---

### Week 2: Feb 20-26, 2026
Coming soon...

---

### Week 3: Feb 27-Mar 5, 2026
Coming soon...

---

### Week 4: Mar 6-12, 2026
Coming soon...

---

### Week 5: Mar 13-19, 2026
Coming soon...

---

### Week 6: Mar 20-26, 2026
Coming soon...

---

### Week 7: Mar 27-Apr 2, 2026
Coming soon...

---

### Week 8: Apr 3-9, 2026
Coming soon...

---

### Week 9: Apr 10-13, 2026
Coming soon...

---

## 🎯 Pattern Recognition Guide

Problems I've encountered organized by common patterns:

### 1. Binary Search on Answer
**When to use:** Problem asks to minimize maximum or maximize minimum value.

**Problems:**
- Day 1: Painter's Partition
- More coming...

**Template:**
```java
int binarySearchOnAnswer(int[] arr, int k) {
    int low = max(arr);
    int high = sum(arr);
    int result = high;
    
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (isPossible(arr, k, mid)) {
            result = mid;
            high = mid - 1; // Try for smaller value
        } else {
            low = mid + 1;
        }
    }
    return result;
}
```

### 2. Greedy + Sliding Window
**When to use:** When you need to find optimal contiguous subarray/subset after sorting.

**Problems:**
- Day 2: Chocolate Distribution
- More coming...

**Template:**
```java
Collections.sort(arr);  // Greedy: sort first
int result = Integer.MAX_VALUE;

for (int i = 0; i <= n - windowSize; i++) {
    // Sliding window
    int diff = arr.get(i + windowSize - 1) - arr.get(i);
    result = Math.min(result, diff);
}
```

### 3. Interval Scheduling
**When to use:** Problems involving time intervals, meeting scheduling, or overlapping ranges.

**Problems:**
- Day 3: Meeting Rooms
- More coming...

**Template:**
```java
// Sort intervals by start time
Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

// Check consecutive intervals for overlap
for (int i = 0; i < n-1; i++) {
    if (intervals[i][1] > intervals[i+1][0]) {
        // Overlap found
        return false;
    }
}
return true;  // No overlaps
```

### 4. Two Pointers
Coming soon...

### 3. Sliding Window
Coming soon...

### 4. Dynamic Programming
Coming soon...

---

## 📈 Statistics

### Difficulty Distribution
```
Easy:    ▓▓▓▓░░░░░░ 40%
Medium:  ▓▓░░░░░░░░ 20%
Hard:    ▓▓▓▓░░░░░░ 40%
```

### Topic Distribution
```
Arrays:           ▓▓▓▓▓▓▓▓▓▓ 100%
Greedy:           ▓▓▓▓▓░░░░░ 60%
Sorting:          ▓▓▓▓▓▓▓▓░░ 80%
Intervals:        ▓▓▓▓░░░░░░ 40%
Binary Search:    ▓▓░░░░░░░░ 20%
Two Pointer:      ▓▓░░░░░░░░ 20%
Sweep Line:       ▓▓░░░░░░░░ 20%
Sliding Window:   ▓▓░░░░░░░░ 20%
Merge Sort:       ▓▓░░░░░░░░ 20%
Divide & Conquer: ▓▓░░░░░░░░ 20%
Strings:          ░░░░░░░░░░ 0%
DP:               ░░░░░░░░░░ 0%
```

### Streak Stats
- Current Streak: 5 days 🔥
- Longest Streak: 5 days
- Problems Solved: 5
- Easy: 2 | Medium: 1 | Hard: 2
- Success Rate: 100%
- Total Score: 130

---

*Last Updated: Feb 17, 2026*
