package dpaproject;


public class Main {

	public static void main(String[] args) {

		NonWeightedToWeightedTransformer transformer = new NonWeightedToWeightedTransformer();
		transformer.createEdgesFromTxt("src/main/resources/nonWeightedGraph.txt");
		transformer.convertToWeightedEdges();
		transformer.writeWeightedEdgesToTxt("src/main/resources/WeightedGraph.txt");
		
	}

}
