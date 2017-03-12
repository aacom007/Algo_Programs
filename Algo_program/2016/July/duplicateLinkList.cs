using System;
namespace Program
{

    public class Node
    {
       public int no;
       public Node next;
    }

    class Program
    {
       public static Node start ;

         static void Main(string [] args) {
        
         int N =0;
         Node y = new Node();
         y.no=1;
         Node temp;
         start = y;
         temp = y;
         
         for(int i =1;i<5;i++)
         {
         
            Node p = new Node();
            p.next=null;
            p.no=i;    
            y.next=p;
            y=p;
          
           
         }

         printList(start);
         removeDuplicate(start );
         Console.WriteLine("---removed");
         printList(start);
        Console.ReadLine();
        }
        
        static void printList(Node start)
        {
            Node x = start;
            while(x!=null)
           { Console.Write(x.no+"->");
           
            x=x.next;
            }
        }
        static void removeDuplicate(Node x)
        {
            int count = 0;
            Node temp;
            temp=x;
            while(x.next!=null)
            {
            count++;
            x= x.next;
            }

            Node put;
           x= temp; 
            put = x;
           
            for(int i=0;i<count;i++)
            {
  
                while(temp.next!=null )
                {
                    
                    
                    if(put.no == temp.next.no)   
                    {
                        temp.next= temp.next.next;   
                    }
                    temp=temp.next;
                }
                
                put=put.next;
            }
                    
        }

        static void prog(string line , string [,] mat, int N,int M)
        {
            string [] lineValues;
            lineValues=line.Split(',');
            int Pox=Convert.ToInt32(lineValues [0]);
            int Poy=Convert.ToInt32(lineValues [1]);
            if(Pox<0 && Pox>N ||      (Poy<0 || Poy>M))
            Console.WriteLine ("Please enter a value for x,y between 0 to "+N+", "+M);
           
            char val=Convert.ToChar(lineValues [2]);
            string temp=mat [Pox , Poy ].ToString();
            mat [Pox, Poy]=val.ToString();
            for(int i=0 ; i<N ; i++)
                for(int j=0 ; j<M ; j++)
                {
                    
                    rec(mat, temp, val, i, j-1, M, N);
                    rec(mat, temp, val, i+1, j, M, N);
                    rec(mat, temp, val, i, j+1, M, N);
                    rec(mat, temp, val, i-1, j, M, N);
                }
            



        }

       static void rec(string [,] mat, string temp, char val, int x, int y, int M, int N)
        {

            if(x-1>=0&&y>=0 &&x<N && y<M )
                if((mat [x-1,y])==temp)
                    mat [x-1,y]=val.ToString();

            if(x>=0&&y+1<M && x<N && y<M)
                if( (mat [x,y+1])==temp)
                    mat [x,y+1]=val.ToString();

            if(x>=0&&y-1>=0 && x<N && y<M)
                if( (mat [x,y-1])==temp)
                    mat [x,y-1]=val.ToString ();

            if(x+1<N && y>=0 && x>0 && y<M)
                if( (mat [x+1,y])==temp)
                    mat [x+1,y]=val.ToString();

        }
    }
}