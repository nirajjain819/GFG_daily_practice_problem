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
 */
class Solution {
    private int check(int md, int[] arr) {
        int n = arr.length;
        int sm = 0;
        int k = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > md) return Integer.MAX_VALUE;
            sm += arr[i];
            if (sm > md) {
                k++;
                sm = arr[i];
            }
        }
        return k;
    }
    public int minTime(int[] arr, int k) {
        int l = 1;
        int h = 10000000;
        int ans = -1;
        while (l <= h) {
            int md = l + (h - l) / 2;
            int paintersNeeded = check(md, arr);
            if (k >= paintersNeeded) {
                ans = md;
                h = md - 1;
            } else {
                l = md + 1;
            }
        }
        return ans;
    }
}