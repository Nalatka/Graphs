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
    public Map<Vertex<V>, Double> getAdjacenctVertices() {
        return adjacenctVertices;
    }

    public void setAdjacenctVertices(Map<Vertex<V>, Double> adjacenctVertices) {
        this.adjacenctVertices = adjacenctVertices;
    }
    @Override
    public String toString() {
        return data.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex) {
            Vertex<?> other = (Vertex<?>) obj;
            return this.data.equals(other.data);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
