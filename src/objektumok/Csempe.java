package objektumok;

import java.util.ArrayList;

import skeletonApp.Skeleton;

/** */
public class Csempe {
	/** */
	public Csempe getNeigbour(int irany) {
		Skeleton.print(this, "getNeighbour", irany);
		Skeleton.ret();
		return null; // TODO
	}
	
	/** */
	public void accept(Allat a) {
		Skeleton.print(this, "accept", a);
		Skeleton.ret();
	}
	
	/** */
	public Dolog getDolog() {
		Skeleton.print(this, "getDolog");
		Skeleton.ret();
		return null; // TODO
	}
	
	/** */
	public void setDolog(Dolog d) {
		Skeleton.print(this, "setDolog", d);
		Skeleton.ret();
	}
	
	/** */
	public void setNeighbour(int irany, Csempe c) {
		Skeleton.print(this, "setNeighbour", irany, c);
		Skeleton.ret();
	}
	
	/** */
	public void ugrott() {
		Skeleton.print(this, "ugrott");
		Skeleton.ret();
	}
	
	public ArrayList<Integer> getIranyok() {
		return new ArrayList<Integer>(); //TODO
	}
}
