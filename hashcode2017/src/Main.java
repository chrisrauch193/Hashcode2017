import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int noOfVideos;
    static int noOfEndpoints;
    static int noOFRequestDesc;
    static int numofcacheServers;
    static int sizeofcaches;
    static endpoint[] allEndpoint;
    static Video[] allVideos;
    static Cache[] allCaches;

    public static void main(String[] args) {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            line = br.readLine();
            String[] temp;
            temp = line.split(" ");
            noOfVideos = (Integer.parseInt(temp[0]));
            noOfEndpoints = (Integer.parseInt(temp[1]));
            allEndpoint = new endpoint[noOfEndpoints];
            noOFRequestDesc =  (Integer.parseInt(temp[2]));
            numofcacheServers = (Integer.parseInt(temp[3]));

            allCaches = new Cache[numofcacheServers];
            for (int i =0; i < numofcacheServers; i++){
                allCaches[i] = new Cache(i);
            }
            sizeofcaches = (Integer.parseInt(temp[4]));

            line = br.readLine();
            temp = null;
            temp= line.split(" ");
            allVideos = new Video[noOfVideos];
            for (int i =0; i < temp.length; i++){
                allVideos[i] =  new Video(i,Integer.parseInt(temp[i]));
            }

            for (int i =0; i< noOfEndpoints;i++){
                temp = null;
                line = br.readLine();
                temp = line.split(" ");
                endpoint a = new endpoint(Integer.parseInt(temp[1]), Integer.parseInt(temp[0]));
                allEndpoint[i] = a;
                for (int j =0; j < Integer.parseInt(temp[1]);j++){
                    String[] temp2;
                    line = br.readLine();
                    temp2 = line.split(" ");
                    allEndpoint[i].cachelatency.put(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]));
                }

            }
            int totalNumOfRequests = 0;
            for (int k = 0; k < noOFRequestDesc; k++){
                temp = null;
                line = br.readLine();
                temp = line.split(" ");
                allEndpoint[Integer.parseInt(temp[1])].videoconnections.put(Integer.parseInt(temp[0]), Integer.parseInt(temp[2]));
                totalNumOfRequests += Integer.parseInt(temp[2]);
            }

            findNumbersOfRequestsForEachVideo();

            // Populating Sorting data
            Sorter sorter = new Sorter();
            sorter.mostPopularVideos = sortVideoArray();
            sorter.filterOutZeroVideoRequests();
            sorter.populateVideoSignificancePercentageList(totalNumOfRequests);
            System.out.println("hi");



        } catch (Exception e){
            System.out.println("IT IS BROKEN");
            System.out.println(e.getMessage());
        }

    }

    public static void findNumbersOfRequestsForEachVideo() {
        // Adding number of requests to each video
        for (int i = 0; i < noOfEndpoints; i++) {
            Iterator it = allEndpoint[i].videoconnections.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                allVideos[(int) pair.getKey()].noOfRequests += (int) pair.getValue();
            }
        }
    }

    public static Video[] sortVideoArray() {
        Video[] mostPopularVideos = allVideos;
        Arrays.sort(mostPopularVideos, new Comparator<Video>() {
            @Override
            public int compare(Video o1, Video o2) {
                return o2.getNoOfRequests().compareTo(o1.getNoOfRequests());
            }
        });


        return mostPopularVideos;
    }


}
