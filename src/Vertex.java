import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacenctVertices;
    public Vertex(V data) {
        this.data = data;
        adjacenctVertices = new HashMap<Vertex<V>, Double>();
    }
    public void addAdjacentVertex(Vertex<V> destination, Double weight) {
        adjacenctVertices.put(destination, weight);
    }
    public V getData() {
        return data;
    }
    public void setData(V data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return data.toString();
    }
}
