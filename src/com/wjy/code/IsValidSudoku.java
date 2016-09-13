package com.wjy.code;

public class IsValidSudoku {
	public static void main(String[] args) {
		IsValidSudoku isValidSudoku = new IsValidSudoku();
		char [][] a= {"..4...63.".toCharArray(),".........".toCharArray(),"5......9.".toCharArray(),
				"...56....".toCharArray(),"4.3.....1".toCharArray(),"...7.....".toCharArray(),
				"...5.....".toCharArray(),".........".toCharArray(),".........".toCharArray()};
		
		System.out.println(isValidSudoku.isValidSudoku(a));
	}
    public boolean isValidSudoku(char[][] board) {
        boolean rs = true;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                rs = rs &&isValid(i*3,j*3,i*3+3,j*3+3,board);
            }
        }
        for(int i = 0;i<9;i++){
            rs = rs &&isValid(i,0,i+1,9,board);
        }
        for(int j=0;j<9;j++){
            rs = rs &&isValid(0,j,9,j+1,board);
        }
        return rs;
    }
    
    boolean isValid(int starti,int startj,int i,int j,char[][] b){
        int[] count=new int[9];
        int n;
        for(int m=starti;m<i;m++){
            for(int l=startj;l<j;l++){
                n = b[m][l]-'1';
                if(n>=-1 && n<10){
                    if(count[n]>0){
                        System.out.println("µ±Ç°×Ö·û"+(n+1)+" ±¬Õ¨ÁË ");
                        return false;
                    }else{
                        count[n]++;
                    }
                }
            }
        }
        return true;
    }
}
