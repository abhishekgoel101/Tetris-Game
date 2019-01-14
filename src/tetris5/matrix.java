
package tetris5;


class node{
char col[];
int count;

node()
{}

node(int N)
{
col=new char[N];
count=0;

int i;
for(i=0;i<N;i++)
{col[i]=' ';}
}

};

public class matrix implements Cloneable{

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
    insertRow(i);   
}

}

@Override
public Object clone() throws CloneNotSupportedException
{
matrix m=(matrix)super.clone();
m.row=new node[M];
int i,j;
for(i=0;i<M;i++)
{
    m.insertRow(i);
    
    for(j=0;j<N;j++)
    {m.row[i].col[j]=row[i].col[j];} 
      m.row[i].count=row[i].count;
}
return m;
}

public void insertRow(int i)
{
 node temp=new node(this.N); 
 row[i]=temp;

} 

public void deleteInsertRow(int i)
{
int j;  

if(i<0 || i>=M)
{return ;}


for(j=i-1;j>=0;j--)
{
row[j+1]=row[j];
}
insertRow(0);

}

public void insertFullRow(int i)
{
int j;  

if(i<0 || i>=M)
{return ;}


for(j=0;j<i;j++)
{
row[j]=row[j+1];
}
insertRow(i);
node ptr=row[i];

for(j=0;j<this.N;j++)
{ptr.col[j]='O';}
ptr.count=this.N;

}

public void insertOldRows(data d)
{
 int i;   
for(i=0;i<d.rsize;i++)
{
if(d.row[i]!=-1)
{
    insertFullRow(d.row[i]);
} 
else
{break;}   
}  

}


public int check(data data)
{
 int i;
 int plus_score=0;
for(i=M-1;i>=0;i--) 
{
if(row[i].count>=N)
{
  deleteInsertRow(i);
  if(data.rsize<4)
  {
      data.row[data.rsize]=i;
      data.rsize++;
  }
  else
  {
    System.out.println("Error in matrix row deleteion storing in stack");
  }    
    i++;
    plus_score++;
} 
}    
return plus_score;
}

}
