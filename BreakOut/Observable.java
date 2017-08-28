package BreakOut;

public interface Observable {
	
	public void register(Observer o);
	public void removeRegister(Observer o);
	public void notifyObservers();
	
}
