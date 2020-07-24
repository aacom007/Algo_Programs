@@ -1,51 +0,0 @@
    

int SecondLargest(int[] a)
{
int max = Integer.MIN_INT; 
int secondMax = Integer.MIN_INT; 



    if(a.length()>1){  

    if(a[0]>a[1]){
        max =a [0];
        secondMax = a[1];
    } else {
        max =a [1];
        secondMax = a[0];
    }

        //O(n) 
     for(int i=2;<a.length();i++){
         
         //a[i] =1
         if(a[i]> max ){
             secondMax = max; // -min 
             max= a[i]; //max = 0
         } else if( a[i] > secondMax && a[i] < max){  
             secondMax = a[i];
         } 
     }
     
     if(secondMax == max ){
          // nothing is present in the array 
         throw new Exception();
     }
     else{
        return secondMax ; // -min
     }     
}


testcase 
1: a ={1,2,3}
2 : {1}
3.1: {0,0}
3:{-20000, 20, -20,2000}

4{ 3 2, 1}

5 {Integer.MinInt, Integer.MaxInt}
6{Integer.MinInt, Integer.minInt}