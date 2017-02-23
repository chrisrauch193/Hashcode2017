/**
 * Created by cr217 on 23/02/17.
 */
import java.util.HashMap;

public class endpoint {
    public int datacentrelatency;
    public int noOfConnectedCacheServers;
    public HashMap<Integer,Integer> videoconnections= new HashMap<>();
    public HashMap<Integer,Integer> cachelatency= new HashMap<>();


    public endpoint(int connections, int latency){
        noOfConnectedCacheServers = connections;
        datacentrelatency = latency;
    }


}
