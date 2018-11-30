package practice;

public class MyPoint2 {

	public MyPoint2(){

		int x=0;
		int y=0;

		System.out.println("初期値は("+x+","+y+")です");
	}

	public MyPoint2(int x,int y){

		if(x<100 && 0<x && y<100 && y>0){
		  System.out.println("初期値は("+x+","+y+")です");
		}
		else{
			System.out.println("error");
		}
}
}
