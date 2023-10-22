import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Main {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JLabel advertisingScene = new JLabel(); // �����̹��� �ٲٴ� ��
	JPanel mainPurchaseScene = new JPanel();
	JPanel packagingDeliveringScene = new JPanel() {
		public void paintComponent(Graphics g) {
			Dimension d = getSize();
			ImageIcon image = new ImageIcon("./otherimages/empty.png");
			g.drawImage(image.getImage(), 0, 0, d.width, d.height, this);
		}
	};

	JPanel changeIngredientsScene = new JPanel(); //�ܹ��� ��Ʈ�� �߰����� �ٲٴ� ��

	JPanel paymentCheckScene = new JPanel(); // ���� Ȯ�� ��
	JLabel paymentCheckSceneImage = new JLabel();
	JLabel cardPaymentSceneImage = new JLabel();
	JLabel insertCardImage = new JLabel();
	JButton insertCardButton = new JButton();
	JButton checkOKButton = new JButton();
	JButton checkCancelButton = new JButton();
	JButton[] ingerdientsMenuImages = new JButton[13];

	static JLabel finalTotalAmount = new JLabel();	
	static JLabel finalTotalPrice = new JLabel();

	JButton ingerdientsNextPageButton = new JButton();
	JButton ingerdientsPreviousPageButton = new JButton();
	JButton ingerdientsDessertButton = new JButton();
	JButton ingerdientsDrinkButton = new JButton();

	int buyBurgerSetCount = 0;
	int selectIngerdientsCount = 0;
	
	String hamburgerSetDessert = "";
	String hamburgerSetDrink = "";

	JLabel pressKeyText = new JLabel();
	JButton packagingButton = new JButton();
	JButton deliveringButton = new JButton();
	JButton[] menuImages = new JButton[9];
	JButton nextPageButton = new JButton();
	JButton previousPageButton = new JButton();
	JButton goAdvertisingSceneButton = new JButton();
	JButton cancelPageButton = new JButton();
	JButton paymentButton = new JButton();
	JButton hamburgerButton = new JButton();
	JButton hamburgerSetButton = new JButton();
	JButton drinkButton = new JButton();
	JButton dessertButton = new JButton();
	JLabel topAdvertisingImage = new JLabel(); // ��� ���� �̹���
	static JLabel amountText = new JLabel();
	static JLabel priceText = new JLabel();
	JLabel orderDetailsText = new JLabel(); // �� �ֹ� ����
	JLabel orderDetailsBackGround = new JLabel();
	JLabel chooseEatingPlaceText = new JLabel();

	JLabel orderSituationBackGround = new JLabel();
	JLabel howManyAddText = new JLabel();
	static JLabel howManyText = new JLabel();
	JButton oneThing = new JButton();
	JButton fiveThing = new JButton();
	JButton tenThing = new JButton();
	JButton checkButton = new JButton();// Ȯ�ι�ư
	JButton cancelAddButton = new JButton(); //�����߰��� ���
	
	static ArrayList<JLabel> orderStatusText = new ArrayList<>();

	ArrayList<JButton> removeButton = new ArrayList<>(); //cancel -> remove
	ArrayList<JButton> quantityChangeButton = new ArrayList<>(); // ��������
	JLabel orderStatusBackGround = new JLabel();

	static ArrayList<String> orderProductName = new ArrayList<String>(); // �ֹ��� ��ǰ �̸��� �޴� �迭
	static ArrayList<String> orderProduct = new ArrayList<String>(); // �ֹ��� ��ǰ �̸�,����,������ �޴� �迭
	ArrayList<String> ingerdientsProductName = new ArrayList<String>();

	int menupage = 0;
	int menuHorizontalLength = 50; //ù��° �޴��� ������ġ
	int menuVerticalLength = 0; //ù��° �Ŵ��� ������ġ
	int menuImageWidth = 150;   //�޴����� ���� ����
	int menuImageHeight = 130;  //�޴����� ���� ����
	int menuHorizontalInterval = 170; //�޴�������� ����

	int ingerdientsPage = 0; // ����ǰ ������
	int ingerdientsMenuHorizontalLength = 50; //�޴��� ���� ��ư�� x���� ���߱� ���� 50�� ��
	int ingerdientsMenuVerticalLength = 0;	//�޴��� ���� ��ư�� y���� ���߱� ���� 50�� ��
	int ingerdientsMenuImageWidth = 100; //�߰� ���� �̹��� ũ�⿡ ���� 100�� ��
	int ingerdientsMenuImageHeight = 130;	//�߰� ���� �̹��� ũ�⿡ ���� 130��  ��
	int ingerdientsMenuHorizontalInterval = 130; //�߰� ���� ��ư�� �� �࿡ 4���� ���� ������ 130�� ��

	static int orderStatusTextNumber = 0; // �ֹ���Ȳ �ؽ�Ʈ ��
	static int totalAmount = 0; // �ֹ� �� ��
	static int totalPrice = 0; // �ֹ� �� �ݾ�

	int productNum = 0; // ��ǰ�� ������ �����Ҷ� � ��ǰ���� �Ǵ��ϱ� ���� ����
	int addProductNum = 0; //��� ���� �߰� �ߴ��� 
	String eatingPlace = "";// ���忡�� ���� ���� ���� �� ����

	int OrderStatusVerticalLength = -40;   //�ֹ�����â�� �ֹ���Ȳ�� ��Ÿ���� text�� ��ġ�� �����ϱ� ����

	ChangeAdvertisingScene changeAdvertisingScene = new ChangeAdvertisingScene(advertisingScene);

	// ��Ʈ�޴�
	Menu wagyuEdition2Set = new Menu("�ͱԿ����2 ��Ʈ", 7600, 1);
	Menu doubleX2Set = new Menu("����X2 ��Ʈ", 7500, 1);
	Menu AZBurgerSet = new Menu("AZ���� ��Ʈ", 8300, 1);
	Menu hanwooBulgogiCombo = new Menu("�ѿ�Ұ�� �޺�", 8000, 1);
	Menu hanwooBulgogiBurgerSet = new Menu("�ѿ�Ұ�� ��Ʈ", 8700, 1);
	Menu mozzarellaInTheBurgerSet = new Menu("��¥���� �� �� ���� ��Ʈ", 7700, 1);
	Menu bigBulgogiSet = new Menu("������� ��Ʈ", 7600, 1);
	Menu hotCrispyBurgerSet = new Menu("��ũ�����ǹ��� ��Ʈ", 6700, 1);
	Menu bulgogiBurgerSet = new Menu("�Ұ����� ��Ʈ", 5900, 1);
	Menu riaMiracleBurgerSet = new Menu("���ƹ̶�Ŭ���� ��Ʈ", 7400, 1);
	Menu shrimpBurgerSet = new Menu("������� ��Ʈ", 5900, 1);
	Menu chickenBurgerSet = new Menu("ġŲ���� ��Ʈ", 5100, 1);
	Menu T_RexBurgerSet = new Menu("T-Rex ���� ��Ʈ", 5900, 1);
	Menu classicCheeseBurgerSet = new Menu("Ŭ����ġ����� ��Ʈ", 6400, 1);
	Menu teriBurgerSet = new Menu("�������� ��Ʈ", 4900, 1);

	// �ܹ��� �޴�
	Menu wagyuEdition2 = new Menu("�ͱԿ����2", 5800, 1);
	Menu doubleX2 = new Menu("����X2", 5500, 1);
	Menu mozzarellaInTheBurger = new Menu("��¥���� �� �� ����", 6000, 1);
	Menu AZBurger = new Menu("AZ����", 6600, 1);
	Menu bigBulgogi = new Menu("�������", 5800, 1);
	Menu hotCrispyBurger = new Menu("��ũ�����ǹ���", 4900, 1);
	Menu hanwooBulgogi = new Menu("�ѿ� �Ұ�� ����", 7000, 1);
	Menu bulgogiBurger = new Menu("�Ұ�� ����", 3900, 1);
	Menu riaMiracleBurger = new Menu("���ƹ̶�Ŭ����", 5600, 1);
	Menu shrimpBurger = new Menu("�������", 3900, 1);
	Menu chickenBurger = new Menu("ġŲ����", 2900, 1);
	Menu T_RexBurger = new Menu("T-Rex", 3700, 1);
	Menu classicCheeseBurger = new Menu("Ŭ���� ġ�����", 4400, 1);
	Menu teriBurger = new Menu("��������", 2500, 1);

	// ����Ʈ
	Menu cheeseInTheEgg = new Menu("ġ���δ�����", 3000, 1);
	Menu jipieHabanero_L = new Menu("������ �Ϲٳ׷�", 4300, 1);
	Menu jipie_S = new Menu("������ ����Ѹ�", 3400, 1);
	Menu chickenNugget = new Menu("ġŲ�ʰ�", 1200, 1);
	Menu longCheeseStick = new Menu("�� ġ�ƽ", 1800, 1);
	Menu coneSalad = new Menu("�ܻ�����", 1700, 1);
	Menu sundayIceCream = new Menu("�����̾��̽�ũ��", 1500, 1);
	Menu shakeShakeChicken = new Menu("����ġŲ", 2500, 1);
	Menu seasoningPotato = new Menu("��䰨��", 2000, 1);
	Menu squidRing = new Menu("��¡�", 2200, 1);
	Menu naturalCheeseStick = new Menu("ġ�ƽ", 2000, 1);
	Menu potato = new Menu("��������", 1500, 1);
	Menu chocoCookieTornado = new Menu("����̵�(������Ű)", 2300, 1);
	Menu greenTeaTornado = new Menu("����̵�(����)", 2300, 1);
	Menu strawberryTornado = new Menu("����̵�(��Ʈ�κ���)", 2400, 1);
	Menu softCone = new Menu("����Ʈ��", 700, 1);

	// �����
	Menu cider = new Menu("���̴�", 1700, 1);
	Menu cola = new Menu("�ݶ�", 1700, 1);
	Menu americano = new Menu("�Ƹ޸�ī��", 2000, 1);
	Menu iceAmericano = new Menu("���̽� �Ƹ޸�ī��", 2000, 1);
	Menu caffeLatte = new Menu("ī���", 2000, 1);
	Menu iceCaffeLatte = new Menu("���̽�ī���", 2000, 1);
	
	static Menu selectedSetMenu;

	ChangeSetMenu changeSetMenu = new ChangeSetMenu();

	public Main() {

		frame = new JFrame();
		frame.setBounds(0, 0, 600, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("hamburgerKiosk");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		advertisingScene.setBounds(0, 0, 600, 850);
		frame.getContentPane().add(advertisingScene);
		advertisingScene.setLayout(null);

		advertisingScene.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				advertisingScene.setVisible(false);
				packagingDeliveringScene.setVisible(true);
				insertCardButton.setEnabled(true);	//���� �� ��Ȱ��ȭ �� ī�� ���Թ�ư�� ����â�� ��Ÿ���� Ȱ��ȭ ��Ŵ
				//insertCardImage.setIcon(new ImageIcon("./otherimages/ī������.png"));
				// restart = "";
			}
		});

		JScrollPane scrollBar = new JScrollPane();
		scrollBar.setBounds(68, 201, 450, 200);
		scrollBar.getVerticalScrollBar().setValue(scrollBar.getVerticalScrollBar().getMaximum());
		paymentCheckSceneImage.add(scrollBar);

		JTextArea textArea = new JTextArea();
		scrollBar.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setVisible(false);
		textArea.setFont((new Font("����ü", Font.BOLD, 15)));

		// ���忡�� �������� �����Ұ��� ���� ȭ��
		packagingDeliveringScene.setBounds(0, 0, 600, 850);
		frame.getContentPane().add(packagingDeliveringScene);
		packagingDeliveringScene.setLayout(null);
		packagingDeliveringScene.setVisible(false);

		// �ֹ� ���� ���ȭ��
		orderSituationBackGround.setBounds(50, 300, 490, 190);
		orderSituationBackGround.setIcon(new ImageIcon("./otherimages/empty.png"));
		mainPurchaseScene.add(orderSituationBackGround);
		orderSituationBackGround.setVisible(false);

		// ���� ���� ȭ��
		mainPurchaseScene.setBounds(0, 0, 600, 850);
		frame.getContentPane().add(mainPurchaseScene);
		mainPurchaseScene.setLayout(null);
		mainPurchaseScene.setVisible(false);

		// ����Ʈ ���� ��ȯ ȭ��
		changeIngredientsScene.setBounds(0, 0, 600, 850);
		frame.getContentPane().add(mainPurchaseScene);
		mainPurchaseScene.setLayout(null);
		mainPurchaseScene.setVisible(false);

		// ó�� ȭ�� (����ȭ��)
		pressKeyText.setBounds(0, 730, 600, 100);
		pressKeyText.setLayout(null);
		pressKeyText.setText("ȭ�� ��ġ�� �ּ���");
		pressKeyText.setHorizontalAlignment(SwingConstants.CENTER);
		pressKeyText.setFont(new Font("����", Font.BOLD, 30));
		pressKeyText.setForeground(Color.white);
		advertisingScene.add(pressKeyText);

		// ���忡�� ���� ������ �������� �����ϴ� ���
		chooseEatingPlaceText.setText("��� ��ðڽ��ϱ�?");
		chooseEatingPlaceText.setBounds(0, 150, 600, 100);
		chooseEatingPlaceText.setHorizontalAlignment(SwingConstants.CENTER);
		chooseEatingPlaceText.setFont(new Font("����", Font.BOLD, 30));
		packagingDeliveringScene.add(chooseEatingPlaceText);

		packagingButton.setBounds(320, 330, 150, 150);
		packagingButton.setIcon(new ImageIcon("./otherimages/delivery.jpg"));
		packagingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				packagingDeliveringScene.setVisible(false);
				mainPurchaseScene.setVisible(true);
				insertCardButton.setVisible(false);
				
			}
		});
		packagingDeliveringScene.add(packagingButton);

		deliveringButton.setBounds(110, 330, 150, 150);
		deliveringButton.setIcon(new ImageIcon("./otherimages/store.jpg"));
		deliveringButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				packagingDeliveringScene.setVisible(false);
				mainPurchaseScene.setVisible(true);
				insertCardButton.setVisible(false);
				
			}
		});
		packagingDeliveringScene.add(deliveringButton);

		// ����ȭ��
		topAdvertisingImage.setBounds(0, 0, 600, 140);
		topAdvertisingImage.setIcon(new ImageIcon("./otherimages/T-rax���ű���(����â).jpg"));
		mainPurchaseScene.add(topAdvertisingImage);

		// �ܹ��� ��Ʈ ��ư�� ������ �ܹ��� ��Ʈ�� �� �� �ִ� �������� �Ѿ��.
		hamburgerSetButton.setBounds(90, 150, 100, 40);
		hamburgerSetButton.setText("�ܹ��� ��Ʈ");
		hamburgerSetButton.setFont(new Font("����", Font.BOLD, 10));
		hamburgerSetButton.setBackground(Color.gray);
		hamburgerSetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hamburgerSetButton.setBackground(Color.gray);
				hamburgerButton.setBackground(Color.white);
				drinkButton.setBackground(Color.white);
				dessertButton.setBackground(Color.white);

				menupage = 0;
				changeMenu();
			}
		});
		mainPurchaseScene.add(hamburgerSetButton);

		// �ܹ��� ��ư�� ������ �ܹ��Ÿ� �� �� �ִ� �������� �Ѿ��.
		hamburgerButton.setBounds(190, 150, 100, 40);
		hamburgerButton.setText("�ܹ���");
		hamburgerButton.setFont(new Font("����", Font.BOLD, 10));
		hamburgerButton.setBackground(Color.white);
		hamburgerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hamburgerSetButton.setBackground(Color.white);
				hamburgerButton.setBackground(Color.gray);
				drinkButton.setBackground(Color.white);
				dessertButton.setBackground(Color.white);

				menupage = 2;
				changeMenu();
			}
		});
		mainPurchaseScene.add(hamburgerButton);

		// ����Ʈ ��ư�� ������ ����Ʈ�� �� �� �ִ� �������� �Ѿ��.
		dessertButton.setBounds(290, 150, 100, 40);
		dessertButton.setText("����Ʈ");
		dessertButton.setFont(new Font("����", Font.BOLD, 10));
		dessertButton.setBackground(Color.white);
		dessertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hamburgerSetButton.setBackground(Color.white);
				hamburgerButton.setBackground(Color.white);
				drinkButton.setBackground(Color.white);
				dessertButton.setBackground(Color.gray);

				menupage = 4;
				changeMenu();
			}
		});
		mainPurchaseScene.add(dessertButton);

		// ���� ��ư�� ������ ���Ḧ �� �� �ִ� �������� �Ѿ��.
		drinkButton.setBounds(390, 150, 100, 40);
		drinkButton.setText("����");
		drinkButton.setFont(new Font("����", Font.BOLD, 10));
		drinkButton.setBackground(Color.white);
		drinkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hamburgerSetButton.setBackground(Color.white);
				hamburgerButton.setBackground(Color.white);
				drinkButton.setBackground(Color.gray);
				dessertButton.setBackground(Color.white);

				menupage = 6;
				changeMenu();
			}
		});
		mainPurchaseScene.add(drinkButton);

		goAdvertisingSceneButton.setBounds(110, 750, 100, 40);
		goAdvertisingSceneButton.setText("ùȭ������");
		goAdvertisingSceneButton.setFont(new Font("����", Font.BOLD, 10));
		goAdvertisingSceneButton.setBackground(Color.LIGHT_GRAY);
		goAdvertisingSceneButton.setBorderPainted(false);
		goAdvertisingSceneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				advertisingScene.setVisible(true);
				mainPurchaseScene.setVisible(false);

				for (int i = 0; i < orderStatusText.size(); i++) {
					orderStatusText.get(i).setLocation(1000, 1000);
					removeButton.get(i).setLocation(1000, 1000);
					quantityChangeButton.get(i).setLocation(1000, 1000);
					// orderStatusText.remove(i);
				}

				orderStatusText.clear();
				orderStatusTextNumber = 0;
				OrderStatusVerticalLength = -40;

				orderProductName.clear();
				totalAmount = 0;
				totalPrice = 0;
				amountText.setText(totalAmount + "��");
				priceText.setText(totalPrice + "��");

				finalTotalAmount.setText("�� ���� : +totalAmount+ ��");
				finalTotalPrice.setText("��  +totalPrice ��");

				hamburgerSetDessert = "";
				hamburgerSetDrink  = "";
				selectIngerdientsCount = 0;
				buyBurgerSetCount = 0;

				System.out.println(orderStatusText.size());
				System.out.println(orderProductName.toString());

				textArea.selectAll();
				textArea.replaceSelection("");
			}
		});
		mainPurchaseScene.add(goAdvertisingSceneButton);

		cancelPageButton.setBounds(247, 750, 100, 40);
		cancelPageButton.setText("����ϱ�");
		cancelPageButton.setFont(new Font("����", Font.BOLD, 10));
		cancelPageButton.setBackground(Color.LIGHT_GRAY);
		cancelPageButton.setBorderPainted(false);
		cancelPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				// ��Ʈ�޴� ���� ����ϱ� ������ ��Ʈ�޴� �߰����� ���������� ���α���â���� �ٲ�
				for (int i = 0; i < menuImages.length; i++) {
					menuImages[i].setVisible(true);
				}

				for (int i = 0; i < ingerdientsMenuImages.length; i++) {
					ingerdientsMenuImages[i].setVisible(false);
				}

				hamburgerSetButton.setVisible(true);
				hamburgerButton.setVisible(true);
				drinkButton.setVisible(true);
				dessertButton.setVisible(true);
				nextPageButton.setVisible(true);
				previousPageButton.setVisible(true);

				changeIngredientsScene.setVisible(false);
				ingerdientsNextPageButton.setVisible(false);
				ingerdientsPreviousPageButton.setVisible(false);
				ingerdientsDessertButton.setVisible(false);
				ingerdientsDrinkButton.setVisible(false);

				for (int i = 0; i < orderStatusText.size(); i++) {
					orderStatusText.get(i).setLocation(1000, 1000);
					removeButton.get(i).setLocation(1000, 1000);
					quantityChangeButton.get(i).setLocation(1000, 1000);
					// orderStatusText.remove(i);

					orderStatusTextNumber = 0;
				}

				orderStatusText.clear();
				orderStatusTextNumber = 0;
				OrderStatusVerticalLength = -40;

				orderProductName.clear();
				orderProduct.clear();
				totalAmount = 0;
				totalPrice = 0;
				amountText.setText(totalAmount + "��");
				priceText.setText(totalPrice + "��");
				
				finalTotalAmount.setText("�� ���� : "+totalAmount+" ��");
				finalTotalPrice.setText("�� "+totalPrice+" ��");
				
				textArea.selectAll();
				textArea.replaceSelection("");
				
				System.out.println(orderProductName.toString());
				System.out.println("��ü ����߽��ϴ�.");
			}
		});
		mainPurchaseScene.add(cancelPageButton);

		paymentButton.setBounds(385, 750, 100, 40);
		paymentButton.setText("�����ϱ�");
		paymentButton.setFont(new Font("����", Font.BOLD, 10));
		paymentButton.setBackground(Color.LIGHT_GRAY);
		paymentButton.setBorderPainted(false);
		paymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// paymentCheckSceneImage.setVisible(true);

				if (selectIngerdientsCount == buyBurgerSetCount) {
					mainPurchaseScene.setVisible(false);
					paymentCheckScene.setVisible(true);
					insertCardButton.setVisible(true);
					
					// ����Ȯ�� â�� ���
					textArea.setVisible(true);

					for (int i = 0; i < orderProduct.size(); i++) {
						textArea.append(orderProduct.get(i) + "\n");
						System.out.println(orderProduct.get(i) + "\n");
					}
					System.out.println("���ż���Ƚ��" + buyBurgerSetCount);
					System.out.println("�߰�������Ʈ ���� Ƚ��" + selectIngerdientsCount);
				} else {
					JOptionPane.showMessageDialog(frame, "��Ʈ ����ǰ�� �������� �ʾҽ��ϴ�.", "SYSTEM",
							JOptionPane.INFORMATION_MESSAGE);
					System.out.println("���ż���Ƚ��" + buyBurgerSetCount);
					System.out.println("�߰�������Ʈ ���� Ƚ��" + selectIngerdientsCount);
				}
			}
		});
		mainPurchaseScene.add(paymentButton);

		nextPageButton.setBounds(537, 360, 50, 80);
		nextPageButton.setBorderPainted(false);
		nextPageButton.setContentAreaFilled(false);
		nextPageButton.setFocusPainted(false);
		nextPageButton.setIcon(new ImageIcon("./otherimages/nextButton.png"));
		nextPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menupage < 6) {

					menupage++;
					changeMenu();

					if (menupage == 0 || menupage == 1) {
						hamburgerSetButton.setBackground(Color.gray);
						hamburgerButton.setBackground(Color.white);
						drinkButton.setBackground(Color.white);
						dessertButton.setBackground(Color.white);

					} else if (menupage == 2 || menupage == 3) {
						hamburgerSetButton.setBackground(Color.white);
						hamburgerButton.setBackground(Color.gray);
						drinkButton.setBackground(Color.white);
						dessertButton.setBackground(Color.white);

					} else if (menupage == 4 || menupage == 5) {
						hamburgerSetButton.setBackground(Color.white);
						hamburgerButton.setBackground(Color.white);
						drinkButton.setBackground(Color.white);
						dessertButton.setBackground(Color.gray);

					} else if (menupage == 6) {
						hamburgerSetButton.setBackground(Color.white);
						hamburgerButton.setBackground(Color.white);
						drinkButton.setBackground(Color.gray);
						dessertButton.setBackground(Color.white);

					}
				}
			}
		});
		mainPurchaseScene.add(nextPageButton);

		previousPageButton.setBounds(3, 360, 50, 80);
		previousPageButton.setBorderPainted(false);
		previousPageButton.setContentAreaFilled(false);
		previousPageButton.setFocusPainted(false);
		previousPageButton.setIcon(new ImageIcon("./otherimages/previousButton.png"));
		previousPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menupage > 0) {

					menupage--;
					changeMenu();

					if (menupage == 0 || menupage == 1) {
						hamburgerSetButton.setBackground(Color.gray);
						hamburgerButton.setBackground(Color.white);
						drinkButton.setBackground(Color.white);
						dessertButton.setBackground(Color.white);

					} else if (menupage == 2 || menupage == 3) {
						hamburgerSetButton.setBackground(Color.white);
						hamburgerButton.setBackground(Color.gray);
						drinkButton.setBackground(Color.white);
						dessertButton.setBackground(Color.white);

					} else if (menupage == 4 || menupage == 5) {
						hamburgerSetButton.setBackground(Color.white);
						hamburgerButton.setBackground(Color.white);
						drinkButton.setBackground(Color.white);
						dessertButton.setBackground(Color.gray);

					} else if (menupage == 6) {
						hamburgerSetButton.setBackground(Color.white);
						hamburgerButton.setBackground(Color.white);
						drinkButton.setBackground(Color.gray);
						dessertButton.setBackground(Color.white);
					}
				}
			}
		});
		mainPurchaseScene.add(previousPageButton);

		// ��Ʈ �������� �ڵ��
		ingerdientsPreviousPageButton.setBounds(3, 360, 50, 80);
		ingerdientsPreviousPageButton.setBorderPainted(false);
		ingerdientsPreviousPageButton.setContentAreaFilled(false);
		ingerdientsPreviousPageButton.setFocusPainted(false);
		ingerdientsPreviousPageButton.setIcon(new ImageIcon("./otherimages/previousButton.png"));
		ingerdientsPreviousPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("����Ʈ ������ ���");
				if (ingerdientsPage > 0) {

					ingerdientsPage--;
					changeIngerdientsMenu();

					if (ingerdientsPage == 0) {
						ingerdientsDessertButton.setBackground(Color.gray);
						ingerdientsDrinkButton.setBackground(Color.white);
						System.out.println("����Ʈ ������ ���");
					} else if (ingerdientsPage == 1) {
						ingerdientsDessertButton.setBackground(Color.white);
						ingerdientsDrinkButton.setBackground(Color.gray);
						System.out.println("�巷ũ ������ ���");
					}
				}
			}
		});
		mainPurchaseScene.add(ingerdientsPreviousPageButton);

		ingerdientsDessertButton.setBounds(90, 150, 100, 40);
		ingerdientsDessertButton.setText("��Ʈ_����Ʈ");
		ingerdientsDessertButton.setFont(new Font("����", Font.BOLD, 10));
		ingerdientsDessertButton.setBackground(Color.gray);
		ingerdientsDessertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingerdientsDessertButton.setBackground(Color.gray);
				ingerdientsDrinkButton.setBackground(Color.white);

				ingerdientsPage = 0;
				changeIngerdientsMenu();
			}
		});
		mainPurchaseScene.add(ingerdientsDessertButton);

		ingerdientsDrinkButton.setBounds(190, 150, 100, 40);
		ingerdientsDrinkButton.setText("��Ʈ_�帵ũ");
		ingerdientsDrinkButton.setFont(new Font("����", Font.BOLD, 10));
		ingerdientsDrinkButton.setBackground(Color.white);
		ingerdientsDrinkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (hamburgerSetDessert != "") {
					ingerdientsDessertButton.setBackground(Color.white);
					ingerdientsDrinkButton.setBackground(Color.gray);

					ingerdientsPage = 1;
					changeIngerdientsMenu();
				} else {
					JOptionPane.showMessageDialog(frame, "��Ʈ_����Ʈ ���� �����ϼ���.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		mainPurchaseScene.add(ingerdientsDrinkButton);

		ingerdientsNextPageButton.setBounds(537, 360, 50, 80);
		ingerdientsNextPageButton.setBorderPainted(false);
		ingerdientsNextPageButton.setContentAreaFilled(false);
		ingerdientsNextPageButton.setFocusPainted(false);
		ingerdientsNextPageButton.setIcon(new ImageIcon("./otherimages/nextButton.png"));
		ingerdientsNextPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("�帵ũ ������ ���");

				if (hamburgerSetDessert != "") {
					if (ingerdientsPage < 2) {

						ingerdientsPage++;
						changeIngerdientsMenu();

						if (ingerdientsPage == 0) {
							ingerdientsDessertButton.setBackground(Color.gray);
							ingerdientsDrinkButton.setBackground(Color.white);
							System.out.println("����Ʈ ������ ���");
						} else if (ingerdientsPage == 1) {
							ingerdientsDessertButton.setBackground(Color.white);
							ingerdientsDrinkButton.setBackground(Color.gray);
							System.out.println("�巷ũ ������ ���");
						}
					}
				} else {
					JOptionPane.showMessageDialog(frame, "��Ʈ_����Ʈ ���� �����ϼ���.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		mainPurchaseScene.add(ingerdientsNextPageButton);

		//�޴� �̹��� ��ư �ʱ�ȭ
		for (int i = 0; i < menuImages.length; i++) {
			mainPurchaseScene.add(menuImages[i] = new JButton());

			menuImages[i].setHorizontalAlignment(SwingConstants.CENTER);

			if (i < 3) {
				menuVerticalLength = 190;
				menuImages[i].setBounds(menuHorizontalLength, menuVerticalLength, menuImageWidth, menuImageHeight);

			} else if ((i >= 3) && (i < 6)) {
				menuVerticalLength = 330;
				menuImages[i].setBounds(menuHorizontalLength, menuVerticalLength, menuImageWidth, menuImageHeight);

			} else if ((i >= 6) && (i < 9)) {
				menuVerticalLength = 470;
				menuImages[i].setBounds(menuHorizontalLength, menuVerticalLength, menuImageWidth, menuImageHeight);

			}

			menuHorizontalLength = menuHorizontalInterval + menuHorizontalLength;

			if ((i + 1) % 3 == 0) {
				menuHorizontalLength = 50;
			}

			menuImages[i].setBorderPainted(false);
			menuImages[i].setContentAreaFilled(false);
			menuImages[i].setFocusPainted(false);
		}

		// ��Ʈ ���� �̹��� ��ư �ʱ�ȭ
		for (int i = 0; i < ingerdientsMenuImages.length; i++) {
			mainPurchaseScene.add(ingerdientsMenuImages[i] = new JButton());

			ingerdientsMenuImages[i].setHorizontalAlignment(SwingConstants.CENTER);

			if (i < 4) {
				ingerdientsMenuVerticalLength = 190;
				ingerdientsMenuImages[i].setBounds(ingerdientsMenuHorizontalLength, ingerdientsMenuVerticalLength,
						ingerdientsMenuImageWidth, ingerdientsMenuImageHeight);

			} else if ((i >= 4) && (i < 8)) {
				ingerdientsMenuVerticalLength = 330;
				ingerdientsMenuImages[i].setBounds(ingerdientsMenuHorizontalLength, ingerdientsMenuVerticalLength,
						ingerdientsMenuImageWidth, ingerdientsMenuImageHeight);

			} else if ((i >= 8) && (i < 12)) {
				ingerdientsMenuVerticalLength = 470;
				ingerdientsMenuImages[i].setBounds(ingerdientsMenuHorizontalLength, ingerdientsMenuVerticalLength,
						ingerdientsMenuImageWidth, ingerdientsMenuImageHeight);

			}

			ingerdientsMenuHorizontalLength = ingerdientsMenuHorizontalInterval + ingerdientsMenuHorizontalLength;

			if ((i + 1) % 4 == 0) {
				ingerdientsMenuHorizontalLength = 50;
			}

			ingerdientsMenuImages[i].setBorderPainted(false);
			ingerdientsMenuImages[i].setContentAreaFilled(false);
			ingerdientsMenuImages[i].setFocusPainted(false);
		}

		orderDetailsText.setBounds(90, 570, 200, 100);
		orderDetailsText.setText("���ֹ�����");
		orderDetailsText.setHorizontalAlignment(SwingConstants.CENTER);
		orderDetailsText.setFont(new Font("����", Font.BOLD, 15));
		mainPurchaseScene.add(orderDetailsText);

		amountText.setBounds(210, 570, 200, 100);
		amountText.setText("0��");
		amountText.setHorizontalAlignment(SwingConstants.CENTER);
		amountText.setFont(new Font("����", Font.BOLD, 15));
		mainPurchaseScene.add(amountText);

		priceText.setBounds(320, 570, 200, 100);
		priceText.setText("0��");
		priceText.setHorizontalAlignment(SwingConstants.CENTER);
		priceText.setFont(new Font("����", Font.BOLD, 15));
		mainPurchaseScene.add(priceText);

		orderDetailsBackGround.setBounds(50, 607, 490, 20);
		orderDetailsBackGround.setIcon(new ImageIcon("./otherimages/empty.png"));
		mainPurchaseScene.add(orderDetailsBackGround);

		// �޴� ��ư�� ������ ������ �޴����� �ֹ������� ��µȴ�
		for (int i = 0; i < menuImages.length; i++) {
			menuImages[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					orderStatusText.add(new JLabel());
					removeButton.add(new JButton());
					quantityChangeButton.add(new JButton());

					for (int i = 0; i < menuImages.length; i++) {
						if (e.getSource() == menuImages[i]) {
							if (menupage == 0) {
								if (i == 0) {
									changeIngredientsScene();
									doubleX2Set.buy();
									selectedSetMenu = doubleX2Set;
									
								} else if (i == 1) {
									changeIngredientsScene();
									wagyuEdition2Set.buy();
									selectedSetMenu = wagyuEdition2Set;
									
								} else if (i == 2) {
									changeIngredientsScene();
									AZBurgerSet.buy();
									selectedSetMenu = AZBurgerSet;
									
								} else if (i == 3) {
									changeIngredientsScene();
									hanwooBulgogiCombo.buy();
									selectedSetMenu = hanwooBulgogiCombo;
									
								} else if (i == 4) {
									changeIngredientsScene();
									hanwooBulgogiBurgerSet.buy();
									selectedSetMenu = hanwooBulgogiBurgerSet;
									
								} else if (i == 5) {
									changeIngredientsScene();
									mozzarellaInTheBurgerSet.buy();
									selectedSetMenu = mozzarellaInTheBurgerSet;
									
								} else if (i == 6) {
									changeIngredientsScene();
									bigBulgogiSet.buy();
									selectedSetMenu = bigBulgogiSet;
									
								} else if (i == 7) {
									changeIngredientsScene();
									hotCrispyBurgerSet.buy();
									selectedSetMenu = hotCrispyBurgerSet;
									
								} else if (i == 8) {
									changeIngredientsScene();
									bulgogiBurgerSet.buy();
									selectedSetMenu = bulgogiBurgerSet;
									
								}
							} else if (menupage == 1) {
								if (i == 0) {
									changeIngredientsScene();
									riaMiracleBurgerSet.buy();
									selectedSetMenu = riaMiracleBurgerSet;
									
								} else if (i == 1) {
									changeIngredientsScene();
									shrimpBurgerSet.buy();
									selectedSetMenu = shrimpBurgerSet;
									
								} else if (i == 2) {
									changeIngredientsScene();
									chickenBurgerSet.buy();
									selectedSetMenu = chickenBurgerSet;
									
								} else if (i == 3) {
									changeIngredientsScene();
									T_RexBurgerSet.buy();
									selectedSetMenu = T_RexBurgerSet;
									
								} else if (i == 4) {
									changeIngredientsScene();
									classicCheeseBurgerSet.buy();
									selectedSetMenu = classicCheeseBurgerSet;
									
								} else if (i == 5) {
									changeIngredientsScene();
									teriBurgerSet.buy();
									selectedSetMenu = teriBurgerSet;
								}
							} else if (menupage == 2) {
								if (i == 0) {
									wagyuEdition2.buy();
								} else if (i == 1) {
									doubleX2.buy();
								} else if (i == 2) {
									mozzarellaInTheBurger.buy();
								} else if (i == 3) {
									AZBurger.buy();
								} else if (i == 4) {
									bigBulgogi.buy();
								} else if (i == 5) {
									hotCrispyBurger.buy();
								} else if (i == 6) {
									hanwooBulgogi.buy();
								} else if (i == 7) {
									riaMiracleBurger.buy();
								} else if (i == 8) {
									shrimpBurger.buy();
								}
							} else if (menupage == 3) {
								if (i == 0) {
									chickenBurger.buy();
								} else if (i == 1) {
									T_RexBurger.buy();
								} else if (i == 2) {
									classicCheeseBurger.buy();
								} else if (i == 3) {
									teriBurger.buy();
								}
							} else if (menupage == 4) {
								if (i == 0) {
									cheeseInTheEgg.buy();
								} else if (i == 1) {
									jipieHabanero_L.buy();
								} else if (i == 2) {
									jipie_S.buy();
								} else if (i == 3) {
									chickenNugget.buy();
								} else if (i == 4) {
									longCheeseStick.buy();
								} else if (i == 5) {
									coneSalad.buy();
								} else if (i == 6) {
									sundayIceCream.buy();
								} else if (i == 7) {
									shakeShakeChicken.buy();
								} else if (i == 8) {
									seasoningPotato.buy();
								}
							} else if (menupage == 5) {
								if (i == 0) {
									squidRing.buy();
								} else if (i == 1) {
									naturalCheeseStick.buy();
								} else if (i == 2) {
									potato.buy();
								} else if (i == 3) {
									chocoCookieTornado.buy();
								} else if (i == 4) {
									greenTeaTornado.buy();
								} else if (i == 5) {
									strawberryTornado.buy();
								} else if (i == 6) {
									softCone.buy();
								}
							} else if (menupage == 6) {
								if (i == 0) {
									iceAmericano.buy();
								} else if (i == 1) {
									cider.buy();
								} else if (i == 2) {
									cola.buy();
								} else if (i == 3) {
									americano.buy();
								} else if (i == 4) {
									caffeLatte.buy();
								} else if (i == 5) {
									iceCaffeLatte.buy();
								}
							}
						}
					}

					orderStatusText.get(orderStatusTextNumber).setFont((new Font("����ü", Font.BOLD, 12)));

					removeButton.get(orderStatusTextNumber).setIcon(new ImageIcon("./otherimages/cancel.jpg"));
					quantityChangeButton.get(orderStatusTextNumber).setIcon(new ImageIcon("./otherimages/plus.jpg"));

					orderStatusBackGround.add(orderStatusText.get(orderStatusTextNumber));
					orderStatusBackGround.add(removeButton.get(orderStatusTextNumber));
					orderStatusBackGround.add(quantityChangeButton.get(orderStatusTextNumber));

					OrderStatusVerticalLength = -40;
					if (orderStatusTextNumber != 0) {
						for (int i = 0; i < orderStatusTextNumber; i++) {
							OrderStatusVerticalLength = OrderStatusVerticalLength + 20;
						}
					}
					System.out.println("orderStatusTextNumber" + orderStatusTextNumber);
					System.out.println(OrderStatusVerticalLength);

					orderStatusText.get(orderStatusTextNumber).setBounds(5, OrderStatusVerticalLength, 490, 110);
					removeButton.get(orderStatusTextNumber).setBounds(460, OrderStatusVerticalLength + 43, 20, 20);
					quantityChangeButton.get(orderStatusTextNumber).setBounds(430, OrderStatusVerticalLength + 43, 20, 20);

					orderStatusTextNumber++;

					for (int i = 0; i < orderStatusText.size(); i++) {
						removeButton.get(i).addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								for (int i = 0; i < orderStatusText.size(); i++) {
									if (e.getSource() == removeButton.get(i)) {
										orderStatusText.get(i).setLocation(1000, 1000);
										removeButton.get(i).setLocation(1000, 1000);
										quantityChangeButton.get(i).setLocation(1000, 1000);

										orderStatusText.remove(i);
										removeButton.remove(i);
										quantityChangeButton.remove(i);

										orderStatusTextNumber--;

										if (orderStatusText.size() == 0) {

										} else {
											// x��ư�� ������ ��ĭ�� �������.
											for (int j = 0; j < orderStatusText.size(); j++) {
												if (i + j < orderStatusText.size()) {
													orderStatusText.get(i + j).setLocation(
															orderStatusText.get(i + j).getX(),
															orderStatusText.get(i + j).getY() - 20);
													removeButton.get(i + j).setLocation(removeButton.get(i + j).getX(),
															removeButton.get(i + j).getY() - 20);
													quantityChangeButton.get(i + j).setLocation(
															quantityChangeButton.get(i + j).getX(),
															quantityChangeButton.get(i + j).getY() - 20);
												}
											}
										}

										System.out.println("�����߽��ϴ�.");

										// �ܹ��� ��Ʈ ���� ���

										if (orderProductName.get(i).equals(doubleX2Set.productName)) {
											doubleX2Set.cancel();
											break;

										} else if (orderProductName.get(i).equals(wagyuEdition2Set.productName)) {
											wagyuEdition2Set.cancel();
											break;

										} else if (orderProductName.get(i).equals(AZBurgerSet.productName)) {
											AZBurgerSet.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(hanwooBulgogiCombo.productName)) {
											hanwooBulgogiCombo.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(hanwooBulgogiBurgerSet.productName)) {
											hanwooBulgogiBurgerSet.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(mozzarellaInTheBurgerSet.productName)) {
											mozzarellaInTheBurgerSet.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(bigBulgogiSet.productName)) {
											bigBulgogiSet.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(hotCrispyBurgerSet.productName)) {
											hotCrispyBurgerSet.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(bulgogiBurgerSet.productName)) {
											bulgogiBurgerSet.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(riaMiracleBurgerSet.productName)) {
											riaMiracleBurgerSet.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(shrimpBurgerSet.productName)) {
											shrimpBurgerSet.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(chickenBurgerSet.productName)) {
											chickenBurgerSet.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(T_RexBurgerSet.productName)) {
											T_RexBurgerSet.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(classicCheeseBurgerSet.productName)) {
											classicCheeseBurgerSet.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(teriBurgerSet.productName)) {
											teriBurgerSet.cancel();
											break;
										}

										// �ܹ��� ���� ���
										else if (orderProductName.get(i).equals(wagyuEdition2.productName)) {
											wagyuEdition2.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(doubleX2.productName)) {
											doubleX2.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(mozzarellaInTheBurger.productName)) {
											mozzarellaInTheBurger.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(AZBurger.productName)) {
											AZBurger.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(bigBulgogi.productName)) {
											bigBulgogi.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(hotCrispyBurger.productName)) {
											hotCrispyBurger.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(hanwooBulgogi.productName)) {
											hanwooBulgogi.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(riaMiracleBurger.productName)) {
											riaMiracleBurger.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(shrimpBurger.productName)) {
											shrimpBurger.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(chickenBurger.productName)) {
											chickenBurger.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(T_RexBurger.productName)) {
											T_RexBurger.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(classicCheeseBurger.productName)) {
											classicCheeseBurger.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(teriBurger.productName)) {
											teriBurger.cancel();
											break;
										}

										// ����Ʈ ���� ���
										else if (orderProductName.get(i).equals(cheeseInTheEgg.productName)) {
											cheeseInTheEgg.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(jipieHabanero_L.productName)) {
											jipieHabanero_L.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(jipie_S.productName)) {
											jipie_S.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(chickenNugget.productName)) {
											chickenNugget.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(longCheeseStick.productName)) {
											longCheeseStick.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(coneSalad.productName)) {
											coneSalad.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(sundayIceCream.productName)) {
											sundayIceCream.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(shakeShakeChicken.productName)) {
											shakeShakeChicken.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(seasoningPotato.productName)) {
											seasoningPotato.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(squidRing.productName)) {
											squidRing.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(naturalCheeseStick.productName)) {
											naturalCheeseStick.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(potato.productName)) {
											potato.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(chocoCookieTornado.productName)) {
											chocoCookieTornado.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(greenTeaTornado.productName)) {
											greenTeaTornado.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(strawberryTornado.productName)) {
											strawberryTornado.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(softCone.productName)) {
											softCone.cancel();
											break;
										}

										// �帵ũ ���� ���
										else if (orderProductName.get(i).equals(iceAmericano.productName)) {
											iceAmericano.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(cider.productName)) {
											cider.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(cola.productName)) {
											cola.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(americano.productName)) {
											americano.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(caffeLatte.productName)) {
											caffeLatte.cancel();
											break;
										}

										else if (orderProductName.get(i).equals(iceCaffeLatte.productName)) {
											iceCaffeLatte.cancel();
											break;
										}
									}
								}
							}
						});

						// TODO Ȯ���غ��� 
						quantityChangeButton.get(i).addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								for (int i = 0; i < orderStatusText.size(); i++) {
									if (e.getSource() == quantityChangeButton.get(i)) {
										orderSituationBackGround.setVisible(true);
										howManyText.setText("����  : 1 ��");
										productNum = i;
									}
								}
							}
						});
					}

				}
			});
		}

		// ��Ʈ�޴� �߰����� ��ư �ʱ�ȭ
		for (int i = 0; i < ingerdientsMenuImages.length; i++) {
			ingerdientsMenuImages[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					for (int j = 0; j < ingerdientsMenuImages.length; j++) {
						if (e.getSource() == ingerdientsMenuImages[j]) {
							if (ingerdientsPage == 0) {
								if (j == 0) {
									System.out.println("��������");
									ingerdientsNextPage();
									ingerdientsProductName.add("��������");
									System.out.println(ingerdientsProductName.toString());
									hamburgerSetDessert = "��������";
								} else if (j == 1) {
									System.out.println("�ܻ�����");
									ingerdientsNextPage();
									ingerdientsProductName.add("�ܻ�����");
									System.out.println(ingerdientsProductName.toString());
									hamburgerSetDessert = "�ܻ�����";
								} else if (j == 2) {
									System.out.println("��ġ�ƽ");
									ingerdientsNextPage();
									ingerdientsProductName.add("��ġ�ƽ");
									System.out.println(ingerdientsProductName.toString());
									hamburgerSetDessert = "��ġ�ƽ";
								} else if (j == 3) {
									System.out.println("��䰨��");
									ingerdientsNextPage();
									ingerdientsProductName.add("��䰨��");
									System.out.println(ingerdientsProductName.toString());
									hamburgerSetDessert = "��䰨��";
								} else if (j == 4) {
									System.out.println("��¡�");
									ingerdientsNextPage();
									ingerdientsProductName.add("��¡�");
									System.out.println(ingerdientsProductName.toString());
									hamburgerSetDessert = "��¡�";
								} else if (j == 5) {
									System.out.println("ġ�ƽ");
									ingerdientsNextPage();
									ingerdientsProductName.add("ġ�ƽ");
									System.out.println(ingerdientsProductName.toString());
									hamburgerSetDessert = "ġ�ƽ";
								} else if (j == 6) {
									System.out.println("������ ����Ѹ�");
									ingerdientsNextPage();
									ingerdientsProductName.add("������ ����Ѹ�");
									System.out.println(ingerdientsProductName.toString());
									hamburgerSetDessert = "������ ����Ѹ�";
								} else if (j == 7) {
									System.out.println("������ �Ϲٳ׷�");
									ingerdientsNextPage();
									ingerdientsProductName.add("������ �Ϲٳ׷�");
									System.out.println(ingerdientsProductName.toString());
									hamburgerSetDessert = "������ �Ϲٳ׷�";
								} else if (j == 8) {
									System.out.println("����ġŲ");
									ingerdientsNextPage();
									ingerdientsProductName.add("����ġŲ");
									System.out.println(ingerdientsProductName.toString());
									hamburgerSetDessert = "����ġŲ";
								} else if (j == 9) {
									System.out.println("ġ���δ�����");
									ingerdientsNextPage();
									ingerdientsProductName.add("ġ���δ�����");
									System.out.println(ingerdientsProductName.toString());
									hamburgerSetDessert = "ġ���δ�����";
								}
							} else if (ingerdientsPage == 1) {
								if (j == 0) {
									System.out.println("�ݶ�");
									ingerdientsProductName.add("�ݶ�");
									System.out.println(ingerdientsProductName.toString());
									changeMainPurchaseScene();
									hamburgerSetDrink  = "�ݶ�";
								} else if (j == 1) {
									System.out.println("���̴�");
									ingerdientsProductName.add("���̴�");
									System.out.println(ingerdientsProductName.toString());
									changeMainPurchaseScene();
									hamburgerSetDrink  = "���̴�";
								} else if (j == 2) {
									System.out.println("�Ƹ޸�ī��");
									ingerdientsProductName.add("�Ƹ޸�ī��");
									System.out.println(ingerdientsProductName.toString());
									changeMainPurchaseScene();
									hamburgerSetDrink  = "�Ƹ޸�ī��";
								} else if (j == 3) {
									System.out.println("���̽� �Ƹ޸�ī��");
									ingerdientsProductName.add("���̽� �Ƹ޸�ī��");
									System.out.println(ingerdientsProductName.toString());
									changeMainPurchaseScene();
									hamburgerSetDrink  = "���̽� �Ƹ޸�ī��";
								} else if (j == 4) {
									System.out.println("ī���");
									ingerdientsProductName.add("ī���");
									System.out.println(ingerdientsProductName.toString());
									changeMainPurchaseScene();
									hamburgerSetDrink  = "ī���";
								} else if (j == 5) {
									System.out.println("���̽� ī���");
									ingerdientsProductName.add("���̽� ī���");
									System.out.println(ingerdientsProductName.toString());
									changeMainPurchaseScene();
									hamburgerSetDrink  = "���̽� ī���";
								}
							}
						}
					}
					
					if (hamburgerSetDessert != "" && hamburgerSetDrink  != "") {
						selectIngerdientsCount++;
						System.out.println("����Ʈ ���� �̸�: " + hamburgerSetDessert);
						System.out.println("�帵ũ ���� �̸�: " + hamburgerSetDrink );
						System.out.println("���ż���Ƚ��" + buyBurgerSetCount);
						System.out.println("�߰�������Ʈ ���� Ƚ��" + selectIngerdientsCount);
					
						//���õ� �ܹ��ż�Ʈ�� ����, �帵ũ�� ����
						changeSetMenu.changeSetMenu(selectedSetMenu , hamburgerSetDrink, hamburgerSetDessert);
					}
				}
			});
		}

		orderStatusBackGround.setBounds(50, 630, 490, 110);
		orderStatusBackGround.setIcon(new ImageIcon("./otherimages/empty.png"));
		mainPurchaseScene.add(orderStatusBackGround);

		howManyAddText.setBounds(140, -20, 300, 100);
		howManyAddText.setText("� �߰��Ͻðڽ��ϱ�?");
		howManyAddText.setFont(new Font("����", Font.BOLD, 20));
		orderSituationBackGround.add(howManyAddText);

		howManyText.setBounds(210, 80, 300, 100);
		howManyText.setText("���� : 1 ��");
		howManyText.setFont(new Font("����", Font.BOLD, 15));
		orderSituationBackGround.add(howManyText);

		oneThing.setText("1��");
		oneThing.setFont(new Font("����", Font.BOLD, 20));
		oneThing.setBounds(70, 60, 100, 50);
		orderSituationBackGround.add(oneThing);

		fiveThing.setText("5��");
		fiveThing.setFont(new Font("����", Font.BOLD, 20));
		fiveThing.setBounds(200, 60, 100, 50);
		orderSituationBackGround.add(fiveThing);

		tenThing.setText("10��");
		tenThing.setFont(new Font("����", Font.BOLD, 20));
		tenThing.setBounds(330, 60, 100, 50);
		orderSituationBackGround.add(tenThing);

		checkButton.setText("Ȯ��");
		checkButton.setFont(new Font("����", Font.BOLD, 20));
		checkButton.setBounds(140, 150, 100, 30);
		orderSituationBackGround.add(checkButton);

		cancelAddButton.setText("���");
		cancelAddButton.setFont(new Font("����", Font.BOLD, 20));
		cancelAddButton.setBounds(260, 150, 100, 30);
		orderSituationBackGround.add(cancelAddButton);
		
		// �� �ش�Ǵ� ��ư�� ������ �� ���ڸ�ŭ ��ǰ ���� �߰���
		oneThing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProducts(1);
			}
		});
		fiveThing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProducts(5);
			}
		});
		tenThing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProducts(10);
			}
		});
		
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderSituationBackGround.setVisible(false);
			}
		});
		
		cancelAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderSituationBackGround.setVisible(false);
				
				//�߰��� �� ��ŭ ��ǰ�� ����
				/*
				selectedSetMenu.amount = selectedSetMenu.amount - addProductNum;
				System.out.println("selectedSetMenu.amount" + selectedSetMenu.amount);
				System.out.println("addProductNum" + addProductNum);
				
				totalPrice = totalPrice - selectedSetMenu.price*(selectedSetMenu.amount - addProductNum - 1);
				totalAmount = totalAmount - addProductNum;
				priceText.setText(totalPrice + "��");
				amountText.setText(totalAmount + "��");
				
				addProductNum  = 0;
				*/
			}
		});

		// �����ϱ� �� üũ â
		paymentCheckScene.setBounds(0, 0, 600, 850);
		paymentCheckScene.setLayout(null);
		paymentCheckScene.setVisible(false);
		frame.getContentPane().add(paymentCheckScene);

		paymentCheckSceneImage.setBounds(0, 0, 600, 850);
		paymentCheckSceneImage.setLayout(null);
		paymentCheckSceneImage.setVisible(true);
		paymentCheckSceneImage.setIcon(new ImageIcon("./otherimages/����Ȯ��â.png"));
		paymentCheckScene.add(paymentCheckSceneImage);

		// �����ϱ� �������� ī�� ����â
		cardPaymentSceneImage.setBounds(0, 0, 600, 850);
		cardPaymentSceneImage.setLayout(null);
		cardPaymentSceneImage.setVisible(false);
		cardPaymentSceneImage.setIcon(new ImageIcon("./otherimages/ī�����â.png"));
		paymentCheckScene.add(cardPaymentSceneImage);

		finalTotalAmount.setBounds(350, 400, 100, 20);
		finalTotalAmount.setText("�� ���� : " + totalAmount + " ��");
		finalTotalAmount.setLayout(null);
		finalTotalAmount.setVisible(true);
		paymentCheckSceneImage.add(finalTotalAmount);

		finalTotalPrice.setBounds(450, 400, 100, 20);
		finalTotalPrice.setText("�� " + totalPrice + " ��");
		finalTotalPrice.setLayout(null);
		finalTotalPrice.setVisible(true);
		paymentCheckSceneImage.add(finalTotalPrice);

		checkOKButton.setBounds(150, 500, 100, 30);
		checkOKButton.setText("�����ϱ�");
		checkOKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				paymentCheckSceneImage.setVisible(false);
				cardPaymentSceneImage.setVisible(true);
				insertCardButton.setVisible(true);
				//insertCardButton.setEnabled(true);
			}
		});
		paymentCheckSceneImage.add(checkOKButton);

		checkCancelButton.setBounds(350, 500, 100, 30);
		checkCancelButton.setText("��������");
		checkCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentCheckScene.setVisible(false);
				mainPurchaseScene.setVisible(true);

				textArea.selectAll();
				textArea.replaceSelection("");
			}
		});
		paymentCheckSceneImage.add(checkCancelButton);

		insertCardImage.setBounds(100, 220, 400, 300);
		insertCardImage.setIcon(new ImageIcon("./otherimages/ī������.png"));
		insertCardImage.setLayout(null);
		insertCardImage.setVisible(true);
		cardPaymentSceneImage.add(insertCardImage);

		insertCardButton.setBounds(100, 520, 400, 100);
		insertCardButton.setText("ī�� ����");
		insertCardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				changeCardPaymentImage changeCardPaymentImage = new changeCardPaymentImage(insertCardImage,
						insertCardButton, advertisingScene, mainPurchaseScene, cardPaymentSceneImage);
				changeCardPaymentImage.start();

				insertCardButton.setVisible(false);

				for (int i = 0; i < orderStatusText.size(); i++) {
					orderStatusText.get(i).setLocation(1000, 1000);
					removeButton.get(i).setLocation(1000, 1000);
					quantityChangeButton.get(i).setLocation(1000, 1000);
					// orderStatusText.remove(i);
				}

				orderStatusText.clear();
				orderStatusTextNumber = 0;
				OrderStatusVerticalLength = -40;
				eatingPlace = "";

				orderProductName.clear();
				totalAmount = 0;
				totalPrice = 0;
				amountText.setText(totalAmount + "��");
				priceText.setText(totalPrice + "��");

				finalTotalAmount.setText("�� ���� : " + totalAmount + " ��");
				finalTotalPrice.setText("��  " + totalPrice + " ��");

			}
		});
		cardPaymentSceneImage.add(insertCardButton);
		
		changeMenu();
		changeAdvertisingScene.start();
	}

	public void changeMenu() {
		// �ܹ��� ��Ʈ�޴�
		if (menupage == 0) {
			menuImages[0].setIcon(new ImageIcon("./hamburgerSetimages/����x2��Ʈ.png"));
			menuImages[1].setIcon(new ImageIcon("./hamburgerSetimages/�ͱԿ����2��Ʈ.png"));
			menuImages[2].setIcon(new ImageIcon("./hamburgerSetimages/AZ���ż�Ʈ.png"));
			menuImages[3].setIcon(new ImageIcon("./hamburgerSetimages/�ѿ�Ұ���޺�.png"));
			menuImages[4].setIcon(new ImageIcon("./hamburgerSetimages/�ѿ�Ұ�⼼Ʈ.png"));
			menuImages[5].setIcon(new ImageIcon("./hamburgerSetimages/��¥�����δ����ź�������Ʈ.png"));
			menuImages[6].setIcon(new ImageIcon("./hamburgerSetimages/������Ҽ�Ʈ.png"));
			menuImages[7].setIcon(new ImageIcon("./hamburgerSetimages/��ũ�����Ǽ�Ʈ.png"));
			menuImages[8].setIcon(new ImageIcon("./hamburgerSetimages/�Ұ����ż�Ʈ.png"));
		}

		else if (menupage == 1) {
			menuImages[0].setIcon(new ImageIcon("./hamburgerSetimages/���ƹ̶�Ŭ���ż�Ʈ.png"));
			menuImages[1].setIcon(new ImageIcon("./hamburgerSetimages/������ż�Ʈ.png"));
			menuImages[2].setIcon(new ImageIcon("./hamburgerSetimages/ġŲ���ż�Ʈ.png"));
			menuImages[3].setIcon(new ImageIcon("./hamburgerSetimages/T-Rax���ż�Ʈ.png"));
			menuImages[4].setIcon(new ImageIcon("./hamburgerSetimages/Ŭ����ġ����ż�Ʈ.png"));
			menuImages[5].setIcon(new ImageIcon("./hamburgerSetimages/�������ż�Ʈ.png"));
			menuImages[6].setIcon(new ImageIcon());
			menuImages[7].setIcon(new ImageIcon());
			menuImages[8].setIcon(new ImageIcon());
		}

		// �ܹ���
		else if (menupage == 2) {
			menuImages[0].setIcon(new ImageIcon("./hamburgerimages/�ͱԿ����2.png"));
			menuImages[1].setIcon(new ImageIcon("./hamburgerimages/����x2.png"));
			menuImages[2].setIcon(new ImageIcon("./hamburgerimages/��¥�����δ����ź�����.png"));
			menuImages[3].setIcon(new ImageIcon("./hamburgerimages/AZ����.png"));
			menuImages[4].setIcon(new ImageIcon("./hamburgerimages/�������.png"));
			menuImages[5].setIcon(new ImageIcon("./hamburgerimages/��ũ�����ǹ���.png"));
			menuImages[6].setIcon(new ImageIcon("./hamburgerimages/�ѿ�Ұ��.png"));
			menuImages[7].setIcon(new ImageIcon("./hamburgerimages/���ƹ̶�Ŭ����.png"));
			menuImages[8].setIcon(new ImageIcon("./hamburgerimages/�������.png"));
		}

		else if (menupage == 3) {
			menuImages[0].setIcon(new ImageIcon("./hamburgerimages/ġŲ����.png"));
			menuImages[1].setIcon(new ImageIcon("./hamburgerimages/T-Rax.png"));
			menuImages[2].setIcon(new ImageIcon("./hamburgerimages/Ŭ����ġ�����.png"));
			menuImages[3].setIcon(new ImageIcon("./hamburgerimages/��������.png"));
			menuImages[4].setIcon(new ImageIcon());
			menuImages[5].setIcon(new ImageIcon());
			menuImages[6].setIcon(new ImageIcon());
			menuImages[7].setIcon(new ImageIcon());
			menuImages[8].setIcon(new ImageIcon());
		}

		// ����Ʈ
		else if (menupage == 4) {
			menuImages[0].setIcon(new ImageIcon("./dessertimages/ġ���δ�����.png"));
			menuImages[1].setIcon(new ImageIcon("./dessertimages/�������Ϻ�׷�.png"));
			menuImages[2].setIcon(new ImageIcon("./dessertimages/�����̰���Ѹ�.png"));
			menuImages[3].setIcon(new ImageIcon("./dessertimages/ġŲ�ʰ�.png"));
			menuImages[4].setIcon(new ImageIcon("./dessertimages/��ġ�ƽ.png"));
			menuImages[5].setIcon(new ImageIcon("./dessertimages/�ܻ�����.png"));
			menuImages[6].setIcon(new ImageIcon("./dessertimages/�������̽�ũ��.png"));
			menuImages[7].setIcon(new ImageIcon("./dessertimages/����ġŲ.png"));
			menuImages[8].setIcon(new ImageIcon("./dessertimages/��䰨��.png"));
		}

		else if (menupage == 5) {
			menuImages[0].setIcon(new ImageIcon("./dessertimages/��¡�.png"));
			menuImages[1].setIcon(new ImageIcon("./dessertimages/ġ�ƽ.png"));
			menuImages[2].setIcon(new ImageIcon("./dessertimages/��������.png"));
			menuImages[3].setIcon(new ImageIcon("./dessertimages/����̵�(������Ű).png"));
			menuImages[4].setIcon(new ImageIcon("./dessertimages/����̵�(����).png"));
			menuImages[5].setIcon(new ImageIcon("./dessertimages/����̵�(��Ʈ�κ���).png"));
			menuImages[6].setIcon(new ImageIcon("./dessertimages/����Ʈ��.png"));
			menuImages[7].setIcon(new ImageIcon());
			menuImages[8].setIcon(new ImageIcon());
		}

		// �帵ũ
		else if (menupage == 6) {
			menuImages[0].setIcon(new ImageIcon("./drinkimages/���̽��Ƹ޸�ī��.png"));
			menuImages[1].setIcon(new ImageIcon("./drinkimages/���̴�.png"));
			menuImages[2].setIcon(new ImageIcon("./drinkimages/�ݶ�.png"));
			menuImages[3].setIcon(new ImageIcon("./drinkimages/�Ƹ޸�ī��.png"));
			menuImages[4].setIcon(new ImageIcon("./drinkimages/ī���.png"));
			menuImages[5].setIcon(new ImageIcon("./drinkimages/���̽�ī���.png"));
			menuImages[6].setIcon(new ImageIcon());
			menuImages[7].setIcon(new ImageIcon());
			menuImages[8].setIcon(new ImageIcon());
		}
	}

	// ��� �߰��� ������
	public void addProducts(int addNum) {
		
		addProductNum = addProductNum + addNum;
		
		if (orderProductName.get(productNum).equals(doubleX2Set.productName)) {
			doubleX2Set.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		} else if (orderProductName.get(productNum).equals(wagyuEdition2Set.productName)) {
			wagyuEdition2Set.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		} else if (orderProductName.get(productNum).equals(AZBurgerSet.productName)) {
			AZBurgerSet.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		} else if (orderProductName.get(productNum).equals(hanwooBulgogiCombo.productName)) {
			hanwooBulgogiCombo.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);
		}

		else if (orderProductName.get(productNum).equals(hanwooBulgogiBurgerSet.productName)) {
			hanwooBulgogiBurgerSet.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		}

		else if (orderProductName.get(productNum).equals(mozzarellaInTheBurgerSet.productName)) {
			mozzarellaInTheBurgerSet.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		}

		else if (orderProductName.get(productNum).equals(bigBulgogiSet.productName)) {
			bigBulgogiSet.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		}

		else if (orderProductName.get(productNum).equals(hotCrispyBurgerSet.productName)) {
			hotCrispyBurgerSet.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		}

		else if (orderProductName.get(productNum).equals(bulgogiBurgerSet.productName)) {
			bulgogiBurgerSet.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		}

		else if (orderProductName.get(productNum).equals(riaMiracleBurgerSet.productName)) {
			riaMiracleBurgerSet.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		}

		else if (orderProductName.get(productNum).equals(shrimpBurgerSet.productName)) {
			shrimpBurgerSet.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		}

		else if (orderProductName.get(productNum).equals(chickenBurgerSet.productName)) {
			chickenBurgerSet.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		}

		else if (orderProductName.get(productNum).equals(T_RexBurgerSet.productName)) {
			T_RexBurgerSet.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		}

		else if (orderProductName.get(productNum).equals(classicCheeseBurgerSet.productName)) {
			classicCheeseBurgerSet.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		}

		else if (orderProductName.get(productNum).equals(teriBurgerSet.productName)) {
			teriBurgerSet.addNumOfHamburgerSet(addNum, productNum, hamburgerSetDrink, hamburgerSetDessert);

		}

		// �ܹ��� ���� ���
		else if (orderProductName.get(productNum).equals(wagyuEdition2.productName)) {
			wagyuEdition2.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(doubleX2.productName)) {
			doubleX2.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(mozzarellaInTheBurger.productName)) {
			mozzarellaInTheBurger.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(AZBurger.productName)) {
			AZBurger.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(bigBulgogi.productName)) {
			bigBulgogi.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(hotCrispyBurger.productName)) {
			hotCrispyBurger.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(hanwooBulgogi.productName)) {
			hanwooBulgogi.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(riaMiracleBurger.productName)) {
			riaMiracleBurger.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(shrimpBurger.productName)) {
			shrimpBurger.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(chickenBurger.productName)) {
			chickenBurger.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(T_RexBurger.productName)) {
			T_RexBurger.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(classicCheeseBurger.productName)) {
			classicCheeseBurger.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(teriBurger.productName)) {
			teriBurger.addNumOfProduct(addNum, productNum);

		}

		// ����Ʈ ���� ���
		else if (orderProductName.get(productNum).equals(cheeseInTheEgg.productName)) {
			cheeseInTheEgg.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(jipieHabanero_L.productName)) {
			jipieHabanero_L.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(jipie_S.productName)) {
			jipie_S.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(chickenNugget.productName)) {
			chickenNugget.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(longCheeseStick.productName)) {
			longCheeseStick.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(coneSalad.productName)) {
			coneSalad.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(sundayIceCream.productName)) {
			sundayIceCream.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(shakeShakeChicken.productName)) {
			shakeShakeChicken.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(seasoningPotato.productName)) {
			seasoningPotato.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(squidRing.productName)) {
			squidRing.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(naturalCheeseStick.productName)) {
			naturalCheeseStick.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(potato.productName)) {
			potato.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(chocoCookieTornado.productName)) {
			chocoCookieTornado.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(greenTeaTornado.productName)) {
			greenTeaTornado.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(strawberryTornado.productName)) {
			strawberryTornado.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(softCone.productName)) {
			softCone.addNumOfProduct(addNum, productNum);

		}

		// �帵ũ ���� ���
		else if (orderProductName.get(productNum).equals(iceAmericano.productName)) {
			iceAmericano.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(cider.productName)) {
			cider.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(cola.productName)) {
			cola.addNumOfProduct(addNum, productNum);

		}

		else if (orderProductName.get(productNum).equals(americano.productName)) {
			americano.addNumOfProduct(addNum, productNum);
		}

		else if (orderProductName.get(productNum).equals(caffeLatte.productName)) {
			caffeLatte.addNumOfProduct(addNum, productNum);
		}

		else if (orderProductName.get(productNum).equals(iceCaffeLatte.productName)) {
			iceCaffeLatte.addNumOfProduct(addNum, productNum);
		}
	}

	public void changeIngredientsScene() {
		cancelPageButton.setEnabled(false);
		changeIngerdientsMenu();
		buyBurgerSetCount++;

		hamburgerSetDessert = "";
		hamburgerSetDrink  = "";

		// ��Ʈ ������ �߰��� ���� ��������,������ư�� Ȱ��ȭ ��Ŵ
		for (int i = 0; i < orderStatusText.size(); i++) {
			// orderStatusText.get(i).setEditable(false);
			removeButton.get(i).setEnabled(false);
			quantityChangeButton.get(i).setEnabled(false);
			// orderStatusText.remove(i);
		}

		for (int i = 0; i < menuImages.length; i++) {
			menuImages[i].setVisible(false);
		}

		for (int i = 0; i < ingerdientsMenuImages.length; i++) {
			ingerdientsMenuImages[i].setVisible(true);
		}

		hamburgerSetButton.setVisible(false);
		hamburgerButton.setVisible(false);
		drinkButton.setVisible(false);
		dessertButton.setVisible(false);
		nextPageButton.setVisible(false);
		previousPageButton.setVisible(false);

		changeIngredientsScene.setVisible(true);
		ingerdientsNextPageButton.setVisible(true);
		ingerdientsPreviousPageButton.setVisible(true);
		ingerdientsDessertButton.setVisible(true);
		ingerdientsDrinkButton.setVisible(true);
	}

	public void changeMainPurchaseScene() {
		cancelPageButton.setEnabled(true);
		
		// ��Ʈ ������ �߰��� ���� ��������,������ư�� Ȱ��ȭ ��Ŵ
		for (int i = 0; i < orderStatusText.size(); i++) {
			// orderStatusText.get(i).setEditable(false);
			removeButton.get(i).setEnabled(true);
			quantityChangeButton.get(i).setEnabled(true);
			// orderStatusText.remove(i);
		}

		ingerdientsPage = 0;
		ingerdientsProductName.clear();
		System.out.println(ingerdientsProductName.toString());

		// ������ 0�� ����Ʈ ������ , ������ 1�� �帵ũ ������
		if (ingerdientsPage == 0) {
			ingerdientsDessertButton.setBackground(Color.gray);
			ingerdientsDrinkButton.setBackground(Color.white);
			System.out.println("����Ʈ ������ ���");
		} else if (ingerdientsPage == 1) {
			ingerdientsDessertButton.setBackground(Color.white);
			ingerdientsDrinkButton.setBackground(Color.gray);
			System.out.println("�巷ũ ������ ���");
		}

		for (int i = 0; i < menuImages.length; i++) {
			menuImages[i].setVisible(true);
		}

		for (int i = 0; i < ingerdientsMenuImages.length; i++) {
			ingerdientsMenuImages[i].setVisible(false);
		}

		hamburgerSetButton.setVisible(true);
		hamburgerButton.setVisible(true);
		drinkButton.setVisible(true);
		dessertButton.setVisible(true);
		nextPageButton.setVisible(true);
		previousPageButton.setVisible(true);

		changeIngredientsScene.setVisible(false);
		ingerdientsNextPageButton.setVisible(false);
		ingerdientsPreviousPageButton.setVisible(false);
		ingerdientsDessertButton.setVisible(false);
		ingerdientsDrinkButton.setVisible(false);
	}

	public void changeIngerdientsMenu() {

		if (ingerdientsPage == 0) {
			ingerdientsMenuImages[0].setIcon(new ImageIcon("./ingerdientsDessertImages/��������(��Ʈ����).png"));
			ingerdientsMenuImages[1].setIcon(new ImageIcon("./ingerdientsDessertImages/�ܼ�����(��Ʈ����).png"));
			ingerdientsMenuImages[2].setIcon(new ImageIcon("./ingerdientsDessertImages/��ġ�ƽ(��Ʈ����).png"));
			ingerdientsMenuImages[3].setIcon(new ImageIcon("./ingerdientsDessertImages/��䰨��(��Ʈ����).png"));
			ingerdientsMenuImages[4].setIcon(new ImageIcon("./ingerdientsDessertImages/��¡�(��Ʈ����).png"));
			ingerdientsMenuImages[5].setIcon(new ImageIcon("./ingerdientsDessertImages/ġ�ƽ(��Ʈ����).png"));
			ingerdientsMenuImages[6].setIcon(new ImageIcon("./ingerdientsDessertImages/������ ����Ѹ�(��Ʈ����).png"));
			ingerdientsMenuImages[7].setIcon(new ImageIcon("./ingerdientsDessertImages/������ �Ϲٳ׷�(��Ʈ����).png"));
			ingerdientsMenuImages[8].setIcon(new ImageIcon("./ingerdientsDessertImages/����ġŲ(��Ʈ����).png"));
			ingerdientsMenuImages[9].setIcon(new ImageIcon("./ingerdientsDessertImages/ġ���δ�����(��Ʈ����).png"));
			ingerdientsMenuImages[10].setIcon(new ImageIcon());
			ingerdientsMenuImages[11].setIcon(new ImageIcon());
			ingerdientsMenuImages[12].setIcon(new ImageIcon());
		}

		else if (ingerdientsPage == 1) {
			ingerdientsMenuImages[0].setIcon(new ImageIcon("./ingerdientsDrinkImages/�ݶ�(��Ʈ����).png"));
			ingerdientsMenuImages[1].setIcon(new ImageIcon("./ingerdientsDrinkImages/���̴�(��Ʈ����).png"));
			ingerdientsMenuImages[2].setIcon(new ImageIcon("./ingerdientsDrinkImages/�Ƹ޸�ī��(��Ʈ����).png"));
			ingerdientsMenuImages[3].setIcon(new ImageIcon("./ingerdientsDrinkImages/���̽��Ƹ޸�ī��(��Ʈ����).png"));
			ingerdientsMenuImages[4].setIcon(new ImageIcon("./ingerdientsDrinkImages/ī���(��Ʈ����).png"));
			ingerdientsMenuImages[5].setIcon(new ImageIcon("./ingerdientsDrinkImages/���̽�ī���(��Ʈ����).png"));
			ingerdientsMenuImages[6].setIcon(new ImageIcon());
			ingerdientsMenuImages[7].setIcon(new ImageIcon());
			ingerdientsMenuImages[8].setIcon(new ImageIcon());
			ingerdientsMenuImages[9].setIcon(new ImageIcon());
			ingerdientsMenuImages[10].setIcon(new ImageIcon());
			ingerdientsMenuImages[11].setIcon(new ImageIcon());
			ingerdientsMenuImages[12].setIcon(new ImageIcon());
		}
	}

	public void ingerdientsPreviousPage() {
		ingerdientsPage--;
		changeIngerdientsMenu();

		// ������ 0�� ����Ʈ ������ , ������ 1�� �帵ũ ������
		if (ingerdientsPage == 0) {
			ingerdientsDessertButton.setBackground(Color.gray);
			ingerdientsDrinkButton.setBackground(Color.white);
			System.out.println("����Ʈ ������ ���");
		} else if (ingerdientsPage == 1) {
			ingerdientsDessertButton.setBackground(Color.white);
			ingerdientsDrinkButton.setBackground(Color.gray);
			System.out.println("�巷ũ ������ ���");
		}
	}

	public void ingerdientsNextPage() {
		ingerdientsPage++;
		changeIngerdientsMenu();

		// ������ 0�� ����Ʈ ������ , ������ 1�� �帵ũ ������
		if (ingerdientsPage == 0) {
			ingerdientsDessertButton.setBackground(Color.gray);
			ingerdientsDrinkButton.setBackground(Color.white);
			System.out.println("����Ʈ ������ ���");
		} else if (ingerdientsPage == 1) {
			ingerdientsDessertButton.setBackground(Color.white);
			ingerdientsDrinkButton.setBackground(Color.gray);
			System.out.println("�巷ũ ������ ���");
		}
	}
}