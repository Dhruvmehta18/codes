public class AuthorizedWebpage extends WebPageDecorator{

    public AuthorizedWebpage(WebPage webPageDecorator){
        super(webPageDecorator);
    }

    public void authorizeddUser(){
        System.out.println("Authentication user");
    }

    public display(){
        super.display();
        this.authorizeddUser();
    }
}