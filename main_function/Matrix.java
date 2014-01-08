package main_function;
import java.io.*;


public class Matrix  {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	//this method is use for stating matrix dimension
	public double[][] martrixDim(int row,int col){
		double[][] matrix;
		matrix=new double[row][col];
		return matrix;
	}
	
	//this method is for printing matrix
	public void printmatrix(double[][] m1){
		int Row=m1.length;
		int Col=m1[0].length;
		
		for(int a=0;a<Row;a++){
			System.out.print("|");
			for(int b=0;b<Col;b++){
				System.out.print(m1[a][b]+" ");
			}
			System.out.print("|");
			System.out.println();			
		}
	}
	
	//this method is use for set up the entries for the matrix
	public double[][] setMatrix() throws IOException{
		String[] NumberStrings;
		String numbers;
		double[][] matrix;
		int Row=0, Col=0;
		
		while(Row==0||Col==0){
			System.out.println("Enter the Dimension for Matrix(ie. NumxNum):");
			numbers = in.readLine();
			NumberStrings=numbers.split("x");
			if(NumberStrings.length==2){
				Row=Integer.parseInt(NumberStrings[0]);
				Col=Integer.parseInt(NumberStrings[1]);
			}
			
			if(Row==0||Col==0){
				System.out.println("Invalid Row or Column, enter the correct Dimension!");			
			}
		}
		matrix=martrixDim(Row,Col);
		
		if(Row!=0&&Col!=0){
			for (int a=0;a<Row;a++){
				int b=a+1;
				System.out.print("Enter "+b+" row:");
				numbers = in.readLine();
				NumberStrings=numbers.split(" ");
				if (NumberStrings.length==Col){
					for (int d=0;d<Col;d++){
						matrix[a][d]=Double.parseDouble(NumberStrings[d]);
					}
				}
				else{
					System.out.println("number of colum doesn't match");
					a--;
				}
			}
		}
		else{
			System.out.println("Please indicate the dimension of Matrix first!");
		}
		
		return matrix;
	}
	
	
}
