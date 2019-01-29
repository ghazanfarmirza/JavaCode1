import java.util.Scanner;


public class Dijkstra {

    public static void dijkstra(int[][] adjacacenyMatrix){

        int vertex = adjacacenyMatrix.length;
        boolean visited[] = new boolean[vertex];
        int distance[] = new int[vertex];
        distance[0] = 0;
        for(int i = 1; i< vertex; i++){
            distance[i] = Integer.MAX_VALUE;

        }
        for(int i = 0; i< vertex-1; i++){
           int min = findMinVertex(distance,visited);
           visited[min] = true;


           for (int j = 0; j< vertex; j++){
               if (adjacacenyMatrix[min][j] !=0 && !visited[j]){
                   int newDistance = distance[min] + adjacacenyMatrix[min][j];
                   if (newDistance<distance[j]){
                       distance[j] = newDistance;
                   }
               }
           }
        }
            for (int i = 1; i < vertex ; i ++ ){
                System.out.println(i +  "." + distance[i]);

            }
            System.out.print("\t");
    }

    private static int findMinVertex(int[] distance, boolean visited[]){
        int minVertex = -1;
        for(int i = 0; i< distance.length;i++){
            if(!visited[i] && (minVertex == -1) || distance[i] < distance[minVertex] && distance[minVertex] != Integer.MAX_VALUE ){
                minVertex = i;

            }
        }

        return minVertex;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int vertex = s.nextInt();
        int edge = s.nextInt();

        int adjacencyMatrix[][] = new int[vertex][vertex];
        for(int i = 0; i < edge; i++){
            int vertex1 = s.nextInt();
            int vertex2 = s.nextInt();
            int weight = s.nextInt();
            adjacencyMatrix[vertex1][vertex2] = weight;
            adjacencyMatrix[vertex2][vertex1] = weight;

        }
        dijkstra(adjacencyMatrix);

    }
}
