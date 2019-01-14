/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris1;

import java.util.Timer; 
import java.util.TimerTask; 


public class tetris_frame extends javax.swing.JFrame {

    int M=20,N=30;
    char board[][];
    Shape s;
    Timer timer;

    
    public tetris_frame() {
        initComponents();
            board=new char[M][N];
       s=new Shape(M,N);
       emptyBoard(board,M,N);
           setShape(board,s,M,N);
           printBoard(board,M,N);
           this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
     
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                move('s');
            }
        }, 1000, 1000);
    
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        t1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        t1.setEditable(false);
        t1.setBackground(new java.awt.Color(0, 0, 0));
        t1.setColumns(20);
        t1.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        t1.setForeground(new java.awt.Color(255, 255, 255));
        t1.setRows(5);
        ka2=new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t1KeyPressed(evt);
            }
        };

        t1.addKeyListener(ka2);

        /*
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t1KeyPressed(evt);
            }
        });
        */
        jScrollPane1.setViewportView(t1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyPressed
        
                timer.cancel();
                timer=new Timer();
                timer.schedule(new TimerTask() {
            @Override
            public void run() {
                move('s');
            }
        }, 1000, 1000);

        int key = evt.getKeyCode();
        if(key==65 || key==37)
            move('a');
        else if(key==68 || key==39)
           move('d'); 
        else if(key==83 || key==40)
           move('s');
        else if(key==74)
           move('j'); 
        else if(key==76)
           move('l'); 
        else if(key==81 || key==27)
           move('q');
        else
            move('n');

    }//GEN-LAST:event_t1KeyPressed

    
    private void gameExit(java.awt.event.KeyEvent evt) {                              
       
        int key = evt.getKeyCode();
        if(key==10)
    dispose();
    } 
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tetris_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tetris_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tetris_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tetris_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tetris_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea t1;
    // End of variables declaration//GEN-END:variables

    java.awt.event.KeyAdapter ka2;
    
  public void move(char c)  
  {
      boolean flag=false,flag1=false,gameover=false;         
      t1.setText("");
      if(c!='q')
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
           {println(" GAME OVER\n BETTER LUCK NEXT TIME\n Press Enter to continue");
           t1.removeKeyListener(ka2);
           timer.cancel();
           
            ka2=new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gameExit(evt);
            }
        };

        t1.addKeyListener(ka2);
           
           
           }
           
           }    
           else
           {
           setShape(board,s,M,N);
           printBoard(board,M,N);
           
          println("Enter Valid Move");
           }
          
       }
      else
      {
      dispose();
      }  
       
  }
   
  public void print(String s)
  {
      t1.append(s);
  }
  
  public void println(String s)
  {
      t1.append(s+"\n");
  }
    public void emptyBoard(char board[][],int M,int N)
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

 public  void setShape(char board[][],Shape s,int M,int N)
 {
 int i,j;
 
 for(i=0;i<4;i++)
 {
 board[s.pattern[i][0]][s.pattern[i][1]]='O';
 }
 
 }        

  public void clearShape(char board[][],Shape s,int M,int N)
 {
 int i,j;
 
 for(i=0;i<4;i++)
 {
 board[s.pattern[i][0]][s.pattern[i][1]]=' ';
 }
 
 }
 public  boolean checkShape(char board[][],Shape s,int M,int N)
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
 
 public void printBoard(char board[][],int M,int N)
 {
     int i,j;
 for(i=0;i<N+2;i++)
 {print("!");
 }
 println("");
 
 for(i=0;i<M;i++)
 {print("!");
 for(j=0;j<N;j++)
 {print(board[i][j]+"");}
 println("!");
 }
 for(i=0;i<N+2;i++)
 {print("!");
 } 
 println("");
 println("");
 }   
 

}
