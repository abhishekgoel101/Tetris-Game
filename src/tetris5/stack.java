package tetris5;


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

   public snode insertL(data data,snode tail)
   {
   snode temp=new snode(data);
   
   if(head==null && tail==null)
   {
   head=temp;
   tail=temp;
   }   
   else
   {
   tail.next=temp;
   tail=temp;
   }   
   return tail;
   } 
   
}
