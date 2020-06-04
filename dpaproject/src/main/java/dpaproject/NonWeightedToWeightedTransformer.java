package dpaproject;

import java.util.ArrayList;
import java.util.List;


public class NonWeightedToWeightedTransformer { 
		
	public List<Edge> edges;
	public List<WeightedEdge> wEdges;
	public Edge e;
	
	
	public NonWeightedToWeightedTransformer() {
		edges = new ArrayList<Edge>();
		wEdges = new ArrayList<WeightedEdge>();
	}
	
	public void printEdges() {
		for (Edge edge : edges) { 		      
	           edge.print(); 		
	      }
	}
	
	public void printWEdges() {
		for (WeightedEdge edge : wEdges) { 		      
	           edge.print(); 		
	      }
	}
	
	public boolean compare(Edge e1, Edge e2) {
		if(e1.getU().equals(e2.getU()) && e1.getV().equals(e2.getV())) {
			return true;
		}
		return false;
	}
	
	public void convertToWeightedEdges() {
		int counter = 1;
		for (int index = 1; index < edges.size(); index++) {
			Edge current = edges.get(index);
			Edge previous = edges.get(index-1);
			
			if(compare(current, previous)) {
				counter++;
			} else {
				String u = edges.get(index-1).getU();
				String v = edges.get(index-1).getV();
				WeightedEdge wE = new WeightedEdge(u, v, counter);
				wEdges.add(wE);
				counter = 1;
			}
			
			if(index+1 == edges.size()) {
				String u = edges.get(index).getU();
				String v = edges.get(index).getV();
				WeightedEdge wE = new WeightedEdge(u, v, counter);
				wEdges.add(wE);
			}
			
	      }   	
	}
	
	public void createEdges() {
		
		    e = new Edge("2", "3");
		    edges.add(e);
		    
		    e = new Edge("2", "5");
		    edges.add(e);
		    
		    e = new Edge("2", "5");
		    edges.add(e);
		    
		    e = new Edge("2", "5");
		    edges.add(e);
		    
		    e = new Edge("4", "9");
		    edges.add(e);
		    
		    e = new Edge("4", "9");
		    edges.add(e);
		    
		    e = new Edge("6", "3");
		    edges.add(e);
		    
		    e = new Edge("8", "9");
		    edges.add(e);
		    
	}

}

