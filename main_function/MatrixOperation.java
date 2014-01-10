package main_function;

public class MatrixOperation {
	
	//this method is for adding two matrix
	public double[][] addition(double[][] m1,double[][] m2){
		int row1=m1.length;
		int row2=m2.length;
		int col1=m1[0].length;
		int col2=m2[0].length;
		double[][] result=new double[row1][col1];
		if (row1==row2&&col1==col2){
			for(int a=0;a<row1;a++){
				for(int b=0;b<col1;b++){
					result[a][b]=m1[a][b]+m2[a][b];
				}
			}
		}
		else{
			System.out.println("Two matrix cannot be added due to different Dimension");
		}
		return result;
	}
	
	//this method is for scalar multiple of an matrix
	public double[][] scalarMulti(int scalar,double[][] m1){
		int row=m1.length;
		int col=m1[0].length;
		double[][] result=new double[row][col];
		
		if (row!=0 && col!=0){//Run for proper defined matrix(ie. the row and col are nonzero)
			for(int a=0;a<row;a++){
				for(int b=0;b<col;b++){
					result[a][b]=scalar*m1[a][b];//multiply each entry with the scalar
				}
			}
		}
		else{
			System.out.println("The matrix is not defined properly!");//error message
		}
		return result;
	}
	
	//this method is for finding the row that contain the maximum entry in a specific col
	public int findmax(double[][] input,int start_pt,int col){
		double[][] result=input;
		int row=result.length;
		int max_row=start_pt;
		for(int a=start_pt++;a<row;a++){//find the maximum
			if(result[a][col]>result[max_row][col]){
				max_row=a;
			}
		}		
		return max_row;
	}
	
	//this method is for swapping two rows within a matrix
	public double[][] swap_row(double[][] input,int row,int target){
		double[][] result=input;
		double[] temp=result[row];
		result[row]=result[target];
		result[target]=temp;		
		return result;
	}
	
	//this method is for performing operation between two rows so the leading entry become zero
	public double[] rowoperation(double[] row, double[] input,int j){
		int col=input.length;
		double scalar=input[j];
		double[] result=input;
		for (int a=j;a<col;a++){
			result[a]=result[a]-scalar*row[a];
		}
		return result;
	}
			
	//this method turn input matrix into RREF
	public double[][] rref(double[][] m1){
		int row=m1.length;
		int col=m1[0].length;
		double[][] result= m1;
		int i=0;
		int j=0;
		
		while(i<row&&j<col){
			//find the row with the maximum entry
			int max_row=this.findmax(result,i,j);
			//check if the column is singular ie.(only have one non-zero entry)
			if(result[max_row][j]!=0){
			//swap the ith row with the max_row
				result=this.swap_row(result,i,max_row);
			//divede the ith row with result[i][j]entry
				for(int b=0;b<col;b++){
					result[i][b]=result[i][b]/result[i][j];
				}
			//perform row operation on i+1 rows to make their jth column zero
				for(int u=i+1;u<row;u++){
					result[u]=rowoperation(result[i], result[u],j);
				}
				i+=1;
			}
			j+=1;
		}
		
		i--;
		j--;
		//the following part is for solving the upper triangular matrix
		while(i>=0&&j>=0){
			for(int a=0;a<col;a++){//find the column that contain leading one1
				if(result[i][a]==1){
					j=a;
				}
			}
			for(int u=i-1;u>=0;u--){
				result[u]=rowoperation(result[i], result[u],j);//perform row operation to convert matrix to rref
			}
			i-=1;
		}
		return result;
			
	}
	
	//this method transpose matrix
	public double[][] transpose(double[][] m1){
		int row=m1.length;
		int col=m1[0].length;
		double[][] result = new double[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				result[i][j]=m1[j][i];
			}
		}
		
		return result;
	}
	
	//this is the method for calculating dot product
	
	public double dotproduct(double[] entry1,double[] entry2){
		double result=0;
		int length=entry1.length;
		for(int a=0;a<length;a++){
			result+=entry1[a]*entry2[a];
		}
		return result;
	}

	//this method is for computing the product of two matrix
	public double[][] matrixproduct(double[][] m1, double[][] m2){
		int row1=m1.length;
		int row2=m2.length;
		int col1=m1[0].length;
		int col2=m2[0].length;
		double[][] result=new double[row1][col2];
		double[][] m2transp=this.transpose(m2);
		if(col1==row2){
			for (int j=0;j<col2;j++){
				for(int i=0;i<row1;i++){
					result[i][j]=this.dotproduct(m1[i], m2transp[j]);
				}
			}
		}
		else{
			System.out.println("Matrices cannot be multiple due to dimension mismatch(ie.col1=row2)");
		}
		return result;
	}
}
