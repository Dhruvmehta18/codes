public class Follower implements Observer {

    private String followerName;

    @Override
    public void update(String status) {
        System.out.println("Channel is Live");
    }

    public void play(){
        //play channel
    }

    public void setFollowerName(String followerName) {
        this.followerName = followerName;
    }

    public String getFollowerName() {
        return followerName;
    }

}