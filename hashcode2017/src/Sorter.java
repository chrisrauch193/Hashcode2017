import javax.xml.ws.Endpoint;

/**
 * Created by cr217 on 23/02/17.
 */
public class Sorter {
    Video[] mostPopularVideos;
    double[] videoSignificancePercentageList;
    Endpoint[] mostRequestsMade;
    Cache[] mostEndPointConnections;
    Cache[] mostPossibleRequestsMade;

    public void filterOutZeroVideoRequests() {
        int notZeroCoutner = 0;
        for (int i = 0; i < this.mostPopularVideos.length; i++) {
            if (mostPopularVideos[i].noOfRequests > 0) {
                notZeroCoutner++;
            }
        }

        Video[] newMostPopularVideos = new Video[notZeroCoutner];
        int arrayIndex = 0;

        for (int i = 0; i < this.mostPopularVideos.length; i++) {
            if (mostPopularVideos[i].noOfRequests > 0) {
                newMostPopularVideos[arrayIndex] = mostPopularVideos[i];
                arrayIndex++;
            }
        }

        this.mostPopularVideos = newMostPopularVideos;
    }

    public void populateVideoSignificancePercentageList(int noOfRequestDescriptions) {
        double[] videoSignificancePercentageList = new double[this.mostPopularVideos.length];
        for (int i = 0; i < this.mostPopularVideos.length; i++) {
            videoSignificancePercentageList[i] =  (100 * mostPopularVideos[i].noOfRequests) / (double) noOfRequestDescriptions;
        }

        this.videoSignificancePercentageList = videoSignificancePercentageList;
    }

}
