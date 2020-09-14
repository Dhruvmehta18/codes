// KnifeFactory class implementation for factory class

public class KnifeFactory {

  enum KnifeType {
    STEAK,
    CHEF
  }

  public Knife createknife(KnifeType knifeType) {
    Knife knife;
    switch (knifeType) {
      case KnifeType.STEAK:
        knife = new SteakKnife();
        break;
      case KnifeType.CHEF:
        knife = new ChefKnife();
        break;
      default:
        knife = null;
        break;
    }
    return knife;
  }
}
