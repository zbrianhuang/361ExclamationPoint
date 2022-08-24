package factorialCalculator;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		/*
		ArrayList<Integer> intList = new ArrayList<>();
		int counter = 0;
		try {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			System.out.println(counter);
			intList.add(null);
			counter++;
		}
		}catch(Exception e) {
			System.out.println(e.getMessage()+counter);
		}
		System.out.println(intList.size());
		
		*/
		
		boolean pass=false;
		int input=0;
		
		Scanner in = new Scanner(System.in);
		for(int i: addBinary(convertToBinary(1),convertToBinary(9))) {
			System.out.print(i);
		}
		

		while(!pass) {
			System.out.println("Input:");
			try {
				input = in.nextInt();
				pass = true;
			}catch(Exception e) {
				System.out.println("Invalid Input.");
				in.next();
			}
			if(input<1) {
				pass=false;
			}
		}
		
		
		
	}
	public static ArrayList<Integer> convertToBinary(int in) {
	//public static void convertToBinary(int in) {
		ArrayList<Integer> binaryArray = new ArrayList<Integer>();
		String strBuild="";
		Integer temp;
		while(in>0) {
			temp = in%2;
			//binaryArray.add(0,temp);
			binaryArray.add(temp);
			strBuild+=temp.toString();
			in/=2;
		}

		return binaryArray;
	}
	public static ArrayList<Integer> multiplyBinary(ArrayList<Integer> a, ArrayList<Integer> b){ 
		ArrayList<Integer> product= new ArrayList<Integer>();
		ArrayList<Integer> subProducts= new ArrayList<Integer>();
		String intAsChar;
		char temp;
		for(int i= 0;i<a.size();i++) {
			intAsChar = a.get(i).toString();
			temp = intAsChar.charAt(0);
			
		}
		return product;
	}
	//numbers should be inputted backwards
	//example 10 would be inpputed at 0101
	//numbers will be outputted backwards (small to large)
	public static ArrayList<Integer> addBinary(ArrayList<Integer> a, ArrayList<Integer> b){ 
		ArrayList<Integer> sum= new ArrayList<Integer>();
		ArrayList<Integer> subProducts= new ArrayList<Integer>();
		String intAsChar;
		int regroup=0;
		int digit;
		if(a.size()>b.size()) {
			for(int i= 0;i<a.size()-b.size();i++) {
				b.add(0);
			}
		}
		if(b.size()>a.size()) {
			for(int i= 0;i<b.size()-a.size();i++) {
				a.add(0);
			}
		}
		
		for(int r:a) {
			System.out.println("A:"+r);
		}
		for(int q:b) {
			System.out.println("B:"+q);
		}
		
		for(int i= 0;i<a.size();i++) {
			digit=regroup+a.get(i)+b.get(i);
			switch(digit) {
			case 2:
				digit-=2;
				regroup=1;
				break;
			case 3:
				digit-=2;
				regroup =1;
				break;
			default:
				regroup=0;
				break;
			}
			sum.add(digit);
			
			
		}
		if(regroup!=0) {
			sum.add(1);
		}
		return sum;
	}
}
