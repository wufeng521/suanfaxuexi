package wufeng;

import java.util.ArrayList;
import java.util.HashMap;

public class TrieTree implements Talking{
    @Override
    public void eat() {

    }

    public static class TrieNode{
        public int pass;
        public int end;
        HashMap<Character,TrieNode> nexts;
    }
    public static int testList(ArrayList<Integer> n){
        ArrayList<Integer> num=new ArrayList<Integer>();
        num.add(5);
        num.add(4);
        return 0;
    }
}
