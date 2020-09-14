public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {

	OldCofeeMachine oldCofeeMachine;

	public CoffeeTouchscreenAdapter(OldCofeeMachine oldCofeeMachine){
		this.oldCofeeMachine = oldCofeeMachine;
	}

	public void chooseFirstSelection(){
		this.oldCofeeMachine.selectA();
	}

	public void chooseSecondSelection(){
		this.oldCofeeMachine.selectB();
	}

}
