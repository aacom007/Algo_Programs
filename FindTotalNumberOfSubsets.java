/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Stack;
/**
 * program to find number of subsets that add upto the a given sum. 
 * each element in the set can be used only once. 
 * repetition in the set is allowed
 * for example give the number of subsets of number that add to 8 in the set
 * {3,3,4,5,6,2,2,1,1,1,8,7,6,6,5,5,4,4} 
 * @author anupam
 */
public class FindTotalNumberOfSubsets {
    int numberOfSubsets(int[] inputArray, int targetSum) {
        int count=0,i,previousSum=0,currentSum=0;
        Stack<Integer> s = new Stack<>();
        Arrays.sort(inputArray);
        for(i=0;i<inputArray.length;i++) {
            if(targetSum<=inputArray[i])
                break;
        }
        if(i==inputArray.length)
            i--;
        for(int j=0;j<=i;j++) {
            currentSum += inputArray[j];
        }
        do {
            s.clear();
            int temp = 0;
            for(int j=i;j>=0;j--) {
                if(inputArray[j] !=0) {
                    temp += inputArray[j];
                    s.push(j);
                }
                if(temp == targetSum) {
                    temp =0;
                    count++;
                    while(!s.isEmpty()) 
                        inputArray[s.pop()] = 0;
                }
                else if(temp > targetSum) {
                    temp = temp - inputArray[s.pop()];
                }
            }
            if(previousSum == currentSum)
                inputArray[s.pop()] = 0;
            previousSum = currentSum;
            currentSum = 0;
            for(int j=0;j<=i;j++) {
                currentSum += inputArray[j];
            }
        } while(!s.isEmpty() || previousSum != currentSum);
        return count;
    }
    
    
    public static void main(String[] args) {
        int[] inputArray = {3,3,4,5,6,2,2,1,1,1,8,7,6,6,5,5,4,4} ;
        FindTotalNumberOfSubsets f = new  FindTotalNumberOfSubsets();
        System.out.println(f.numberOfSubsets(inputArray,8));
    }
}
