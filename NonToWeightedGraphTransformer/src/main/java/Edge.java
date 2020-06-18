
public class Edge {
	
	private String u, v;
	
	public Edge(String u, String v) {
		this.u = u;
		this.v = v;
	}
	
	public String getU() {
		return u;
	}
	
	public String getV() {
		return v;
	}
	
	public void print() {
		System.out.println(u + " " + v);
	}

}
