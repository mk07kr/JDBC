package mkJDBC;


public class tryJDBC {

	public static void main(String[] args){
	Func_setUp a1=new Func_setUp();
	try {
//	a1.establishConnection();
//a1.createDatabase();
//	a1.createTable();
//		a1.insertData();
		a1.readData();
		a1.insertDynamicData();
		a1.readData();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	System.out.println("End of the Program !");
	}
}