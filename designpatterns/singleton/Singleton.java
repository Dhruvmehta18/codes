class Singleton{

  private static Singleton singleton=null;

  private Singleton(){
  }

  public Singleton getInstance(){
    if(this.singleton==null){
      singleton = new Singleton();
    }
    return singleton;
  }
}
