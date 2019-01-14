/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.game;
import java.util.Scanner;



public class TetrisGame {

 public static void emptyBoard(char board[][],int M,int N)
 {
 int i,j;
 for(i=0;i<M;i++)
 {
 for(j=0;j<N;j++)
 {
 board[i][j]=' ';
 }
 }
 
 }        

 public static void setShape(char board[][],Shape s,int M,int N)
 {
 int i,j;
 
 for(i=0;i<4;i++)
 {
 board[s.pattern[i][0]][s.pattern[i][1]]='O';
 }
 
 }        

  public static void clearShape(char board[][],Shape s,int M,int N)
 {
 int i,j;
 
 for(i=0;i<4;i++)
 {
 board[s.pattern[i][0]][s.pattern[i][1]]=' ';
 }
 
 }
 public static boolean checkShape(char board[][],Shape s,int M,int N)
 {
    
 int i,j;
 for(i=0;i<4;i++) 
 {
 if(s.pattern[i][0]>=M || s.pattern[i][0]<0 || s.pattern[i][1]>=N || s.pattern[i][1]<0)
 {
 return false;
 }
 if(board[s.pattern[i][0]][s.pattern[i][1]]=='O')
 {return false;}
 }
 return true;
 }        
 
 public static void printBoard(char board[][],int M,int N)
 {
     int i,j;
 for(i=0;i<N+2;i++)
 {System.out.print("!");
 }
 System.out.println();
 
 for(i=0;i<M;i++)
 {System.out.print("!");
 for(j=0;j<N;j++)
 {System.out.print(board[i][j]);}
 System.out.println("!");
 }
 for(i=0;i<N+2;i++)
 {System.out.print("!");
 } 
 System.out.println();
 System.out.println();
 }   
 
    public static void main(String[] args) {

        int M=20,N=30;
        char board[][]=new char[M][N];
       Shape s=new Shape(M,N);
       emptyBoard(board,M,N);
           setShape(board,s,M,N);
           printBoard(board,M,N);
 
           Scanner in=new Scanner(System.in);
       char c=in.next().charAt(0);
        boolean flag=false,flag1=false,gameover=false;
           
       while(c!='q')
       {
           flag=false;
           flag1=false;
           
           clearShape(board,s,M,N);
           
           if(c=='a')
           {
           flag=s.left();
           if(flag)
           {
           flag1=checkShape(board,s,M,N);

            if(!flag1)
           {
           flag=s.right();
           flag=false;
           }          
           }
           
           }
           else if(c=='d')
           {
           flag=s.right();
           if(flag)
           {
           flag1=checkShape(board,s,M,N);

           if(!flag1)
           {
           flag=s.left();
           flag=false;
           }
           }    
           
           } 
           else if(c=='s')
           {flag=s.down();
           if(flag)
           {
           flag1=checkShape(board,s,M,N);
           if(!flag1)
           {
           flag=s.up();
           }
           
           }    
           
           }
           else if(c=='j')
           {flag=s.rotateAntiClock();
           if(flag)
           {
           flag1=checkShape(board,s,M,N);
           if(!flag1)
           {
           flag=s.rotateClock();
           flag=false;
           }
           }    
           
           }
           else if(c=='l')
           {flag=s.rotateClock();        //do if shape near wall or any object wall and then we rotate.
                                         //it should automatically adjust if possible.
           if(flag)
           {
           flag1=checkShape(board,s,M,N);
           if(!flag1)
           {
           flag=s.rotateAntiClock();
           flag=false;
           }
           }    
           
           }                               
          /* else if(c=='n')
           {
            s=new Shape(M,N);
            flag=true;
            
           */           

           if(flag)
           {
           if(flag1)
           {}
           else
           {
           setShape(board,s,M,N);
            s=new Shape(M,N);
            if(!checkShape(board,s,M,N))
            {
            gameover=true;
            }
           }
           setShape(board,s,M,N);
           printBoard(board,M,N);
           if(gameover)
           {System.out.println(" GAME OVER\n BETTER LUCK NEXT TIME");
           break;
           }
           
           }    
           else
           {
            setShape(board,s,M,N);
           printBoard(board,M,N);
              
               System.out.println("Enter Valid Move");
           }
           c=in.next().charAt(0);
          
       }
       
       
    }
 
    
}
