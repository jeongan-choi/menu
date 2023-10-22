import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChangeAdvertisingScene extends Thread{
	
	JLabel advertisingScene; // �����̹��� �ٲٴ� ��
	boolean running = true;
	
	public ChangeAdvertisingScene(JLabel advertisingScene){
		this.advertisingScene = advertisingScene;
	}
	
	@Override
	public synchronized void run() {
		while (running) {
			try {
				
				advertisingScene.setIcon(new ImageIcon("./otherimages/����x2���ű���.jpg"));
				sleep(5000);
				
				advertisingScene.setIcon(new ImageIcon("./otherimages/�������ɱ���.png"));
				sleep(5000);
				
				advertisingScene.setIcon(new ImageIcon("./otherimages/�����̱���.jpg"));
				sleep(5000);
				
			} catch (InterruptedException e) {
				running = false;
			}
		}
	}
}
