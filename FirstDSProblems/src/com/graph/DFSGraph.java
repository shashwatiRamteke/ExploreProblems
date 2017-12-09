package com.graph;


//Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree.
// The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same node again.
// To avoid processing a node more than once, we use a boolean visited array.
//For example, in the following graph, we start traversal from vertex 2.
// When we come to vertex 0, we look for all adjacent vertices of it. 2 is also an adjacent vertex of 0.
// If we don’t mark visited vertices, then 2 will be processed again and it will become a non-terminating process.
// A Depth First Traversal of the following graph is 2, 0, 1, 3

import javafx.animation.Animation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DFSGraph {

    static class GraphNode{
        public int i;
        public int j;
        public int value;
        public String status;
    }

     static class Graph{
         int nodes;
        int[][] adjMat ;
        status[] adjMatStatus;

        public Graph(int numberOfNodes){
            this.nodes = numberOfNodes;
            adjMat = new int[numberOfNodes][numberOfNodes];
            adjMatStatus = new status[numberOfNodes];
            for(int i=0;i<numberOfNodes;i++) {
                for (int j = 0; j < numberOfNodes; j++) {
                    this.adjMat[i][j] = 0;
                }
                adjMatStatus[i] = status.NotVisted;

            }
        }


        public void addAnEdgeToGraph(int fromNode, int toNode){
            this.adjMat[fromNode][toNode] = 1;
        }

        public ArrayList<GraphNode> getAdjacencyList(int node){
            ArrayList<GraphNode> adjNodes = new ArrayList<GraphNode>();
            for(int i=0;i<nodes;i++){
                if(adjMat[node][i] == 1) {
                    GraphNode graphNode = new GraphNode();
                    graphNode.value = i;
                    graphNode.status = adjMatStatus[i].toString();
                    graphNode.i = node;
                    graphNode.j = i;
                    adjNodes.add(graphNode);
                }
            }
            return adjNodes;
        }

        public void printMat(){
            for(int i=0;i<nodes;i++) {
                for (int j = 0; j < nodes; j++) {
                    System.out.print(adjMat[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public enum status
    {
        Visted,Visting,NotVisted;
    }

    public static void DFSTraverse(Graph graph)
    {

            mgnv(graph);
           Stack<GraphNode> stack = new Stack<GraphNode>();
           GraphNode node = new GraphNode();
           node.status = status.Visting.toString();
           graph.adjMatStatus[0] = status.Visting;

           stack.push(node);

           while(!stack.isEmpty()){
                GraphNode currNode = stack.peek();
                if(currNode.status.equals(status.Visting.toString())){
                    ArrayList<GraphNode> list = graph.getAdjacencyList(currNode.value);
                    int count = 0;
                    for(GraphNode currEle : list)
                    {
                        if(currEle.status.equals(status.NotVisted.toString())){
                            currEle.status = status.Visting.toString();
                            graph.adjMatStatus[currEle.value] = status.Visting;
                            System.out.print(" " + currEle.value + " ");
                            stack.push(currEle);
                            break;
                        }else
                        {
                            count++;
                        }
                    }
                    if(count == list.size()){
                        GraphNode thisNode = stack.pop();
                        thisNode.status = status.Visted.toString();
                        graph.adjMatStatus[thisNode.value] = status.Visted;
                    }
                }
           }


    }

    public static void mgnv(Graph graph)
    {
        for(int i=0;i<graph.nodes;i++) {
          //  for (int j = 0; j < graph.nodes; j++) {
                graph.adjMatStatus[i] = status.NotVisted;
            //}
        }
    }

    public static void main(String[] args) {
        Graph newGraph = new Graph(6);
        newGraph.addAnEdgeToGraph(0,1);
        newGraph.addAnEdgeToGraph(0,2);
        newGraph.addAnEdgeToGraph(1,3);
        newGraph.addAnEdgeToGraph(1,4);
        newGraph.addAnEdgeToGraph(2,4);
        newGraph.addAnEdgeToGraph(3,5);
        newGraph.addAnEdgeToGraph(4,5);
        newGraph.printMat();
       DFSTraverse(newGraph);



    }





}
