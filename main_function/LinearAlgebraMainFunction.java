package main_function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class LinearAlgebraMainFunction {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Matrix A= new Matrix();
		MatrixOperation oprt=new MatrixOperation();
		String action="start";
		System.out.println("Commands for the function:");
		System.out.println("Matrix Addition=madd");
		System.out.println("Matrix Multiplication=multi");
		System.out.println("Scalar Multipilication=smulti");
		System.out.println("Row reducing=rref");
		System.out.println("Matrix Transpose=tranpose");
		System.out.println("STOP=stop");
		System.out.println();
		
			
		while(action.equals("stop")!=true){
			System.out.println("Enter the operation You want to Perform:");
			int scalar=0;
			action=in.readLine();
			
			if(action.equals("madd")){
				double[][] m1=A.setMatrix();
				double[][] m2=A.setMatrix();
				double[][] m3=oprt.addition(m1,m2);
				System.out.println();
				A.printmatrix(m3);
			}
			else if(action.equals("multi")){
				double[][] m1=A.setMatrix();
				double[][] m2=A.setMatrix();
				double[][] m3=oprt.matrixproduct(m1,m2);
				System.out.println();
				A.printmatrix(m3);
			}
			else if(action.equals("smulti")){
				double[][] m1=A.setMatrix();
				double[][] m3;
				String input=in.readLine();
				scalar=Integer.parseInt(input);
				m3=oprt.scalarMulti(scalar,m1);
				System.out.println();
				A.printmatrix(m3);
				
			}
			else if(action.equals("rref")){
				double[][] m1=A.setMatrix();
				m1=oprt.rref(m1);
				System.out.println();
				A.printmatrix(m1);
				
			}
			else if(action.equals("tranpose")){
				double[][] m1=A.setMatrix();
				m1=oprt.transpose(m1);
				System.out.println();
				A.printmatrix(m1);
			}
		}
		

		//double[][] m3;
		//A.printmatrix(m1);
		//m2=oprt.swap_row(m2,0,2);
		//m3=oprt.matrixproduct(m1,m2);
		//A.printmatrix(m3);
		//m3=oprt.addition(m1,m2);
		//A.printmatrix(m3);
		//m3=oprt.scalarMulti(3,m2);
		//A.printmatrix(m3);1x
		
		
		
		//int max=oprt.findmax(m2,1,0);
		//System.out.println(max);
		 
	}

}

