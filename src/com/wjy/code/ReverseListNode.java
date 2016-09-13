package com.wjy.code;

public class ReverseListNode {
	 private static  class ListNode {
		    int val;
		    ListNode next;
		    ListNode(int x) { this.val = x; }
		  }
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head ==null) return null;
        if(m==n) return head;
        if(head.next == null) return head;
        ListNode now = head;
        int count =0;
        ListNode first = head;
        while(count<(m-1)){
            first = now;
            now = now.next;
            count++;
        }
        System.out.println("当前now的值"+now.val);
        ListNode second = null,third=null,pre=now;
        
        while(++count<n){
            second = now.next;//找到后继
            third = now.next.next;//找到后孙
            System.out.println("当前值 后继，孙子"+now.val+" "+second.val+" "+third.val);
            if(third==null) break;
            now.next = third;//当前值后继改变
            second.next = pre;//后继变头
            pre = second;//更新头
            System.out.println("Pre :"+pre.val);
        }
        //now.next.next = pre;
        first.next = pre;
        //now.next = third;

        while(first!=null){	
            System.out.print(first.val+" ");
            first = first.next;
        }
        return head;
    }
	public static void main(String[] args) {
		ReverseListNode rln = new ReverseListNode();
		ListNode node5 = new ListNode(5);
//		ListNode node4 = new ListNode(4);
//		ListNode node3 = new ListNode(3);
//		ListNode node2 = new ListNode(2);
//		ListNode node1 = new ListNode(1);
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
		node5.next =null;
		rln.reverseBetween(node5, 1, 1);
	}
}
