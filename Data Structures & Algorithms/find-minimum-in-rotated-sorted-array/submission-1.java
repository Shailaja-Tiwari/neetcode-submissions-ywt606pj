class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                // min is in right half
                l = mid + 1;
            } else {
                // min is in left half (or mid itself)
                r = mid;
            }
        }

        return nums[l];
    }
}