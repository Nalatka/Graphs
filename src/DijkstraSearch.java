import java.util.*;

public class DijkstraSearch<T> implements Search<T> {
    private final Map<T, Double> distance = new HashMap<>();
    private final Map<T, T> edgeTo = new HashMap<>();
    private final Set<T> visited = new HashSet<>();
    private final T start;

    public DijkstraSearch(WeightedGraph<T> graph, T start) {
        this.start = start;
        dijkstra(graph, graph.getVertex(start));
    }

    private void dijkstra(WeightedGraph<T> graph, Vertex<T> startVertex) {
        PriorityQueue<Vertex<T>> queue = new PriorityQueue<>(Comparator.comparingDouble(v -> distance.get(v.getData())));
        distance.put(startVertex.getData(), 0.0);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            T currentData = current.getData();
            if (visited.contains(currentData)) continue;
            visited.add(currentData);

            for (Map.Entry<Vertex<T>, Double> neighborEntry : current.getAdjacenctVertices().entrySet()) {
                Vertex<T> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double newDist = distance.get(currentData) + weight;

                if (newDist < distance.getOrDefault(neighbor.getData(), Double.POSITIVE_INFINITY)) {
                    distance.put(neighbor.getData(), newDist);
                    edgeTo.put(neighbor.getData(), currentData);
                    queue.add(neighbor);
                }
            }
        }
    }

    public List<T> pathTo(T end) {
        List<T> path = new ArrayList<>();
        if (!distance.containsKey(end)) return path;

        for (T at = end; at != null; at = edgeTo.get(at)) {
            path.add(at);
            if (at.equals(start)) break;
        }

        Collections.reverse(path);
        return path;
    }
}
