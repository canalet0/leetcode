package com.rcanal.q215;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {

    /*
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     * 
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * 
     * Can you solve it without sorting?
     * 
     * Example 1:
     *
     * Input: nums = [3,2,1,5,6,4], k = 2
     * Output: 5
     * 
     * Example 2:
     * 
     * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     * Output: 4
     */

    public static void main(String[] args) {
        int[] nums =  {3,2,1,5,6,4};
        int k = 2;
        int expected = 0;
        var solution = new Solution();
        var actual = solution.findKthLargest(nums, k);

        assertEquals(expected, actual);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        
        return minHeap.peek();
    }
    
}
