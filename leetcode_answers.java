/* Binary Search Trees */ 

// 108: Convert Sorted Array to BST
// recursion to build a sorted tree
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }
    public TreeNode sort(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sort(nums, left, mid - 1);
        node.right = sort(nums, mid + 1, right);

        return node;
    }
}

// 501: Find Mode in BST
// Traverse the tree using iteration of all nodes
class Solution {
    public int[] findMode(TreeNode root) {
        int maxCount = 0;
        int currCount = 0;
        int currNum = 0;
        List<Integer> value = new ArrayList();

        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode neighbor = node.left;
                while (neighbor.right != null) {
                    neighbor = neighbor.right;
                }
                neighbor.right = node;
                TreeNode left = node.left;
                node.left = null;
                node = left;
            } else {
                int num = node.val;
                if (num == currNum) {
                    currCount++;
                } else {
                    currCount = 1;
                    currNum = num;
                }
                if (currCount > maxCount) {
                    value = new ArrayList();
                    maxCount = currCount;
                }
                if (currCount == maxCount) {
                    value.add(num);
                }
                node = node.right;
            }
        }
        int[] result = new int[value.size()];
        for (int i = 0; i < value.size(); i++) {
            result[i] = value.get(i);
        }
        return result;
    }
}

// 700: Search in BST
// Uses recursion to compare values in a tree
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}

// 938: Range Sum of BST
// Recursion to sum of values of given nodes
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0; 
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        } 
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}

/* Hashing */

// 1: Two Sum
// Uses a HashMap to get numbers that add to a target
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}

// 13: Roman to Integer
// Creates a HashMap for each roman values to add
class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                result -= roman.get(s.charAt(i));
            } else {
                result += roman.get(s.charAt(i));
            }
        }
    return result + roman.get(s.charAt(s.length() - 1));
    }
}

// 141: Linked List Cycle
// Uses a HashSet to see if the same node has been reached
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<ListNode> visited = new HashSet<>();

        ListNode current = head;
        while (current != null) {
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        } 
        return false;
    }
}

// 268: Missing Number
// Maps indices to values then iterates to find the missing mismatch
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (!entry.getKey().equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return nums.length;
    }
}