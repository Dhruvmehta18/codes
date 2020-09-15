public class BasicWebPage implements WebPage{
    private String html = "";
    private String stylesheet = "";
    private String scripts = "";

    public void display(){
        System.out.println("Basic web page");
    }
}
