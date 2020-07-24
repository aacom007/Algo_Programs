import java.util.*;

public class RemoveDuplicates{
	public static void main(String [] ar) {
		 int [] aer = new int[] {1,3,5,5,5,5,6,7,7,8,8,9};
		 int p = -1;
		 for(int i=0;i<aer.length-1;i++) { //O(n),  O(1)
			 if(p==i-1) {
				 p=i;
			 }
			 while(aer[i]==aer[i+1]) {
				 i++;
				 System.out.print(aer[i]+"- ");
			 }
			 if(p!=i) {
				 aer[p+1]=aer[i+1];
				 p++;
			 }
		 }
		 
		 System.out.println(" ");
		 int [] r = Arrays.copyOfRange(aer,0,p+1);
		 for(int j=0;j<r.length;j++) {
			 
			 System.out.print(r[j]+", ");
		 }
		 
	}
}
