public class ChangeSetMenu {

	int additionalPrice; // �߰��ݾ�
	int drinkBasePrice = 0; // ���� �⺻ ����
	int dessertBasePrice = 0; // ����Ʈ �⺻ ����
	String drinks = "";
	String desserts = "";

	public void changeSetMenu(Menu hamburgerSet, String drinksName, String dessertsName) {

		if (drinksName == "���̴�") {
			additionalPrice = 0;
			drinks = "���̴�";

		} else if (drinksName == "�ݶ�") {
			additionalPrice = 0;
			drinks = "�ݶ�";

		} else if (drinksName == "�Ƹ޸�ī��") {
			additionalPrice = 300;
			drinks = "�Ƹ޸�ī��";

		} else if (drinksName == "���̽� �Ƹ޸�ī��") {
			additionalPrice = 300;
			drinks = "���̽� �Ƹ޸�ī��";

		} else if (drinksName == "ī���") {
			additionalPrice = 700;
			drinks = "ī���";

		} else if (drinksName == "���̽� ī���") {
			additionalPrice = 700;
			drinks = "���̽� ī���";

		}

		// ������ ����� ������ �ݾװ� ���� �� ����� �ٸ� ��� ���׸�ŭ ���ϰų� ����
		if (additionalPrice < drinkBasePrice ) {
			Main.totalPrice = Main.totalPrice + (drinkBasePrice  - additionalPrice);
			hamburgerSet.price = hamburgerSet.price + (drinkBasePrice  - additionalPrice);

		} else if (additionalPrice > drinkBasePrice ) {
			Main.totalPrice = Main.totalPrice + (additionalPrice - drinkBasePrice );
			hamburgerSet.price = hamburgerSet.price + (additionalPrice - drinkBasePrice );
		}

		System.out.println("additionalPrice" + additionalPrice);
		System.out.println("nowDrinksPrice" + drinkBasePrice );
		System.out.println("hamburberPrice" + hamburgerSet.price);
		System.out.println("Main.totalPrice" + Main.totalPrice);

		drinkBasePrice  = additionalPrice;
		System.out.println(drinksName + "�� ���� ���� �߰��ݾ� : " + additionalPrice);

		if (dessertsName == "��������") {
			additionalPrice = 0;

		} else if (dessertsName == "�ܻ�����") {
			additionalPrice = 200;

		} else if (dessertsName == "��ġ�ƽ") {
			additionalPrice = 300;

		} else if (dessertsName == "��䰨��") {
			additionalPrice = 500;

		} else if (dessertsName == "��¡�") {
			additionalPrice = 700;

		} else if (dessertsName == "ġ�ƽ") {
			additionalPrice = 500;

		} else if (dessertsName == "������ ����Ѹ�") {
			additionalPrice = 1900;

		} else if (dessertsName == "������ �Ϲٳ׷�") {
			additionalPrice = 1000;

		} else if (dessertsName == "����ġŲ") {
			additionalPrice = 1900;

		} else if (dessertsName == "ġ���δ�����") {
			additionalPrice = 1500;

		}

		// ������ ����� ������ �ݾװ� ���� �� ����� �ٸ� ��� ���׸�ŭ ���ϰų� ����
		if (additionalPrice < dessertBasePrice ) {
			Main.totalPrice = Main.totalPrice + (dessertBasePrice  - additionalPrice);
			hamburgerSet.price = hamburgerSet.price + (dessertBasePrice  - additionalPrice);

		} else if (additionalPrice > dessertBasePrice ) {
			Main.totalPrice = Main.totalPrice + (additionalPrice - dessertBasePrice );
			hamburgerSet.price = hamburgerSet.price + (additionalPrice - dessertBasePrice );
		}
		dessertBasePrice  = additionalPrice;
		System.out.println(dessertsName + "�� ����Ʈ ���� �߰��ݾ� : " + additionalPrice);

		System.out.println("additionalPrice" + additionalPrice);
		System.out.println("nowDessertsPrice" + dessertBasePrice );
		System.out.println("hamburberPrice" + hamburgerSet.price);
		System.out.println("Main.totalPrice" + Main.totalPrice);

		if (drinksName != "" && dessertsName != "") {
			Main.orderStatusText.get(Main.orderStatusTextNumber - 1).setText(hamburgerSet.productName + " " + hamburgerSet.amount + "�� "
					+ hamburgerSet.price + " ���� :" + drinksName + " ����Ʈ :" + dessertsName);
		}
		
		Main.priceText.setText(Main.totalPrice + "��");
		Main.amountText.setText(Main.totalAmount + "��");
	}

}