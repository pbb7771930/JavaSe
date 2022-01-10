package DesignModel.Memento;

public class Test {
	public static void main(String[] args) {  

        Original origi = new Original("egg");  

        Storage storage = new Storage(origi.createMemento());  

        System.out.println("" + origi.getValue());
        origi.setValue("niu");  
        System.out.println("" + origi.getValue());

        origi.restoreMemento(storage.getMemento());  
        System.out.println("" + origi.getValue());
    }
}
