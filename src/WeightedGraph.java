import java.util.HashMap;
import java.util.*;

public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }
    public int size() {
        return map.size();
    }
    public boolean isEmpty() {
        return map.isEmpty();
    }
    public boolean containsVertex(Vertex vertex) {
        return map.containsKey(vertex);
    }
    public void addVertex(Vertex vertex) {
        if (containsVertex(vertex)) {
            return;
        }
        map.put(vertex,new LinkedList<>());
    }
    public void removeVertex(Vertex vertex) {
        if (!map.containsKey(vertex)) {
            return;
        }
        map.get(vertex).clear();
    }
    public boolean containsEdge(Vertex vertex1, Vertex vertex2) {
        if (!containsVertex(vertex1)) {
            return false;
        }
        return map.get(vertex1).contains(new Edge<>(vertex1,vertex2));
    }
    public void addEdge(Vertex source, Vertex target, double weight) {
        if (containsVertex(source)) {
            addVertex(source);
        }
        if (containsVertex(target)) {
            addVertex(target);
        }
        if(containsEdge(source,target)) {
            return;
        }
        map.get(source).add(new Edge<>(source,target,weight));
        if (undirected) {
            map.get(target).add(new Edge<>(target,source,weight));
        }
    }

}
