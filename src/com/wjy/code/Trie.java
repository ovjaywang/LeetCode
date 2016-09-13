package com.wjy.code;

import java.util.LinkedList;
/**
 * 定义Trie树
 * @author Jay Wang
 * LeetCode 208
 *
 */
public class Trie {
	private TrieNode root;  
	   
    public Trie(){  
        root = new TrieNode(' ');  //root结点总为空
    }  
    //插入操作 涉及LinkedList的更新 count的更新
    public void insert(String word){  
        if(search(word) == true) return;     
        TrieNode current = root;   
        for(int i = 0; i < word.length(); i++){  
        	TrieNode child = current.subNode(word.charAt(i));  
            if(child != null){   
                current = child;  
            } else {  
                 current.childList.add(new TrieNode(word.charAt(i)));  
                 current = current.subNode(word.charAt(i));  
            }  
            current.count++;  
        }   
        // 标记单词结尾  
        current.isEnd = true;  
    }
    //搜索算法查找单词是否存在
    public boolean search(String word){  
    	TrieNode current = root;  
        for(int i = 0; i < word.length(); i++){      
            if(current.subNode(word.charAt(i)) == null)  
                return false;  
            else  
                current = current.subNode(word.charAt(i));  
        }  
        //意味着某字符串存在 但需要查看是否是完整的单词
        if (current.isEnd == true) return true;  
        else return false;  
    }  
      
    public void deleteWord(String word){  
        if(search(word) == false) return;  
      
        TrieNode current = root;  
        for(char c : word.toCharArray()) {   
        	TrieNode child = current.subNode(c);  
            if(child.count == 1) {  
                current.childList.remove(child);  
                return;  
            } else {  
                child.count--;  
                current = child;  
            }  
        }  
        current.isEnd = false;  
    }  
      
    public static void main(String[] args) {  
        Trie trie = new Trie();  
        trie.insert("ball");  
        trie.insert("balls");  
        trie.insert("sense");  
        trie.insert("senseof");
        // testing deletion  
        System.out.println(trie.search("balls"));  
        System.out.println(trie.search("ba"));  
        trie.deleteWord("balls");  
        System.out.println(trie.search("balls"));  
        System.out.println(trie.search("ball"));

        System.out.println(trie.search("sensef"));
        System.out.println(trie.search("senseof"));
    }
    //Tire
	public class TrieNode {  
	    char content; // 该结点存储的字符 并以此排序
	    boolean isEnd; // 是否结束的标记  
	    int count;  // 共用该结点单词数（并不是到叶子的数目 插入的时候更新）   
	    LinkedList<TrieNode> childList; // 该单词可能的下一个单词的列表 维护的是一个链表
	    
	    //结点的初始化
	    public TrieNode(char c){  
	        childList = new LinkedList<TrieNode>();  
	        isEnd = false;  
	        content = c;  
	        count = 0;  
	    }  
	    
	    //返回在LinkedList的子结点
	    public TrieNode subNode(char c){  
	        if(childList != null){  
	            for(TrieNode child : childList){  
	                if(child.content == c){  
	                     return child;  
	                }  
	            }  
	        }  
	        return null;  
	   }  
	}
}
