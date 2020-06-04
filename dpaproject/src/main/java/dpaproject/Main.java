package dpaproject;


public class Main {

	public static void main(String[] args) {

		NonWeightedToWeightedTransformer transformer = new NonWeightedToWeightedTransformer();
		// transformer.createEdges();
		transformer.createEdgesFromTxt("src/main/resources/nonWeightedGraph.txt");
		transformer.convertToWeightedEdges();
		System.out.println("NON weighted edges:");
		transformer.printEdges();
		System.out.println("Now weighted edges:");
		transformer.printWEdges();
		transformer.writeWeightedEdgesToTxt("src/main/resources/WeightedGraph.txt");
		
	}

}
