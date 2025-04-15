package Algorithm_2;

import java.util.ArrayList;

class EdgeList{
	int startVertex;
	int endVertex;
	int weight; 
	
	EdgeList(int startVertex,int endVertex,int weight){
		this.startVertex=startVertex;
		this.endVertex=endVertex;
		this.weight=weight;
	}

}


class EdgeListGraph{
	ArrayList<EdgeList> EdgeList;
	int size;
	public EdgeListGraph(int v) {
		// TODO Auto-generated constructor stub
		this.size=v;
		this.EdgeList=new ArrayList<>();
	}
	public EdgeListGraph() {
		// TODO Auto-generated constructor stub
	}
	
	void addEdge(int vertex1,int vertex2,int weight) {
		EdgeList.add(new EdgeList(vertex1,vertex2,weight));
	}
	
}

public class EdgeListImplmentation {
	public static void main(String[] args) {
		EdgeListGraph edg=new EdgeListGraph();
		edg.addEdge(0, 1, 1);
		edg.addEdge(1, 2, 3);
		edg.addEdge(2, 0, 6);
	}
}
