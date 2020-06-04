package dpaproject;

public class WeightedEdge {
	
	private String u, v;
	private byte w;
	
	public WeightedEdge(String u, String v, byte w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	public String getU() {
		return u;
	}
	
	public String getV() {
		return v;
	}
	
	public int getW() {
		return w;
	}
	
	public void print() {
		System.out.println(u + " " + v + " " + w);
	}

}
