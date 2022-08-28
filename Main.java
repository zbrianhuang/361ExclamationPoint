import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		
		ArrayList<Integer> outputArrList = new ArrayList<Integer>();
		
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
		outputArrList = reverseArrayList(factorial(input));
			
		try {
			File outputFile = new File("output.txt");
			FileWriter w = new FileWriter(outputFile);
			Integer cast;
			for(int i: outputArrList) {
				cast = i;
				w.write(cast.toString());

			}
			w.close();
			System.out.println("Total Size: "+outputArrList.size());
			
		}catch(Exception e) {
			System.out.println("error");
			System.out.println(e.getMessage());
		}
		
	}
	/*
	public static ArrayList<String> convertToDecimal(ArrayList<Integer> input){
		
	}
	*/
	public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> input){
		 ArrayList<Integer> out = new ArrayList<Integer>();
	        for (int i = input.size() - 1; i >= 0; i--) {

	            out.add(input.get(i));
	        }

	        return out;
	}
	public static ArrayList<Integer> factorial(int in){

		ArrayList<Integer> result=new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		result.add(1);
		int progress=0;
		double percent;
		if(in>10) {
			
		
			for(int i= 2;i<=in;i++) {
				result=multiplyBinary(result,convertToBinary(i));
				percent=(double)i/in*100;
			//System.out.println(percent+" "+progress);
				if(percent>progress*10){
					
					System.out.println(progress*10+"% ");
					progress++;
				}
			}
		}else {
			for(int i= 2;i<=in;i++) {
				result=multiplyBinary(result,convertToBinary(i));
				percent=(double)i/in*100;
				//System.out.println(percent+" "+progress);
				
			}
		}
		/*for(int j = 0;j<productList.size();j++) {
			result=addBinary(result,productList.get(j));
		}
		*/
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

				singleProduct.add(0,0);
			}
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

			subProducts.add(singleProduct);
			baseCount++;
			
		//
		
		}
		//
		
		
		for(int i= 0;i<subProducts.size();i++) {
			product=addBinary(product,subProducts.get(i));
			
			
		}
		for(int sd: product) {
			//System.out.print(sd);
		}
		//System.out.println("done");
		
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
