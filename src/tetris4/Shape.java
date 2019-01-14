/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris4;

import java.util.Random; 

public class Shape implements Cloneable{
    
public int pattern[][];  //x and y w.r.t to board

static int convert[][][][]={        // 7 shapes types and 4 forms of each shape
    {   //for I
        {{-1,1},{0,0},{1,-1},{2,-2}},
        {{1,-1},{0,0},{-1,1},{-2,2}},
        {{-1,1},{0,0},{1,-1},{2,-2}},
        {{1,-1},{0,0},{-1,1},{-2,2}}    
    },
    {   //for O
        {{0,0},{0,0},{0,0},{0,0}},
        {{0,0},{0,0},{0,0},{0,0}},
        {{0,0},{0,0},{0,0},{0,0}},
        {{0,0},{0,0},{0,0},{0,0}}    
    },
    {   //for L
        {{-1,1},{0,0},{1,-1},{2,0}},
        {{1,1},{0,0},{-1,-1},{0,-2}},
        {{1,-1},{0,0},{-1,1},{-2,0}},
        {{-1,-1},{0,0},{1,1},{0,2}}    
    },
    {   //for J
        {{-1,1},{0,0},{1,-1},{0,-2}},
        {{1,1},{0,0},{-1,-1},{-2,0}},
        {{1,-1},{0,0},{-1,1},{0,2}},
        {{-1,-1},{0,0},{1,1},{2,0}}    
    },
    {   //for S
        {{1,1},{0,0},{1,-1},{0,-2}},
        {{-1,-1},{0,0},{-1,1},{0,2}},
        {{1,1},{0,0},{1,-1},{0,-2}},
        {{-1,-1},{0,0},{-1,1},{0,2}}    
    },
    {   //for Z
        {{1,-1},{0,0},{1,1},{0,2}},
        {{-1,1},{0,0},{-1,-1},{0,-2}},
        {{1,-1},{0,0},{1,1},{0,2}},
        {{-1,1},{0,0},{-1,-1},{0,-2}}    
    },
    {   //for T
        {{-1,-1},{0,0},{1,1},{1,-1}},
        {{-1,1},{0,0},{1,-1},{-1,-1}},
        {{1,1},{0,0},{-1,-1},{-1,1}},
        {{1,-1},{0,0},{-1,1},{1,1}}    
    }
};

public int type,form;
static Random rand=new Random(System.currentTimeMillis());
int M,N;

Shape()
{
}

Shape(int M,int N)
{
this.M=M;
this.N=N;


pattern=new int[4][2];

type=rand.nextInt(7);
form=0;

switch(type)
{
    case 0:
      IShape();
      break;
    
    case 1:
        OShape();
        break;
        
    case 2:
        LShape();
        break;
    
    case 3:
        JShape();
        break;
        
    case 4:
        SShape();
        break;
       
    case 5:
        ZShape();
        break;
    
    case 6:
        TShape();
        break;
        
    default:
    System.out.println("Error in Generating Shape");
    System.exit(0);
        break;
        
}

}      
@Override
public Object clone() throws CloneNotSupportedException
{
Shape s=(Shape)super.clone();

s.pattern=new int[4][2];
int i,j;
for(i=0;i<4;i++)
{
s.pattern[i][0]=pattern[i][0];
s.pattern[i][1]=pattern[i][1];
}
return s;
}


public void IShape()
{
pattern[0][0]=0;pattern[0][1]=(N-1)/2;

pattern[1][0]=1;pattern[1][1]=(N-1)/2;

pattern[2][0]=2;pattern[2][1]=(N-1)/2;

pattern[3][0]=3;pattern[3][1]=(N-1)/2;

}
public void OShape()
{
pattern[0][0]=0;pattern[0][1]=N/2-1;

pattern[1][0]=0;pattern[1][1]=N/2;

pattern[2][0]=1;pattern[2][1]=N/2-1;

pattern[3][0]=1;pattern[3][1]=N/2;

}
public void LShape()
{
   
pattern[0][0]=0;pattern[0][1]=N/2-1;

pattern[1][0]=1;pattern[1][1]=N/2-1;

pattern[2][0]=2;pattern[2][1]=N/2-1;

pattern[3][0]=2;pattern[3][1]=N/2;
 
    
}
public void JShape()
{
pattern[0][0]=0;pattern[0][1]=N/2;

pattern[1][0]=1;pattern[1][1]=N/2;

pattern[2][0]=2;pattern[2][1]=N/2;

pattern[3][0]=2;pattern[3][1]=N/2-1;
 

}
public void SShape()
{
pattern[0][0]=0;pattern[0][1]=N/2;

pattern[1][0]=0;pattern[1][1]=N/2-1;

pattern[2][0]=1;pattern[2][1]=N/2-1;

pattern[3][0]=1;pattern[3][1]=N/2-2;

}
public void ZShape()
{
pattern[0][0]=0;pattern[0][1]=N/2-2;

pattern[1][0]=0;pattern[1][1]=N/2-1;

pattern[2][0]=1;pattern[2][1]=N/2-1;

pattern[3][0]=1;pattern[3][1]=N/2;

}
public void TShape()
{

pattern[0][0]=0;pattern[0][1]=N/2-2;

pattern[1][0]=0;pattern[1][1]=N/2-1;

pattern[2][0]=0;pattern[2][1]=N/2;

pattern[3][0]=1;pattern[3][1]=N/2-1;

}

public boolean check()
{
int i,j;
boolean flag=true;

for(i=0;i<4;i++)
{
if(pattern[i][1]<0 || pattern[i][1]>=N || pattern[i][0]<0)
{flag=false;
}

}  
return flag;
}

public  boolean left()
{
int i;
for(i=0;i<4;i++)
{
pattern[i][1]--;
}
if(check())
{return true;    }    
else
{
for(i=0;i<4;i++)
{
pattern[i][1]++;
}
return false;
}

}

public  boolean right()
{
int i;
for(i=0;i<4;i++)
{
pattern[i][1]++;
}

if(check())
{return true;    }    
else
{
for(i=0;i<4;i++)
{
pattern[i][1]--;
}
return false;
}

}
public  boolean down()
{
int i;
for(i=0;i<4;i++)
{
pattern[i][0]++;
}
/*
if(check())
{return true;    }    
else
{
for(i=0;i<4;i++)
{
pattern[i][0]--;
}
return false;
}
*/
return true;
}

public  boolean up()
{
int i;
for(i=0;i<4;i++)
{
pattern[i][0]--;
}

if(check())
{return true;    }    
else
{
for(i=0;i<4;i++)
{
pattern[i][0]--;
}
return false;
}

}

public boolean rotateClock()
{
int i,j;
form++;
if(form>=4)
{form=0;
}    

for(i=0;i<4;i++)
{
pattern[i][0]+=convert[type][form][i][0];
pattern[i][1]+=convert[type][form][i][1];

}

if(check())
{return true;    }    
else
{
for(i=0;i<4;i++)
{
pattern[i][0]-=convert[type][form][i][0];
pattern[i][1]-=convert[type][form][i][1];

}

form--;
if(form<0)
{form=3;
}

return false;
}


}

public boolean rotateAntiClock()
{
int i,j;    

for(i=0;i<4;i++)
{
pattern[i][0]-=convert[type][form][i][0];
pattern[i][1]-=convert[type][form][i][1];

}
    
form--;
if(form<0)
{form=3;
}

if(check())
{return true;    }    
else
{
form++;
if(form>=4)
{form=0;
}    

for(i=0;i<4;i++)
{
pattern[i][0]+=convert[type][form][i][0];
pattern[i][1]+=convert[type][form][i][1];

}

return false;
}

}

public static void main(String arg[])
{
}

}