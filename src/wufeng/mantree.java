package wufeng;

import java.util.LinkedList;
import java.util.Queue;

public class mantree {

    public static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node(int n){
            this.val=n;
        }
    }
    public static class Info{
        public int node;
        public int length;
        public Info(int n,int m){
            node=n;
            length=m;
        }
    }
    //该函数判断是否是满二叉树,该方法的递归能够计算层数和节点数目
    public  static Info process(Node n){   //递归函数有三部分信息：从子节点得到什么，本节点生成什么，本节点怎么生成
        if(n==null){
            return new Info(0,0);
        }
        Info leftData=process(n.left);
        Info rightData=process(n.right);
        int node=leftData.node+rightData.node+1;
        int length=Math.max(leftData.length,rightData.length)+1;
        return new Info(node,length);
    }
    //给定一棵树上面的两个节点，求他们的最低公共祖先
    public static class InfoCComm{
        public int node;
        public int length;
        public InfoCComm(int n,int m){
            node=n;
            length=m;
        }
    }
    //判断一棵树是否是完全二叉树
    public static boolean wanQuanTree(Node n){
        Queue<Node> queNew=new LinkedList<Node>();
        if(n==null)
            return true;
        else{
            queNew.offer(n);
            boolean isMeet=false;
            while(!queNew.isEmpty()) {
                Node temp = queNew.poll();
                if (temp.right != null && temp.left != null) {
                    queNew.offer(temp.left);
                    queNew.offer(temp.right);
                }
                if ((isMeet && (temp.left != null || temp.right != null)) ||
                        temp.left == null && temp.right != null)
                    return false;
                if (temp.left != null && temp.right == null) {
                    isMeet = true;
                    queNew.offer(temp.left);
                }
            }
        }
        return true;
    }
    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    //
    public static void main(String[] args){
        Node test=new Node(5);
        test.left=new Node(3);
        test.left.left=new Node(2);
        test.left.right=new Node(4);
        test.left.left.left=new Node(3);
        test.left.left.right=new Node(1);
        test.right=new Node(7);
        test.right.left=new Node(6);
        test.right.right=new Node(8);
        boolean result=wanQuanTree(test);
        System.out.println(result);
        /*Info result=process(test);
        if(result.node==(Math.pow(2,result.length)-1))//(1>>result.length)就是等于2^n结果
            System.out.println(true);
        else
            System.out.println(false);*/
        printTree(test);
    }
}

