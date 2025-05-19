import java.util.HashMap;
import java.util.*;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Map<T, Vertex<T>> vertices = new HashMap<>();

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }
    public WeightedGraph() {
        this(false);
    }
   public void addEdge(T from, T to, double weight) {
        Vertex<T> fromVertex = vertices.get(from);
        Vertex<T> toVertex = vertices.get(to);
       fromVertex.addAdjacentVertex(toVertex,weight);
       if (!undirected) {
           toVertex.addAdjacentVertex(fromVertex,weight);
       }
   }
    public void addVertex(T v) {
        Vertex<T> u = vertices.get(v);
        if (u == null) {
            u = new Vertex<>(v);
            vertices.put(v, u);
        }
    }
    public Vertex<T> getVertex(T key) {
        return vertices.get(key);
    }
}
