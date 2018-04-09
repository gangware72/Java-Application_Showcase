package shortestPath;

public class TestObject {
	
	private AdjacencyMatrix[] graphs = {null, null, null, null, null};
	private int counter;
	
	public TestObject(){
		
		this.counter =0;
		
	}
	
	public AdjacencyMatrix getGraph(int i) {
		return graphs[i];
	}
	
	public void addToGraphs(AdjacencyMatrix a){
		
		graphs[counter] = a;
		this.counter++;
		
	}

}
