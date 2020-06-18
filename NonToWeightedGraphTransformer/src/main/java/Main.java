
public class Main {
	
	public static void main(String[] args) {
		
		String inputFile = "src/main/resources/first-10-seconds-text.txt";
		String outputFile = "src/main/resources/weighted-first-10-seconds-text.txt";
				

		Transformer transformer = new Transformer();		
		transformer.createEdgesFromTxt(inputFile);
		transformer.convertToWeightedEdgesNTwo();
		transformer.writeWeightedEdgesToTxt(outputFile);
		System.out.println("Transformation is finished!");
	}

}
