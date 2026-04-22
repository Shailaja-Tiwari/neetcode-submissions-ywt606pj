class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            // found it!
            if (nums[mid] == target) return mid;

            // left side is sorted
            if (nums[l] <= nums[mid]) {
                // target is in left side
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;  // go left
                } else {
                    l = mid + 1;  // go right
                }
            }
            // right side is sorted
            else {
                // target is in right side
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;  // go right
                } else {
                    r = mid - 1;  // go left
                }
            }
        }

        return -1;
    }
}
