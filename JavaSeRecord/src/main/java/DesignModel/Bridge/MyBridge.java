package DesignModel.Bridge;

public class MyBridge extends Bridge{
	@Override
    public void method(){
        getSource().method();  
    } 
}
