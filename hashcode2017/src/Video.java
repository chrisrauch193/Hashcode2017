/**
 * Created by cr217 on 23/02/17.
 */
public class Video {
    int ID;
    int size;
    int noOfRequests = 0;

    public Video(int id, int size){
        ID = id;
        this.size = size;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getNoOfRequests() {
        return noOfRequests;
    }

    public void setNoOfRequests(int noOfRequests) {
        this.noOfRequests = noOfRequests;
    }
}
