package AI;

public class Cell {
	private boolean u,l,d,r;
	private int value,x,y;
	public Cell(boolean u,boolean d,boolean r,boolean l) {
		this.u=u;
		this.l=l;
		this.d=d;
		this.r=r;
		this.setValue(0);
		this.x=0;
		this.y=0;
	}
	
	

	public boolean isU() {
		return u;
	}

	public void setU(boolean u) {
		this.u = u;
	}

	public boolean isL() {
		return l;
	}

	public void setL(boolean l) {
		this.l = l;
	}

	public boolean isD() {
		return d;
	}

	public void setD(boolean d) {
		this.d = d;
	}

	public boolean isR() {
		return r;
	}

	public void setR(boolean r) {
		this.r = r;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public void incValue() {
		this.value+=2;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
