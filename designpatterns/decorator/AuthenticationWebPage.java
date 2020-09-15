public class AuthenticationWebPage extends WebPageDecorator{
    public AuthenticationWebPage(WebPage webPageDecorator){
        super(webPageDecorator);
    }

    public void authenticatedUser(){
        System.out.println("Authentication user");
    }

    public display(){
        super.display();
        this.authenticatedUser();
    }
}