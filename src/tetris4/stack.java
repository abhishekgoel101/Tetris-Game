package tetris4;


class data{
Shape s;
int row[];
int rsize;
boolean newShape;

data()
{
 s=null;
 
 row=new int[4];
 for(int i=0;i<4;i++)
 {row[i]=-1;
 }
 newShape=false;
 rsize=0;
}        

}

class snode{
data data;
snode next;

snode()
{}

snode(data data)
{
this.data=data;
next=null;
}        

}
public class stack {

   snode head;
   stack()
   {
   head=null;
   }
   public void push(data data)
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
   
   snode temp=new snode(data);
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
