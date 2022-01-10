package DesignModel.FactoryMethod;


public class FactoryTest {
	public static void main(String[] args) {  
        //SendFactory factory = new SendFactory();
        //Sender sender = factory.produce("sms");

        Sender sender = SendFactory.staProduceMail();
        sender.send();  
    }  
}
