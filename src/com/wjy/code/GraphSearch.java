package com.wjy.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
/**
 * ����ͼ ��ȱ����͹�ȱ���
 * @author Jay Wang
 *
 */
public class GraphSearch {
	public static void main(String args[]){  
        //������Ҫ�����  
        NodeT a=new NodeT("a");  
        NodeT b=new NodeT("b");  
        NodeT c=new NodeT("c");  
        NodeT d=new NodeT("d");  
        NodeT e=new NodeT("e");  
        NodeT f=new NodeT("f");  
        NodeT g=new NodeT("g");  
        NodeT h=new NodeT("h");  
        ArcT ab=new ArcT(a,b);  
        ArcT ac=new ArcT(a,c);  
        ArcT ad=new ArcT(a,d);  
        ArcT ah=new ArcT(a,h);  
        ArcT bc=new ArcT(b,c);  
        ArcT de=new ArcT(d,e);  
        ArcT ef=new ArcT(e,f);  
        ArcT eg=new ArcT(e,g);  
        ArcT hg=new ArcT(h,g);  
  
        //�������ǵĹ�ϵ  
        a.outgoing.add(ab);  
        a.outgoing.add(ac);  
        a.outgoing.add(ad);  
        a.outgoing.add(ah);  
        b.outgoing.add(bc);  
        d.outgoing.add(de);  
        e.outgoing.add(ef);  
        e.outgoing.add(eg);  
        h.outgoing.add(hg);  
  
        //���챾����  
        GraphSearch search=new GraphSearch();  
          
        //��ȱ���  
        System.out.print("��ȱ���:");  
        search.widthSearch(a);  
  
        //��ȱ���  
        System.out.print("\n��ȱ���:");  
        List<NodeT> visited=new ArrayList<NodeT>();  
        search.depthFisrtSearch(a,visited);  
          
    }  
      
    /* 
     * �������ķ��� 
     * ��������ķ�ʽ����һ���ڵ㣬һֱ���������ȥ��ֱ����û�нڵ�Ϊֹ 
     * cur  ��ǰ��Ԫ�� 
     * visited ���ʹ���Ԫ�صļ��� 
     */  
    void depthFisrtSearch(NodeT cur,List<NodeT> visited){  
        //�����ʹ��ˣ��Ͳ����ʣ���ֹ��ѭ��  
        if(visited.contains(cur)) return;  
        visited.add(cur);  
        System.out.print(cur.word+" ");  
        for(int i=0;i<cur.outgoing.size();i++){  
            //���ʱ���Ľ�����  
            depthFisrtSearch(cur.outgoing.get(i).end,visited);  
        }  
    }  
  
    /** 
     * �������ķ��� 
     * ��������ķ�ʽ������ζ�ͼ���з��ʣ��ȵ�һ�㣬�ٵڶ��㣬�������� 
     * @param start ���ĸ���ʼ������� 
     */  
    void widthSearch(NodeT start){  
        //��¼���з��ʹ���Ԫ��  
        Set<NodeT> visited=new HashSet<NodeT>();  
        //�ö��д�����б�������Ҫ����Ԫ��  
        Queue<NodeT> q=new LinkedList<NodeT>();  
        //�ѵ�ǰ��Ԫ�ؼ��뵽����β  
        q.offer(start);  
          
        while(!q.isEmpty()){  
            NodeT cur=q.poll();  
            //�����ʹ��ˣ��Ͳ����ʣ���ֹ��ѭ��  
            if(!visited.contains(cur)){  
                visited.add(cur);  
                System.out.print(cur.word+" ");  
                for(int i=0;i<cur.outgoing.size();i++){  
                    //��������һ�㣬���뵽������  
                    q.offer(cur.outgoing.get(i).end);  
                }  
            }  
        }  
    }  
}
//���ʵ����
class NodeT  
{  
    /* ������й�ϵ�ļ��� */  
    List<ArcT> outgoing; //��¼����
    //�����ĸ  
    String word;//�������
    public NodeT(String word){  
        this.word=word;  
        outgoing=new ArrayList<ArcT>();  
    }  
}  
  
/** 
  * �ߵĹ�ϵ 
  */  
class ArcT  
{  
    NodeT start,end;/* ��ʼ�㣬������ */  
    public ArcT(NodeT start,NodeT end){  
        this.start=start;  
        this.end=end;  
    }  
} 