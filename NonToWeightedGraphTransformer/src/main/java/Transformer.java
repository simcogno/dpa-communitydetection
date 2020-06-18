import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Transformer {
	
	public List<Edge> edges;
	public List<WeightedEdge> wEdges;
	public Edge e;
	
	
	public Transformer() {
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
		} else if (e1.getU().equals(e2.getV()) && e1.getV().equals(e2.getU())) {
			return true;
		}
		return false;
	}
	
	// Takes O(n^2) but does not require sorted input and checks double direction of edges
	public void convertToWeightedEdgesNTwo() {
		for(int index = 0; index < edges.size(); index++) {
			Edge current = edges.get(index);
			int counter = 1;
			for(int j = index+1; j < edges.size(); j++) {
				Edge currentJ = edges.get(j);
				if(compare(current, currentJ)) {
					counter++;
					edges.remove(currentJ);
					j--;
				}
			}
			WeightedEdge wE = new WeightedEdge(current.getU(), current.getV(), counter);
			wEdges.add(wE);
		}
	}
	
	// Takes O(n) but requires sorted input and does not check double direction of edges
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
	
	public void createEdgesFromTxt(String filePath) {
		List<String> values = new ArrayList<String>();
		Scanner sc2 = null;
	    try {
	        sc2 = new Scanner(new File(filePath));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();  
	    }
	    while (sc2.hasNextLine()) {
	            Scanner s2 = new Scanner(sc2.nextLine());
	        while (s2.hasNext()) {
	            String s = s2.next();
	            //System.out.println(s);
	            values.add(s);
	        }
	    }
	    for (int index = 1; index < values.size(); index++) {
	    	Edge e = new Edge(values.get(index-1), values.get(index));
	    	edges.add(e);
	    	index++;
	    }
	}
	
	public void writeWeightedEdgesToTxt(String filePath) {
		try {
            FileWriter writer = new FileWriter(filePath, true);
            for(WeightedEdge wE : wEdges) {
            	String u = wE.getU();
            	String v = wE.getV();
            	String w = String.valueOf(wE.getW());
            	writer.write(u);
            	writer.write(" ");
            	writer.write(v);
            	writer.write(" ");
            	writer.write(w);
            	writer.write("\r\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
