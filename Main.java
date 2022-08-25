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
		for(int i: factorial(input)) {
			System.out.print(i);
		}
		
		
	}
	public static ArrayList<Integer> factorial(int in){
		ArrayList<ArrayList<Integer>> productList=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> result=new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		productList.add(temp);
		for(int i= 0;i<in;i++) {
			productList.add(multiplyBinary(productList.get(i),convertToBinary(i+1)));
		}
		for(int j = 0;j<productList.size();j++) {
			result=addBinary(result,productList.get(j));
		}
		return result;
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
		//product.add(0);
		ArrayList<ArrayList<Integer>> subProducts= new ArrayList<ArrayList<Integer>>();
		String intAsChar;
		char temp;
		int smallerArraySize = a.size();
		int largerArraySize = b.size();
		boolean aIsBigger=false;
		int baseCount = 0;
		ArrayList<Integer> singleProduct = new ArrayList<Integer>();
		if(b.size()<a.size()) {
			aIsBigger=true;
			smallerArraySize=b.size();
			largerArraySize=a.size();
		}
		
	
		for(int j = 0;j<smallerArraySize;j++) {
			
			
			singleProduct=new ArrayList<Integer>();

			for(int k= 0;k<baseCount;k++) {
				System.out.println("added "+k+" zeros");
				singleProduct.add(0,0);
			}
			System.out.println();
			
			for(int i= 0;i<largerArraySize;i++) {
				
				
				
				
				if(aIsBigger) {
					if(b.get(j)==1) {
						singleProduct.add(a.get(i));
					}else {
						singleProduct.add(0);
					}
				}else {
					if(a.get(j)==1) {
						singleProduct.add(b.get(i));

					}else {
						singleProduct.add(0);
					}
					
				}

			}
			System.out.println("base "+baseCount);
			
			subProducts.add(singleProduct);
			baseCount++;
			
		//
			for(ArrayList<Integer> it: subProducts) {
				for( int sdf: it) {
					System.out.print(+sdf);
					
				}
				System.out.println("Subproduct");
				
			}
		}
		//
		
		
		for(int i= 0;i<subProducts.size();i++) {
			product=addBinary(product,subProducts.get(i));
			
			
		}
		
			
		
		System.out.println();
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
		int diff;
		if(a.size()>b.size()) {
			diff=a.size()-b.size();
			for(int i= 0;i<diff;i++) {

				b.add(0);
			}
			//b.add(0);//idk man it works.
		}
		if(b.size()>a.size()) {
			diff=b.size()-a.size();
			for(int i= 0;i<diff;i++) {

				a.add(0);
			}
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
