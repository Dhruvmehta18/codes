abstract class KnifeStore {
  public Knife orderKnife(KnifeType knifeType) {
    Knife knife;
    knife = KnifeFactory.createknife(knifeType);

    knife.sharpen();
    knife.polish();
    knife.packaging();

    return knife;
  }

  abstract Knife createknife();
}

public class Knife {
  public void sharpen() {
    // sharpen the knife
  }

  public void polish() {
    // polish the knife
  }

  public void packaging() {
    // package the knife
  }
}

// Budget KnifeStore
class BudgetKnifeStore extends KnifeStore {
  Knife createknife(KnifeType knifeType) {
    Knife knife = null;
    switch (knifeType) {
      case KnifeType.STEAK:
        knife = new BudgetSteakKnife();
      case KnifeType.CHEF:
        knife = new BudgetChefKnife();
        break;
      default:
        knife = null;
        break;
    }
    return knife;
  }
}
