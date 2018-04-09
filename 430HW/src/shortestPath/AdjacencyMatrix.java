package shortestPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdjacencyMatrix {
	
	private int[][] matrix;
	private ArrayList<Edge> masteredgelist;
	private ArrayList<Vertex> vertexes;
	
	
	public AdjacencyMatrix(){
		matrix = new int[15][15];
		masteredgelist = new ArrayList<Edge>();
		vertexes = new ArrayList<Vertex>();
		
		
		
		
	}
	
	public int[][] getGraph(int graphNumber){
		return matrix;
	}
	
	public ArrayList<Edge> getEdgeList() {
		return masteredgelist;
	}
	
	public void setVertexes() {
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Vertex four = new Vertex(4);
		Vertex five = new Vertex(5);
		Vertex six = new Vertex(6);
		Vertex seven = new Vertex(7);
		Vertex eight = new Vertex(8);
		Vertex nine = new Vertex(9);
		Vertex ten = new Vertex(10);
		Vertex eleven = new Vertex(11);
		Vertex tweleve = new Vertex(12);
		Vertex thirteen = new Vertex(13);
		Vertex fourteen = new Vertex(14);
		Vertex fifteen = new Vertex(15);
		vertexes.add(one);
		vertexes.add(two);
		vertexes.add(three);
		vertexes.add(four);
		vertexes.add(five);
		vertexes.add(six);
		vertexes.add(seven);
		vertexes.add(eight);
		vertexes.add(nine);
		vertexes.add(ten);
		vertexes.add(eleven);
		vertexes.add(tweleve);
		vertexes.add(thirteen);
		vertexes.add(fourteen);
		vertexes.add(fifteen);

	


			
			
		
	}
	
	public ArrayList<Vertex> getVertexs() {
		return vertexes;
	}
	
	
	public void setGraph(File f) throws FileNotFoundException {
		Scanner input = new Scanner(f);
		for (int i=0; i < 15; i++) { //columns
			
			for (int j=0; j<15; j++) {  //rows
				
				matrix[i][j] = input.nextInt();
				
				if (matrix[i][j] > 0) {
					Edge nu = new Edge(i + 1, j + 1);
					masteredgelist.add(nu);
					vertexes.get(i).getEdgelist().add(nu);
				
				
			}
		
		}	
		}
		input.close();
	}
	
	public ArrayList<Vertex> findMST(Vertex source, Vertex destination){
		ArrayList<Vertex> MST = new ArrayList<Vertex>();
		
		source.setState(1);
		Queue q = new Queue();
		q.enque(source);
		
		while (q.getSize() > 0) {
			
			Vertex u = q.deque();
			
			MST.add(u);
			
			for (Edge e: u.getEdgelist()){
				Vertex adjToCurrent = vertexes.get(e.getFinish()-1);

				if (adjToCurrent.getState() == 0) {
					adjToCurrent.setState(1);
					adjToCurrent.incrementDistance(u.getDistance() + 1);
					adjToCurrent.setPredecessor(u.getNumber());
					
					q.enque(adjToCurrent);
				}
				
				
				
			}
			u.setState(2);
			
			Vertex v = destination;
		}
		
		return MST;
	}
	
	public String matrixToString(){
		return Arrays.deepToString(matrix);
	}
	
	public String edgelistToString(){
		return masteredgelist.toString();

	}
	
	public String vertexesToString(){
		return vertexes.toString();
	}

}

class Vertex {
	
	private int number;
	private int predecessor;
	private int state; // 0 for undiscovered, 1 for considered, 2 for visited
	private ArrayList<Edge> edgelist;
	private int distance;
	
	public Vertex(int n){
		number = n;
		state = 0;
		distance =0;
		predecessor = 16;
		edgelist = new ArrayList<Edge>();
	}
	
	public void setNumber(int i){
		number = i;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setPredecessor(int v) {
		predecessor = v;
	}
	
	public int getPredecessor() {
		return predecessor;
	}
	
	public void addEdge(Edge e) {
		edgelist.add(e);
	}
	
	public void setState(int s){
		state = s;
	}
	
	public int getState(){
		return state;
	}
	
	public void incrementDistance(int d){
		this.distance =d;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public ArrayList<Edge> getEdgelist(){
		return edgelist;
	}
	
	public String toString() {
		return "\nVertex" + number + ", Distance = " + distance + ", Predesseor ="+ predecessor;
	}
}

class Edge {
	
	int u;
	int v;
	
	public Edge(int start, int finish) {
		u = start;
		v = finish;
	}
	
	int getStart(){
		return this.u;
	}
	
	int getFinish(){
		return this.v;
	}
	
	Edge getEdge(){
		return this;
	}
	
	void setEdge(int u, int v){
		this.u = u;
		this.v = v;
	}
	
	public String toString(){
		return "(" + u + ", " + v + ")";
	}
}

class Queue {
	
	private ArrayList<Vertex> queue;
	private int size;
	
	public Queue(){

		queue = new ArrayList<Vertex>();
		size = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public void enque(Vertex v){
		queue.add(v);
		size++;
	}
	
	public Vertex deque() {
		Vertex v = queue.remove(0);
		size--;
		return v;
	}
	
	public String toString() {
		return queue.toString();
	}
	
	public Vertex pop() {
		Vertex v = queue.remove(queue.size()-1);
		size--;
		return v;
	}
}
