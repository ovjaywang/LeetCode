package com.wjy.code;

import java.util.LinkedList;
/**
 * ����Trie��
 * @author Administrator
 *
 */
public class Trie {
	private TrieNode root;  
	   
    public Trie(){  
        root = new TrieNode(' ');  //root�����Ϊ��
    }  
    //������� �漰LinkedList�ĸ��� count�ĸ���
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
        // ��ǵ��ʽ�β  
        current.isEnd = true;  
    }
    //�����㷨���ҵ����Ƿ����
    public boolean search(String word){  
    	TrieNode current = root;  
        for(int i = 0; i < word.length(); i++){      
            if(current.subNode(word.charAt(i)) == null)  
                return false;  
            else  
                current = current.subNode(word.charAt(i));  
        }  
        //��ζ��ĳ�ַ������� ����Ҫ�鿴�Ƿ��������ĵ���
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
      
        // testing deletion  
        System.out.println(trie.search("balls"));  
        System.out.println(trie.search("ba"));  
        trie.deleteWord("balls");  
        System.out.println(trie.search("balls"));  
        System.out.println(trie.search("ball"));  
    }
    //Tire
	public class TrieNode {  
	    char content; // �ý��洢���ַ� ���Դ�����
	    boolean isEnd; // �Ƿ�����ı��  
	    int count;  // ���øý�㵥�����������ǵ�Ҷ�ӵ���Ŀ �����ʱ����£�   
	    LinkedList<TrieNode> childList; // �õ��ʿ��ܵ���һ�����ʵ��б� ά������һ������
	    
	    //���ĳ�ʼ��
	    public TrieNode(char c){  
	        childList = new LinkedList<TrieNode>();  
	        isEnd = false;  
	        content = c;  
	        count = 0;  
	    }  
	    
	    //������LinkedList���ӽ��
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
