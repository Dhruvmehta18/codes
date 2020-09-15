public abstract class WebpageDecorator implements WebPage {
    protected WebPage webPage;

    public  WebpageDecorator(WebPage webPage){
        this.page = webPage;
    }

    public void display(){
        this.webPage.display();
    }
}
