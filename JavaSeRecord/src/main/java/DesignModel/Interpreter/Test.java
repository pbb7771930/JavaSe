package DesignModel.Interpreter;

/**
 * @author admin
 */
public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int result = new Minus().interpret((new Context(new Plus().interpret(new Context(9, 2)), 8)));
        System.out.println(result);  
	}

}
