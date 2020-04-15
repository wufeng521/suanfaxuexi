package wufeng;

import java.util.*;
import wufeng.newclass.Info;

public class ShuJu {
    public int sumSlect(int n) {
        Vector<String> vector = new Vector<String>(5);
        Stack<String> stack=new Stack<String>();
        Queue<Integer> queue=new LinkedList<>();
        Deque<Info> deque=new LinkedList<newclass.Info>();
        Map<mantree.Info,String> map=new HashMap<>();

        return 0;
    }
    //二叉树的先序遍历的序列化
    public static String preString(mantree.Node n){
        String res;
        if(n==null)
            return "#_";
        res=n.val+"_";
        res+=preString(n.left);
        res+=preString(n.right);
        return res;
    }
    //二叉树的先序遍历的反序列化
    public static mantree.Node verPreString(Queue<String> n){
        String temp=n.poll();
        if(temp.equals("#")){  //比较两个字符串是否相等时，因为是对象，所以不能直接用==，需要用equals（）
            return null;
        }
        mantree.Node head=new mantree.Node(Integer.valueOf(temp));
        head.left=verPreString(n);
        head.right=verPreString(n);
        return head;
    }
    public static mantree.Node verPreTest(String n){
        String []newString=n.split("_");
        int num=newString.length;
        Queue<String> queue=new LinkedList<String>();
        for(int i=0;i<num;i++){
            queue.offer(newString[i]);
        }
        return verPreString(queue);
    }
    public static void main(String[] args){
        mantree.Node test=new mantree.Node(5);
        test.left=new mantree.Node(3);
        test.left.left=new mantree.Node(2);
        test.left.right=new mantree.Node(4);
//        test.left.left.left=new mantree.Node(3);
        test.left.left.right=new mantree.Node(1);
        test.right=new mantree.Node(7);
        test.right.left=new mantree.Node(6);
        test.right.right=new mantree.Node(8);
        String result=preString(test);
        System.out.println(result);
        String stringTest="1_5_9_#_#_8_#_#_9_1_#_#_8_#_#";
        mantree.Node verResult=verPreTest(stringTest);
//        mantree.printTree(test);
        mantree.printTree(verResult);
    }
}
