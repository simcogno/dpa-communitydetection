package dpaproject;

public class Main {

	public static void main(String[] args) {

		NonWeightedToWeightedTransformer transformer = new NonWeightedToWeightedTransformer();
		transformer.createEdges();
		transformer.convertToWeightedEdges();
		transformer.printWEdges();
	}

}
