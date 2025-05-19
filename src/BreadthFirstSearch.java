import java.util.*;

public class BreadthFirstSearch<T> implements Search<T> {
    private final Map<T, T> edgeTo = new HashMap<>();
    private final Set<T> visited = new HashSet<>();
    private final T start;

    public BreadthFirstSearch(WeightedGraph<T> graph, T start) {
        this.start = start;
        bfs(graph, graph.getVertex(start));
    }

    private void bfs(WeightedGraph<T> graph, Vertex<T> startVertex) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(startVertex);
        visited.add(startVertex.getData());

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            for (Vertex<T> neighbor : current.getAdjacenctVertices().keySet()) {
                if (!visited.contains(neighbor.getData())) {
                    visited.add(neighbor.getData());
                    edgeTo.put(neighbor.getData(), current.getData());
                    queue.add(neighbor);
                }
            }
        }
    }

    public List<T> pathTo(T end) {
        List<T> path = new ArrayList<>();
        if (!visited.contains(end)) return path;

        for (T at = end; at != null; at = edgeTo.get(at)) {
            path.add(at);
            if (at.equals(start)) break;
        }

        Collections.reverse(path);
        return path;
    }
}

