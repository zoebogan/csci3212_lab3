//Uses a Hash Set to see if the same node has been reached 
public class Solution141 {
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
}