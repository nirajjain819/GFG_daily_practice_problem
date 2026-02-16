# 📋 Solutions Index

Quick reference to all solved problems in chronological order.

---

## 🔍 Filter by Difficulty

- **Easy:** 2 problems
- **Medium:** 0 problems  
- **Hard:** 1 problem

---

## 🏷️ Filter by Topic

### Binary Search (1)
- [Day 1: The Painter's Partition Problem-II](./Week1/Day01_Painters_Partition.java)

### Arrays (3)
- [Day 1: The Painter's Partition Problem-II](./Week1/Day01_Painters_Partition.java)
- [Day 2: Chocolate Distribution Problem](./Week1/Day02_Chocolate_Distribution.java)
- [Day 3: Meeting Rooms](./Week1/Day03_Meeting_Rooms.java)

### Greedy (3)
- [Day 1: The Painter's Partition Problem-II](./Week1/Day01_Painters_Partition.java)
- [Day 2: Chocolate Distribution Problem](./Week1/Day02_Chocolate_Distribution.java)
- [Day 3: Meeting Rooms](./Week1/Day03_Meeting_Rooms.java)

### Sorting (2)
- [Day 2: Chocolate Distribution Problem](./Week1/Day02_Chocolate_Distribution.java)
- [Day 3: Meeting Rooms](./Week1/Day03_Meeting_Rooms.java)

### Intervals (1)
- [Day 3: Meeting Rooms](./Week1/Day03_Meeting_Rooms.java)

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
**Problem:** TBD  
**Status:** ⏳ Pending

---

#### Day 5 - Feb 17, 2026
**Problem:** TBD  
**Status:** ⏳ Pending

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
Easy:    ▓▓▓▓▓▓▓░░░ 67%
Medium:  ░░░░░░░░░░ 0%
Hard:    ▓▓▓░░░░░░░ 33%
```

### Topic Distribution
```
Arrays:         ▓▓▓▓▓▓▓▓▓▓ 100%
Binary Search:  ▓▓▓░░░░░░░ 33%
Greedy:         ▓▓▓▓▓▓▓▓▓▓ 100%
Sorting:        ▓▓▓▓▓▓▓░░░ 67%
Intervals:      ▓▓▓░░░░░░░ 33%
Sliding Window: ▓▓▓░░░░░░░ 33%
Strings:        ░░░░░░░░░░ 0%
DP:             ░░░░░░░░░░ 0%
Graphs:         ░░░░░░░░░░ 0%
```

### Streak Stats
- Current Streak: 3 days 🔥
- Longest Streak: 3 days
- Problems Solved: 3
- Success Rate: 100%

---

*Last Updated: Feb 15, 2026*
