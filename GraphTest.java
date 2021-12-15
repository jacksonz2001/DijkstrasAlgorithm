import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.platform.console.ConsoleLauncher;
import java.lang.invoke.MethodHandles;

/**
 * Tests the implementation of DijkstrasGraph for functionality
 */
public class GraphTest {

  private DijkstrasGraph<String> graph;

  /**
   * Instantiate graph to perform rigorous tests
   */
  @BeforeEach
  public void createGraph() {
    graph = new DijkstrasGraph<>();
    // insert vertices A-F
    graph.insertVertex("A");
    graph.insertVertex("B");
    graph.insertVertex("C");
    graph.insertVertex("D");
    graph.insertVertex("E");
    graph.insertVertex("F");
    // insert edges
    graph.insertEdge("A", "B", 6);
    graph.insertEdge("A", "C", 2);
    graph.insertEdge("A", "D", 5);
    graph.insertEdge("B", "E", 1);
    graph.insertEdge("B", "C", 2);
    graph.insertEdge("C", "B", 3);
    graph.insertEdge("C", "F", 1);
    graph.insertEdge("D", "E", 3);
    graph.insertEdge("E", "A", 4);
    graph.insertEdge("F", "A", 1);
    graph.insertEdge("F", "D", 1);
  }

  /**
   * Checks the distance/total weight cost from the vertex A to E.
   */
  @Test
  public void testPathCostAtoE() {
    assertTrue(graph.getPathCost("A", "E") == 6);
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex A to E.
   */
  @Test
  public void testPathAtoE() {
    assertTrue(graph.shortestPath("A", "E").toString().equals("[A, C, B, E]"));
  }

  /**
   * Checks the distance/total weight cost from the vertex E to F.
   */
  @Test
  public void testPathCostEtoF() {
    assertTrue(graph.getPathCost("E", "F") == 7);
  }

  /**
   * Checks the distance/total weight cost from the vertex A to A.
   */
  @Test
  public void testPathCostAtoA() {
    assertTrue(graph.getPathCost("A", "A") == 0);
  }

  /**
   * Checks the predecessor of F to B is C.
   */
  @Test
  public void testPrecessorFtoB() {
    assertTrue(graph.shortestPath("F", "B").toString().contains("C, B]"));
  }

  /**
   * Checks the distance/total weight cost from the vertex A to F.
   */
  @Test
  public void testPathCostAtoF() {
    assertTrue(graph.getPathCost("A", "F") == 3);
  }

  /**
   * Checks the distance/total weight cost from the vertex A to D.
   */
  @Test
  public void testPathCostAtoD() {
    assertTrue(graph.getPathCost("A", "D") == 4);
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex A to D.
   */
  @Test
  public void testPathAtoD() {
    assertTrue(graph.shortestPath("A", "D").toString().equals("[A, C, F, D]"));
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex A to F.
   */
  @Test
  public void testPathAtoF() {
    assertTrue(graph.shortestPath("A", "F").toString().equals("[A, C, F]"));
  }

  public static void main(String[] args) {
    String className = MethodHandles.lookup().lookupClass().getName();
    String classPath = System.getProperty("java.class.path").replace(" ", "\\ ");
    String[] arguments =
        new String[] {"-cp", classPath, "--include-classname=.*", "--select-class=" + className};
    ConsoleLauncher.main(arguments);
  }

}
