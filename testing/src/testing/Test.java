package testing;

public class Test {
	int a;
	int b;

	 public void setData(int c ,int d){
	  a = c;
	  b = d;
	 }
	 public void showData(){
	   System.out.println("Value of A ="+a);
	   System.out.println("Value of B ="+b);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test obj = new Test ();
		   obj.setData(2,3);
		   obj.showData();
		   Test  obj1 = new Test ();
		   obj1.setData(4,5);
		   obj1.showData();
	}

}
