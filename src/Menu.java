import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Menu {
	String productName; //��ǰ �̸�
	int price;			//����
	int originalPrice = 0; //������ ���� ����
	int amount = 0;
	
	ArrayList<String> ingerdientsMenuImages;	//�߰����� �޴� �̹��� �迭
	
	Menu(String productName, int price, int amount) {
		this.productName = productName;
		this.originalPrice = price;
		this.amount = amount;
	}
	
	void buy() {
		//��ǰ �ʱ�ȭ
		price = originalPrice;
		amount = 1;
	
		price = price * amount;
		Main.totalPrice = Main.totalPrice+price;
		Main.orderProductName.add(productName);
		Main.orderProduct.add(productName+" "+amount+"�� "+price);
		Main.orderStatusText.get(Main.orderStatusTextNumber).setText(productName+" "+amount+"�� "+price);
		Main.totalAmount++;
		Main.amountText.setText(Main.totalAmount+"��");
		Main.priceText.setText(Main.totalPrice+"��");

		Main.finalTotalAmount.setText("�� ���� : "+Main.totalAmount+" ��");
		Main.finalTotalPrice.setText("�� "+Main.totalPrice+" ��");
		
		System.out.println("�߰� �� �迭 ��");
		System.out.println(Main.orderProductName.toString());
	}
	
	void cancel() {

			Main.totalAmount -= amount;
			Main.totalPrice -= price;
			Main.amountText.setText(Main.totalAmount + "��");
			Main.priceText.setText(Main.totalPrice + "��");
			Main.orderProductName.remove(productName);
			Main.orderProduct.remove(productName+" "+amount+"�� "+price);
			
			Main.finalTotalAmount.setText("�� ���� : "+Main.totalAmount+" ��");
			Main.finalTotalPrice.setText("�� "+Main.totalPrice+" ��");
			
			System.out.println(Main.orderProductName.toString());

	}
	
	void addNumOfProduct(int num, int orderStatusTextNumber) {
		Main.orderProduct.remove(productName+" "+amount+"�� "+price);
		
		amount = amount + num;
		Main.howManyText.setText("����  : " + amount + " ��");
		
		price = price + originalPrice * num;
		Main.totalPrice = Main.totalPrice + originalPrice * num;
		//Main.orderProductName.add(productName);
		System.out.println("productName" + productName);
		Main.orderStatusText.get(orderStatusTextNumber).setText(productName+" "+amount+"�� "+ price);
		
		Main.totalAmount = Main.totalAmount + num;
		System.out.println("amount" + amount + "totalAmount" + Main.totalAmount);
		Main.amountText.setText(Main.totalAmount+"��");
		Main.priceText.setText(Main.totalPrice+"��");
		
		Main.orderProduct.add(productName+" "+amount+"�� "+price);
		Main.finalTotalAmount.setText("�� ���� : "+Main.totalAmount+" ��");
		Main.finalTotalPrice.setText("�� "+Main.totalPrice+" ��");
	}
	
	void addNumOfHamburgerSet(int num, int orderStatusTextNumber, String hamburgerSet_drink, String hamburgerSet_dessert) {
		Main.orderProductName.remove(productName);
		Main.orderProduct.remove(productName+" "+amount+"�� "+price);
		
		System.out.println(num + "�� �߰� ");
		amount = amount + num;
		Main.howManyText.setText("����  : " + amount + " ��");
		
		//price = price * amount;
		Main.totalPrice = Main.totalPrice + price * (amount - 1);
		//Main.orderProductName.add(productName);
		Main.orderStatusText.get(orderStatusTextNumber).setText(productName+" "+amount+"�� "+ (price * amount));
		
		Main.totalAmount = Main.totalAmount + num;
		System.out.println("amount" + amount + "totalAmount" + Main.totalAmount);
		Main.amountText.setText(Main.totalAmount+"��");
		Main.priceText.setText(Main.totalPrice +"��");
		
		Main.orderProductName.add(productName);
		Main.orderProduct.add(productName + " " + amount + "�� "
				+ price * amount + " ���� :" + hamburgerSet_drink + " ����Ʈ :" + hamburgerSet_dessert);
		
		if (hamburgerSet_drink != "" && hamburgerSet_dessert != "") {
			Main.orderStatusText.get(Main.orderStatusTextNumber - 1).setText(productName + " " + amount + "�� "
					+ price * amount + " ���� :" + hamburgerSet_drink + " ����Ʈ :" + hamburgerSet_dessert);
		}
	}
}