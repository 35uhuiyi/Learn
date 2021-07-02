package test;



import Graph.DijkstraSP;
import Graph.DirectedEdge;
import Graph.EdgeWeightDigraph;
import linear.Queue_ny;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DijkstraSPTest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(DijkstraSPTest.class.getClassLoader().getResourceAsStream("min_route_test.txt")));
        int totalV = Integer.parseInt(br.readLine());
        //构建加权有向图
        EdgeWeightDigraph G = new EdgeWeightDigraph(totalV);
        int totalE = Integer.parseInt(br.readLine());
        for (int i = 0; i < totalE; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            int v = Integer.parseInt(split[0]);
            int w = Integer.parseInt(split[1]);
            double weight = Double.parseDouble(split[2]);
            //加权有向边表示
            DirectedEdge edge = new DirectedEdge(v, w, weight);
            G.addEdge(edge);
        }
        DijkstraSP dijkstraSP = new DijkstraSP(G,0);
        //查找最短路径,0->6的最短路径
        Queue_ny<DirectedEdge> edges = dijkstraSP.pathTo(6);


        //遍历打印
        for (DirectedEdge edge : edges) {

            System.out.println(edge.from()+"->"+edge.to()+" ：： "+edge.weight());
        }



    }
}
