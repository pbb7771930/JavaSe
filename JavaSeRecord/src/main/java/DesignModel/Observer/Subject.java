package DesignModel.Observer;

public interface Subject {

    public void add(Observer observer);  

    public void del(Observer observer);  

    public void notifyObservers();  

    public void operation();  
}
