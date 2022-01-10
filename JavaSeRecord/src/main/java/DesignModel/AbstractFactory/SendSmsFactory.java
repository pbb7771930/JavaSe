package DesignModel.AbstractFactory;

public class SendSmsFactory implements Provider{

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}
	
}
