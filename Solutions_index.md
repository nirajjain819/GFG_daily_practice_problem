# 📋 Solutions Index

Quick reference to all solved problems in chronological order.

---

## 🔍 Filter by Difficulty

- **Easy:** 1 problem
- **Medium:** 0 problems  
- **Hard:** 1 problem

---

## 🏷️ Filter by Topic

### Binary Search (1)
- [Day 1: The Painter's Partition Problem-II](./Week1/Day01_Painters_Partition.java)

### Arrays (1)
- [Day 2: Chocolate Distribution Problem](./Week1/Day02_Chocolate_Distribution.java)

### Greedy (2)
- [Day 1: The Painter's Partition Problem-II](./Week1/Day01_Painters_Partition.java)
- [Day 2: Chocolate Distribution Problem](./Week1/Day02_Chocolate_Distribution.java)

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
**Problem:** TBD  
**Status:** ⏳ Pending

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

### 3. Two Pointers
Coming soon...

### 3. Sliding Window
Coming soon...

### 4. Dynamic Programming
Coming soon...

---

## 📈 Statistics

### Difficulty Distribution
```
Easy:    ▓▓▓▓▓░░░░░ 50%
Medium:  ░░░░░░░░░░ 0%
Hard:    ▓▓▓▓▓░░░░░ 50%
```

### Topic Distribution
```
Binary Search:  ▓▓▓▓▓░░░░░ 50%
Arrays:         ▓▓▓▓▓░░░░░ 50%
Greedy:         ▓▓▓▓▓▓▓▓▓▓ 100%
Sliding Window: ▓▓▓▓▓░░░░░ 50%
Strings:        ░░░░░░░░░░ 0%
DP:             ░░░░░░░░░░ 0%
Graphs:         ░░░░░░░░░░ 0%
```

### Streak Stats
- Current Streak: 2 days 🔥
- Longest Streak: 2 days
- Problems Solved: 2
- Success Rate: 100%

---

*Last Updated: Feb 14, 2026*
