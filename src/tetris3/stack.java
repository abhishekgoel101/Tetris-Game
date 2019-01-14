package tetris3;


class data{
matrix board;
Shape s;
data()
{
 board=null;
 s=null;
}        

}

class snode{
data data;
snode next;

snode()
{}

snode(matrix m,Shape s)
{
data=new data();    
data.board=m;
this.data.s=s;
next=null;
}        

}
public class stack {

   snode head;
   stack()
   {
   head=null;
   }
   public void push(matrix m,Shape s)
   {
   /*    
    matrix m1;  
   try{    
   m1=(matrix)m.clone();    
   Shape s1=(Shape)s.clone();
   snode temp=new snode(m1,s1);
   temp.next=head;
   head=temp;
   
   }catch(CloneNotSupportedException ex)
   {ex.printStackTrace();}  
   */
   
   snode temp=new snode(m,s);
   temp.next=head;
   head=temp;
   
   }
   
   public data pop()
   {
       if(head==null)
       {
        return null;}
       
       data d=head.data;
       head=head.next;
      return d;
   }

}
