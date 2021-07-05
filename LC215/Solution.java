// https://leetcode.com/problems/kth-largest-element-in-an-array/ 

//O(logN) solution using Priority Queue
//Yes, you can also just sort...
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++){
            queue.add(nums[i]);
        }
        while (queue.size() != k){
            queue.poll();
        }
        return queue.peek();
    }
}
