package com.database.jpa.hibernate.demo.datastructures.aithmetic;

import java.util.HashMap;
import java.util.Map;

public class AddingTwoFractions {
    /**
     * Left < root
     * Right >= root
     *
     *
     * #1			 3
     * 		     /  \
     *    		   1    3
     *
     * 3 -> 2
     *
     * #2			  5
     *                 /    \
     *               3      7
     *             /   \    /  \
     *            1   3  5   9
     *                       \	\
     *                        5   9
     *
     * 5->3
     * 3->2
     * 9 -> 2
     * @param args
     */

    class Node{
        Node left;
        Node right;

        int val;

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
    private static int prev = Integer.MIN_VALUE;
    private static int count = 1;

//    public static void main(String[] args) {
//        prev = Integer.MIN_VALUE;
//        Map<Integer, Integer> map = new HashMap<>();
//
//        findDuplicates(, map);
//    }

    private static void findDuplicates(Node root, Map<Integer, Integer> map){
        if(root == null) return;
        findDuplicates(root.getLeft(), map);
        if(prev == root.getVal()){
            count++;
        }
        else{
            if(count > 1){
                map.put(prev, count);
            }
            prev = root.getVal();
            count = 1;
        }
        findDuplicates(root.getRight(), map);
    }

}