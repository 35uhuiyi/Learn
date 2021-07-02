package test;

import Graph.Edge;
import Graph.EdgeWeightedGraph;
import Graph.KruskalMST;
import Graph.PrimMST;
import linear.Queue_ny;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class PrimMSTTest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(PrimMSTTest.class.getClassLoader().getResourceAsStream("min_create_tree_test.txt")));
        int totalV = Integer.parseInt(br.readLine());
        EdgeWeightedGraph G = new EdgeWeightedGraph(totalV);//建立加权无向边
        int totalE = Integer.parseInt(br.readLine());

        for (int i = 0; i < totalE; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            int v = Integer.parseInt(split[0]);
            int w = Integer.parseInt(split[1]);
            double weight = Double.parseDouble(split[2]);

            //加权无向边
            Edge edge = new Edge(v, w, weight);
            //添加到加权无向图中
            G.addEdge(edge);
        }

        //生成最小生成树
        //PrimMST primMST = new PrimMST(G);
        KruskalMST primMST = new KruskalMST(G);
        //输出
        Queue_ny<Edge> edges = primMST.edges();
        for (Edge edge : edges) {
            int v = edge.either();
            int w = edge.other(v);
            double weight = edge.weight();
            System.out.println(v+"->"+w+":"+weight);
        }
    }
}
