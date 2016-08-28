package com.wjy.code;

import java.util.Stack;
import java.util.regex.Pattern;
/**
 * 推箱子的可行路径（吃奶酪）-回溯法基本模式
 * 1表示可行 0表示不通 9表示目标
 * @author Jay Wang
 *
 */
public class Tuixiangzi {
	static Stack<Gezi> path = new Stack<Tuixiangzi.Gezi>();
	private static Gezi[][] gz;
	private static int heigth;
	private static int width;
	static int [] a = {-1,1,0,0};
	static int [] b ={0,0,1,-1};
	private static class Gezi{
		int val;
		int x_coord;
		int y_coord;
		boolean isVisited;
		Gezi(int v){
			this.val = v;
		}
	}
	Tuixiangzi(int[][] xz,int x,int y){
		heigth =x;
		width =x;
		gz = new Gezi[x][y];
		
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++){
				gz[i][j] = new Gezi(xz[i][j]);
				gz[i][j].x_coord = j;
				gz[i][j].y_coord = i;
				gz[i][j].isVisited = false;
			}
				
	}
	public static boolean findPath(int iii,int jjj){
		if(gz[iii][jjj].val==9){
			for (Gezi zz : path) {
				System.out.println("["+zz.x_coord+","+zz.y_coord+"]");
			}
			return true;
		}
		for (int i = 0; i < 4; i++) {
			if(iii+a[i]>=heigth || jjj+b[i]>=width || iii+a[i]<0 || jjj+b[i]<0){
				continue;
			}
			Gezi tmp=gz[iii+a[i]][jjj+b[i]];
			if(!tmp.isVisited && tmp.val!=0){
				tmp.isVisited =true;
				path.add(tmp);
				if(Tuixiangzi.findPath(iii+a[i], jjj+b[i])){
					return true;
				}
				path.pop();
				gz[iii][jjj].isVisited =false;
			}
		}
		return false;
 	}
	public static void main(String[] args) {
		
		int[][] walls  ={
				{1,1,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1},
				{1,0,0,0,1,0,0,1},
				{1,1,1,0,1,0,0,1},
				{0,1,0,0,1,1,1,1},
				{0,1,0,0,0,0,0,1},
				{0,1,0,9,1,1,1,1},
				{0,1,1,1,0,0,0,1}
				};
		Tuixiangzi t = new Tuixiangzi(walls, 8, 8);
		gz[0][0].isVisited =true;
		path.add(gz[0][0]);
		System.out.println(t.findPath(0,0));
	}
}
