import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Multiway {    
    public static void merge(In[] streams) {
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
        for (int i = 0; i < N; i++)
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        while (!pq.isEmpty()) {
            StdOut.println(pq.minKey());
            int i = pq.delMin();
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }
    }

    public static void main(String[] args) {
        String[] fileNames = {"m1.txt", "m2.txt", "m3.txt"};

        int N = fileNames.length;
        In[] streams = new In[N];

        for (int i = 0; i < N; i++)
            streams[i] = new In(fileNames[i]);
        merge(streams);
    }
}