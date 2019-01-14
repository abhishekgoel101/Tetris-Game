/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris3;


class node{
char col[];
int count;
node next;
node()
{}

node(int N)
{
col=new char[N];
count=0;
next=null;
int i;
for(i=0;i<N;i++)
{col[i]=' ';}
}

};

public class matrix implements Cloneable{
node head=null;
int M,N;
node row[];
matrix()
{}

matrix(int M,int N)
{
int i;
this.M=M;
this.N=N;
row=new node[M];

for(i=0;i<M;i++)
{
    insertL(i);   
}

}

@Override
public Object clone() throws CloneNotSupportedException
{
matrix m=(matrix)super.clone();
m.head=null;
m.row=new node[M];
int i,j;
for(i=0;i<M;i++)
{
    m.insertL(i);
    
    for(j=0;j<N;j++)
    {m.row[i].col[j]=row[i].col[j];} 
      m.row[i].count=row[i].count;
}
return m;
}

public void insertL(int i)
{
 node temp=new node(this.N); 
 row[i]=temp;
node ptr=head;
if(head==null)
{head=temp;
}
else
{
while(ptr.next!=null)
{ptr=ptr.next;
}
ptr.next=temp;

}

} 

public void insertB(int i)
{
 node temp=new node(this.N); 
 row[i]=temp;

temp.next=head;
head=temp;


} 

public void deleteInsertRow(int i)
{
int j;  
node ptr,ptr1;
if(i<0 || i>=M)
{return ;}

if(i==0)    //head case
{
head=head.next;
}
else if(i>0 && i<this.M)
{
j=i-1;
 ptr=row[j];
ptr.next=ptr.next.next;

}

for(j=i-1;j>=0;j--)
{
row[j+1]=row[j];
}
insertB(0);

}

public int check()
{
 int i;
 int plus_score=0;
for(i=M-1;i>=0;i--) 
{
if(row[i].count>=N)
{
  deleteInsertRow(i);
    i++;
    plus_score++;
} 
}    
return plus_score;
}

}
