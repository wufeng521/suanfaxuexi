package wufeng;

import java.sql.Array;
import java.lang.*;

public  class newclass {

    public static class Node{
        public int val;
        public Node left;
        public Node rigth;
        Node(int n){
            this.val=n;
        }
    }
    public static class Info{
        public boolean isBST;
        public int max;
        public int min;
        public Info(boolean is,int max,int min){
            this.isBST=is;
            this.max=max;
            this.min=min;
        }
    }
    public static Info process(Node x){
        if(x==null)
            return null;
        int max1=x.val;
        int min1=x.val;
        Info leftData=process(x.left);
        Info rightData=process(x.rigth);
        if(leftData!=null){
            max1=Math.max(leftData.max,x.val);
            min1=Math.min(leftData.min,x.val);
        }
        if(rightData!=null){
            max1=Math.max(rightData.max,x.val);
            min1=Math.min(rightData.min,x.val);
        }
        boolean isBST1=false;
        if(
                (leftData!=null?(leftData.max<x.val):true)
                &&(rightData!=null?(rightData.min>x.val):true)
        )
            isBST1=true;
        return new Info(isBST1,max1,min1);
    }
    public static void main(String[] args){
        Node test=new Node(5);
        test.left=new Node(3);
        test.left.left=new Node(2);
        test.left.rigth=new Node(4);
        test.left.left.left=new Node(1);
        test.rigth=new Node(7);
        test.rigth.left=new Node(6);
        test.rigth.rigth=new Node(8);
        Info result=process(test);
        System.out.println(result.isBST);
    }
}

