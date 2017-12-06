package com.accingest.app;

import org.vertexium.Authorizations;
import org.vertexium.Vertex;
import org.vertexium.Edge;
import org.vertexium.Direction;
import org.vertexium.Visibility;

import org.vertexium.Graph;
import org.vertexium.accumulo.AccumuloGraph;
import org.vertexium.accumulo.AccumuloGraphConfiguration;
import org.vertexium.accumulo.mapreduce.AccumuloElementOutputFormat;
import org.vertexium.accumulo.AccumuloAuthorizations;
import org.vertexium.accumulo.mapreduce.ElementMapper;

import java.util.HashMap;
import java.util.Map;

public class Example {
    public static void main(String[] args) throws Exception {
        new Example().run();
    }

    private void run() throws Exception {
        
        // Accumulo config
        Map mapConfig = new HashMap();
        mapConfig.put(AccumuloGraphConfiguration.ACCUMULO_INSTANCE_NAME, "");
        mapConfig.put(AccumuloGraphConfiguration.ACCUMULO_USERNAME, "");
        mapConfig.put(AccumuloGraphConfiguration.ACCUMULO_PASSWORD, "");
        mapConfig.put(AccumuloGraphConfiguration.ZOOKEEPER_SERVERS, "");
        mapConfig.put(AccumuloGraphConfiguration.TABLE_NAME_PREFIX, "");

        AccumuloGraphConfiguration graphConfig = new AccumuloGraphConfiguration(mapConfig);
        Graph accumuloGraph = AccumuloGraph.create(graphConfig);

        Authorizations noAuthorizations = accumuloGraph.createAuthorizations();
        Visibility visibility = Visibility.EMPTY;        

        System.out.println("=====reading all vertices as regular user======");
        Iterable<Vertex> vertices = accumuloGraph.getVertices(noAuthorizations);
        for(Vertex vertexss : vertices){
            System.out.println(vertexss.getId());
        }

    	System.out.println("Vertices of " + accumuloGraph);
    	for (Vertex vertexs : accumuloGraph.getVertices(noAuthorizations)) {
    		System.out.println(vertexs);
    	}
    	
    	System.out.println("Edges of " + accumuloGraph);
    	for (Edge edges : accumuloGraph.getEdges(noAuthorizations)) {
    		System.out.println(edges);
    	}
    }
}
