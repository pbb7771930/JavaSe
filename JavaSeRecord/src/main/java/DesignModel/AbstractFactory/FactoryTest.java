package DesignModel.AbstractFactory;


public class FactoryTest {
	public static void main(String[] args) {  
		Provider provider = new DesignModel.AbstractFactory.SendMailFactory();
        Sender sender = provider.produce();  
        sender.send();   
    }  
}
