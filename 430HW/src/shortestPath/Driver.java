package shortestPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		
		File graph1 = new File("Graph1");
		File graph2 = new File("Graph2");
		File graph3 = new File("Graph3");
		File graph4 = new File("Graph4");
		File graph5 = new File("Graph5");
		
		AdjacencyMatrix matrix1 = new AdjacencyMatrix();

		matrix1.setVertexes();
		
			
		matrix1.setGraph(graph1);
		
		AdjacencyMatrix matrix2 = new AdjacencyMatrix();
		matrix2.setVertexes();
		matrix2.setGraph(graph2);

		AdjacencyMatrix matrix3 = new AdjacencyMatrix();
		matrix3.setVertexes();
		matrix2.setGraph(graph3);
		
		AdjacencyMatrix matrix4 = new AdjacencyMatrix();
		matrix4.setVertexes();
		matrix2.setGraph(graph4);
		
		AdjacencyMatrix matrix5 = new AdjacencyMatrix();
		matrix5.setVertexes();
		matrix5.setGraph(graph5);
		
		System.out.print("GRAPH 1 - SHORTEST ROUTE START\n--------------------------------------\n");
			System.out.println("Start: " + matrix1.getVertexs().get(0).toString());
			System.out.println("Destination: " + matrix1.getVertexs().get(13).toString());
	
			ArrayList<Vertex> MST = matrix1.findMST(matrix1.getVertexs().get(0), matrix1.getVertexs().get(13));
	
			
			System.out.println("PATH " + constructShortestPath(MST, matrix1.getVertexs().get(13)));
		
		
		System.out.print("GRAPH 2 - SHORTEST ROUTE START\n--------------------------------------\n");
			System.out.println("Start: " + matrix2.getVertexs().get(3).toString());
			System.out.println("Destination: " + matrix2.getVertexs().get(14).toString());
	
			ArrayList<Vertex> MST2 = matrix2.findMST(matrix2.getVertexs().get(3), matrix2.getVertexs().get(14));
	
			
			System.out.println("PATH " + constructShortestPath(MST2, matrix2.getVertexs().get(14)));
		
		System.out.print("GRAPH 3 - SHORTEST ROUTE START\n--------------------------------------\n");
			System.out.println("Start: " + matrix3.getVertexs().get(0).toString());
			System.out.println("Destination: " + matrix3.getVertexs().get(13).toString());
	
			ArrayList<Vertex> MST3 = matrix3.findMST(matrix1.getVertexs().get(0), matrix3.getVertexs().get(13));
	
			
			System.out.println("PATH " + constructShortestPath(MST3, matrix3.getVertexs().get(13)));
		
		System.out.print("GRAPH 4 - SHORTEST ROUTE START\n--------------------------------------\n");
			System.out.println("Start: " + matrix4.getVertexs().get(7).toString());
			System.out.println("Destination: " + matrix4.getVertexs().get(2).toString());
	
			ArrayList<Vertex> MST4 = matrix4.findMST(matrix1.getVertexs().get(7), matrix4.getVertexs().get(2));
	
			
			System.out.println("PATH " + constructShortestPath(MST4, matrix4.getVertexs().get(2)));
		
		System.out.print("GRAPH 5 - SHORTEST ROUTE START\n--------------------------------------\n");
			System.out.println("Start: " + matrix5.getVertexs().get(4).toString());
			System.out.println("Destination: " + matrix5.getVertexs().get(6).toString());
	
			ArrayList<Vertex> MST5 = matrix5.findMST(matrix5.getVertexs().get(4), matrix5.getVertexs().get(6));
	
			
			System.out.println("PATH " + constructShortestPath(MST5, matrix5.getVertexs().get(6)));
		


	}
	
	public static String constructShortestPath(ArrayList<Vertex> mst, Vertex dest) {
		Queue q = new Queue();
		String path = "";
		int predesseor_position;
		
		while (dest.getPredecessor() < 16) {
			q.enque(dest);
		
			predesseor_position =  mst.get(mst.indexOf(dest)).getPredecessor();
			
			dest = mst.get(predesseor_position-1);
			
		}
		
			q.enque(dest);
		
		while(q.getSize()>0){
			path = path + q.pop() + "\nThen...";
			
			
		}
		path = path + "you are finished!";
		return path;
	}

}
