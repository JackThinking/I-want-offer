package nowcoder;

import structure.TreeNode;

import java.util.Stack;

/**
 * Created by Citrix on 2019-04-24.
 */
public class TreeNodeOrderRecur {
    /*
     * 前序遍历递归版
     * */
    public void preOrderRecur(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val + " ");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    /*
     * 中序遍历递归版
     * */
    public void inOrderRecur(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrderRecur(node.left);
        System.out.println(node.val + " ");
        preOrderRecur(node.right);
    }

    /*
     * 后序遍历递归版
     * */
    public void posOrderRecur(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrderRecur(node.left);
        preOrderRecur(node.right);
        System.out.println(node.val + " ");
    }

    /*
     * 前序遍历非递归版，与bfs是不一样的，是向放右边的，再放左边的
     * */
    public static void preOrderRecur2(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.val + " ");
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    /*
     * 中序遍历非递归版
     * */
    public static void inOrderRecur2(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    System.out.println(node.val + " ");
                    node = node.right;
                }
            }
        }
    }

    /*
     * 后序遍历非递归版
     * */
    public static void posOrderRecur2(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(node);
            while (!stack1.isEmpty()) {
                node = stack1.pop();
                stack2.push(node);
                if (node.left != null) {
                    stack1.push(node.left);
                }
                if (node.right != null) {
                    stack1.push(node.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().val + " ");
            }
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(1);
        head.right = new TreeNode(5);
        preOrderRecur2(head);
    }
}
