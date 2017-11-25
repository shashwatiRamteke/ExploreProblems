package com.dsproblems.tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class storeVisitedWebSite {
    public static class TrieNode{
        HashMap<Character, TrieNode> children;
        boolean endOFWord;

        public TrieNode()
        {
            children = new HashMap<>();
            endOFWord = false;
        }
    }

    public static void buildIfNotPresent(TrieNode rootNode, String word)
    {

        boolean isNew = false;
        TrieNode currNode = rootNode;
        for(int i=0;i < word.length();i++)
        {
            if(currNode.children.containsKey(word.charAt(i))){
                currNode = currNode.children.get(word.charAt(i));
            }else {
                currNode.children.put(word.charAt(i),new TrieNode());
                currNode = currNode.children.get(word.charAt(i));
                isNew = true;
            }
        }
        if(isNew)
        {
            currNode.endOFWord = true;
        }

    }

    public static void printTree(TrieNode rootNode)
    {
        if(rootNode.endOFWord)
        {
            return;
        }else
        {
            for(Map.Entry<Character,TrieNode> trieNode : rootNode.children.entrySet())
            {
                System.out.println(trieNode.getKey());
                printTree(trieNode.getValue());
            }
        }
    }

    public static void main(String[] args) {
        boolean continueYesNo = true;
        TrieNode rootNode  = new TrieNode();;
        while(continueYesNo) {
            Scanner in = new Scanner(System.in);
            String str = in.next();
            buildIfNotPresent(rootNode,str);
            System.out.println("want to enter more words");
            continueYesNo = in.nextBoolean();
        }
        printTree(rootNode);
    }
}
