
package tetris5;


import java.io.*;
import java.util.Scanner;
import java.util.Timer; 
import java.util.TimerTask; 
import java.awt.event.*;


public class tetris_frame5 extends javax.swing.JFrame {

    int M=20,N=15;
    matrix board;
    Shape s;
    Timer timer;
    stack undo,redo;
    
    public tetris_frame5()
    {}
    
    public tetris_frame5(char c) {
        initComponents();
       
        if(c=='l')     
        {
            loadGame();
        }
        else
        {
            newGame();
        }    

  
     this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
     
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                move('s');
            }
        }, 2000, 2000);
    
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
        }, 2000, 2000);

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
        else if(key==90)
          move('z');        //undo
        else if(key==88)
          move('x');        //redo
        else
            move('n');

    }//GEN-LAST:event_t1KeyPressed

    
    private void gameExit(java.awt.event.KeyEvent evt) {                              
       
        int key = evt.getKeyCode();
        if(key==10)
    dispose();
    } 
    
    private void quitKey(java.awt.event.KeyEvent evt) {                              
       
        int key = evt.getKeyCode();
        String keyName=KeyEvent.getKeyText(key);
        println(keyName);        
        if(key==89)   //for Y
        {
        if(gameSave())
        println("Game Saved Successfully");        
        else
        println("Game Save UnSuccessfull");        
            
        }
        else
        {
        println("Game Exited");        
        }

           t1.removeKeyListener(ka2);
    println("\nPress Enter to continue");
          
           ka2=new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gameExit(evt);
            }
        };

        t1.addKeyListener(ka2);
        

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
            java.util.logging.Logger.getLogger(tetris_frame5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tetris_frame5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tetris_frame5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tetris_frame5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tetris_frame5('l').setVisible(true);
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
      data d=null,d1=null;
      
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
           else if(c=='z')
           {
           flag=true;
           flag1=true;

           d=undo.pop();
           if(d!=null && undo.head!=null)
           {
           redo.push(d);

           if(d.newShape==true)
           {
             board.insertOldRows(d);
            downRowCount(board,undo.head.data.s,M,N);
           }
           
           }   
           
           d=undo.pop();
           if(d!=null)
           {
               
               s=d.s;
               //Old Shape has already been cleared at top in this function.
               //And this Shape will be set in last lines of this function.
           }
           else
           {
           d1=new data();
           d1.newShape=true;
           }    

           }
           else if(c=='x')
           {
           flag=true;
           flag1=true;
           
           d=redo.pop();
           
           if(d!=null)
           {
            if(d.newShape==true)
            {
                flag1=false;
              
            }
            else
            {
            s=d.s;
              
            }   
            
           }
           
           }    

           if(flag)
           {
           if(flag1)
           {
           
           }
           else
           {
               
           setShape(board,s,M,N);
           upRowCount(board,s,M,N);
           d1=new data();
           board.check(d1);
           d1.newShape=true;
           
           if(d!=null)
           {s=d.s;}
           else
           {   
            s=new Shape(M,N);
            if(!checkShape(board,s,M,N))
            {
            gameover=true;
            }
           
           }
           
           }
           if(c!='z' && c!='x')
           {
           redo.head=null;
           }  
           setShape(board,s,M,N);
           printBoard(board,M,N);
           if(c=='z' && d==null)
           {
            println("Nothing to Undo");     
           }
           
           if(c=='x' && d==null )
           {
               println("Nothing to Redo");
           }
           else
           {
               
            try{             
                Shape s1=(Shape)s.clone();
                if(d1==null)
                {
                    if(d!=null)
                    {d1=d;}
                    else
                    {
                    d1=new data();
                    
                    }
                }

                d1.s=s1;
                 undo.push(d1);
           
                }catch(CloneNotSupportedException ex)
                {ex.printStackTrace();}  
                
           }    
           
           
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
      quit();    
     
      }  
       
  }
  
  public void quit()
  {
           t1.removeKeyListener(ka2);
           timer.cancel();

      t1.setText("");
      println("Do you wish to save the Game (y/n)");
            ka2=new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quitKey(evt);
            }
        };

        t1.addKeyListener(ka2);

      
  }
  
  public void upRowCount(matrix board,Shape s,int M,int N)
  {
   int i,j;
 
 for(i=0;i<4;i++)
 {
 board.row[s.pattern[i][0]].count++;    
 
 }
 
  }
  public void downRowCount(matrix board,Shape s,int M,int N)
  {
   int i,j;
 
 for(i=0;i<4;i++)
 {
 board.row[s.pattern[i][0]].count--;    
 
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
    public void emptyBoard(matrix board,int M,int N)
 {
 int i,j;
 for(i=0;i<M;i++)
 {
 for(j=0;j<N;j++)
 {
 board.row[i].col[j]=' ';
 }
 board.row[i].count=0;
 }
 
 }        

 public  void setShape(matrix board,Shape s,int M,int N)
 {
 int i,j;
 
 for(i=0;i<4;i++)
 {
 board.row[s.pattern[i][0]].col[s.pattern[i][1]]='O';    
 
 }
 
 }        

  public void clearShape(matrix board,Shape s,int M,int N)
 {
 int i,j;
 
 for(i=0;i<4;i++)
 {
 board.row[s.pattern[i][0]].col[s.pattern[i][1]]=' ';
 }
 
 }
 public  boolean checkShape(matrix board,Shape s,int M,int N)
 {
    
 int i,j;
 for(i=0;i<4;i++) 
 {
 if(s.pattern[i][0]>=M || s.pattern[i][0]<0 || s.pattern[i][1]>=N || s.pattern[i][1]<0)
 {
 return false;
 }
 if(board.row[s.pattern[i][0]].col[s.pattern[i][1]]=='O')
 {return false;}
 }
 return true;
 }        
 
 public void printBoard(matrix board,int M,int N)
 {
     int i,j;
 for(i=0;i<N+2;i++)
 {print("!");
 }
 println("");
 
 for(i=0;i<M;i++)
 {print("!");
 for(j=0;j<N;j++)
 {print(board.row[i].col[j]+"");}
 println("!");
 }
 for(i=0;i<N+2;i++)
 {print("!");
 } 
 println("");
 println("");
 }   
 

 public boolean gameSave()
 {
     File f1=new File("board.txt");
     File f2=new File("stack.txt");    
     boolean flag1=false,flag2=false;
     try{
         f1.delete();
         f2.delete();
        flag1=f1.createNewFile();
        flag2=f2.createNewFile();


        if(flag1 && flag2)
        {
        PrintStream p1=new PrintStream(f1);
        
        //for Matrix
        p1.println(M+" "+N);
        int i,j;
        for(i=0;i<M;i++)
        {
        for(j=0;j<N;j++)
        {
        p1.print(board.row[i].col[j]);    
        }
        p1.println("@"+board.row[i].count);    
        
        }
        p1.println();   
        
        //for Shape s
        for(i=0;i<4;i++)
        {
        for(j=0;j<2;j++)
        {
        p1.print(s.pattern[i][j]+" ");    
        }   
        }
        
        p1.println(s.type+" "+s.form);
        
        //for undo and redo stack
        
        p1.close();
        p1=new PrintStream(f2);
        
        //for undo
        snode ptr=undo.head;
        
        while(ptr!=null)
        {
         
          for(i=0;i<4;i++)
        {
        for(j=0;j<2;j++)
        {
        p1.print(ptr.data.s.pattern[i][j]+" ");    
        }   
        }
        
        p1.print(ptr.data.s.type+" "+ptr.data.s.form+" ");
        p1.print("@"+ptr.data.rsize+" ");
        
        for(i=0;i<ptr.data.rsize;i++)
        {
        p1.print(ptr.data.row[i]+" ");       
        }
        p1.println(ptr.data.newShape);       
        
        
        ptr=ptr.next;
        }
        
        p1.println("#");    //delimeter to separate undo redo stack
        
        
        //for redo
        ptr=redo.head;
        
        while(ptr!=null)
        {
         
          for(i=0;i<4;i++)
        {
        for(j=0;j<2;j++)
        {
        p1.print(ptr.data.s.pattern[i][j]+" ");    
        }   
        }
        
        p1.print(ptr.data.s.type+" "+ptr.data.s.form+" ");
        p1.print("@"+ptr.data.rsize+" ");
        
        for(i=0;i<ptr.data.rsize;i++)
        {
        p1.print(ptr.data.row[i]+" ");       
        }
        
        p1.println(ptr.data.newShape);       
        
        
        ptr=ptr.next;
        }
        
        p1.close();
       return true;
        }
        
    }
    catch (IOException e) {		
	e.printStackTrace();
    }
     return false;
     
 }
 
 public void newGame()
 {
             board=new matrix(M,N);
            undo=new stack();
            redo=new stack();
            s=new Shape(M,N);
            emptyBoard(board,M,N);

            setShape(board,s,M,N);
            printBoard(board,M,N);

            try{          
              Shape s1=(Shape)s.clone();
                 data d=new data();
                 d.newShape=true;
                 d.s=s1;
              undo.push(d); 
            }catch(CloneNotSupportedException ex)
            {ex.printStackTrace();}  
            
 
 }
 
 public void loadGame()
 {
    File f1=new File("board.txt");
    File f2=new File("stack.txt");
        
    if(f1.exists() && f2.exists())
    {
      try{
    
    //for board      
    Scanner sc=new Scanner(f1);          
    this.M=sc.nextInt();
    this.N=sc.nextInt();
    board=new matrix(M,N);    
    s=new Shape(M,N,true);
    undo=new stack();
    redo=new stack();       
    
    int i,j;
    
    sc.nextLine();
    for(i=0;i<M;i++)
    {
    String row=sc.nextLine();
    for(j=0;j<N;j++)
    {
    board.row[i].col[j]=row.charAt(j);
    
    }
    board.row[i].count=Integer.parseInt(row.substring(row.indexOf("@")+1));
    }
    
    sc.nextLine();
    
    for(i=0;i<4;i++) 
    {
    for(j=0;j<2;j++)
    {
    s.pattern[i][j]=sc.nextInt();    
    }
    
    }
    s.type=sc.nextInt();
    s.form=sc.nextInt();
    
    setShape(board,s,M,N);
    printBoard(board,M,N);
    
    sc.close();
    
    //for stack
    sc=new Scanner(f2).useDelimiter("#");
    //sc.useDelimiter("#\n");    
    
    //for undo

    Scanner sc1=new Scanner(sc.next());
 
    snode tail=null;
    
    while(sc1.hasNextLine())
    {
    String sdata=sc1.nextLine();
    
    Scanner sc2=new Scanner(sdata);

    data d=new data();
    d.s=new Shape(M,N,true);
    
    for(i=0;i<4;i++) 
    {
    for(j=0;j<2;j++)
    {
    d.s.pattern[i][j]=sc2.nextInt();    
    }
    
    }
    d.s.type=sc2.nextInt();
    d.s.form=sc2.nextInt();
    
    sc2.close();
    sc2=new Scanner(sdata.substring(sdata.indexOf("@")+1));
    d.rsize=sc2.nextInt();
    
    for(i=0;i<d.rsize;i++)
    {
    d.row[i]=sc2.nextInt();    
    }
    d.newShape=sc2.nextBoolean();
    
    sc2.close();
    tail=undo.insertL(d, tail);
    
    }
    sc1.close();
    
    //for redo
    sc1=new Scanner(sc.next());
    
    sc1.nextLine();
    tail=null;
    
    while(sc1.hasNextLine())
    {
        
    String sdata=sc1.nextLine();    
   // System.out.println(sdata);
    
    Scanner sc2=new Scanner(sdata);

    data d=new data();
    d.s=new Shape(M,N,true);
    
    for(i=0;i<4;i++) 
    {
    for(j=0;j<2;j++)
    {
    d.s.pattern[i][j]=sc2.nextInt();    
    }
    
    }
    d.s.type=sc2.nextInt();
    d.s.form=sc2.nextInt();
    
    sc2.close();
    sc2=new Scanner(sdata.substring(sdata.indexOf("@")+1));
    d.rsize=sc2.nextInt();
    
    for(i=0;i<d.rsize;i++)
    {
    d.row[i]=sc2.nextInt();    
    }
    d.newShape=sc2.nextBoolean();
    
    sc2.close();
    tail=redo.insertL(d, tail);
    
    }
    sc1.close();
    sc.close();
    
    
      }
        catch (IOException e) {		
	e.printStackTrace();
        }
    
        
    }
         

 }
 
}

