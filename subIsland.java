/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substring;

/**
 *
 * @author akshay anand
 */
public class subIsland {
    
    public void allEight(int row, int col,int [][] sea, boolean [][] check ){

        if (sea[row][col] == 0 || check[row][col]) return ;
        check[row][col] = true;
           if( col < sea.length - 1 )                           allEight(row, col+1, sea, check);
           if( col > 0 )                                        allEight(row, col-1, sea, check);
           if( row < sea.length - 1 )                           allEight(row+1, col, sea, check);
           if( col > 0 && row < sea.length - 1 )                allEight(row+1, col-1, sea, check);
           if( col < sea.length - 1 && row < sea.length - 1 )   allEight(row+1, col+1, sea, check);
           if( row > 0)                                         allEight(row-1, col, sea, check);
           if( col > 0 && row > 0)                              allEight(row-1, col-1, sea, check);
           if( col < sea.length - 1 && row > 0)                 allEight(row-1, col+1, sea, check);
   }

    public Integer checked(int [][] sea){
        boolean [][] check = new boolean[sea.length][sea.length];
        Integer count =0;
        
         for(int i=0;i<sea[0].length-1;i++){
            for(int k=0;k<sea[0].length-1;k++){
                check[i][k] = false;
            }
         }
            
        // start
        for(int i=0;i<sea[0].length;i++){
            for(int k=0;k<sea[0].length;k++){
                if(sea[i][k] == 1){
                    if(!check[i][k]){
                       System.out.println("I "+i+ " K "+ k);
                       allEight(i,k, sea, check);
                       count++;
                   }
                } 
                if(sea[i][k]==0){
                    check[i][k]= true;
                }
            }
        }
        return count;
    }
    
    public void count(){
             
        int[][] sea = new int[][] { 
            new int[] {0,  1,  0,  1,  0},
            new int[] {0,  0,  1,  1,  1},
            new int[] {1,  0,  0,  1,  0},
            new int[] {0,  1,  1,  0,  0},
            new int[] {1,  0,  1,  0,  1} 
        };

        Integer count =0;
        count = checked(sea);
        System.out.println("COUNT"+ count);
    }
}
