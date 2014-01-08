package main_function;

import java.io.IOException;




public class LinearAlgebraMainFunction {


	public static void main(String[] args) throws IOException {
		
		Matrix A= new Matrix();
		MatrixOperation oprt=new MatrixOperation();
		//double[][] m1=A.setMatrix();
		double[][] m2=A.setMatrix();
		//double[][] m3;
		//A.printmatrix(m1);
		//m2=oprt.swap_row(m2,0,2);
		m2=oprt.rref(m2);
		A.printmatrix(m2);
		//m3=oprt.addition(m1,m2);
		//A.printmatrix(m3);
		//m3=oprt.scalarMulti(3,m2);
		//A.printmatrix(m3);1x
		
		
		
		int max=oprt.findmax(m2,1,0);
		System.out.println(max);
		 
	}

}

