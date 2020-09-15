public class Program {
    public static void main(String[] args) {
        Webpage webPage = new BasicWebpage();
        webPage = new AuthorizedWebPage(webPage);
        webPage = new AuthenticatedWebPage(webPage);
        webPage.display();
    }
}
