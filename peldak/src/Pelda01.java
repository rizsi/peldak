import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Rajzolós példaprogram.
 * Eclipse-ben debug módban indítva azonnal újrarajzolja a képet ha elmentjük a jájlt.
 * @author rizsi
 *
 */
public class Pelda01 extends JFrame {
	private static final long serialVersionUID = 1L;
	BufferedImage image;
	JLabel l;

	public Pelda01() {
		setTitle("Első rajzolós programunk");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		image = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
		l = new JLabel(new ImageIcon(image));
		add(l);
		autoUpdate();
		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				autoUpdate();
			}
		});
		timer.start();
	}

	private void autoUpdate() {
		Graphics2D g = image.createGraphics();
		try {
			g.setBackground(new Color(128, 128, 255));
			g.clearRect(0, 0, 1024, 768);
			AffineTransform at=g.getTransform();
			g.translate(465, 225);
			
			drawCica(g);
			g.setTransform(at);
			g.translate(0, 300);
			g.rotate(Math.PI*0.3, 200,200);
			g.translate(280, 0);
			
			g.setTransform(at);
			g.translate(582,630);
			g.scale(.3, 0.3);
			for(int i=0; i<60; ++i)
			{
				g.translate(130,-30);
				g.rotate(-Math.PI*0.05, 0, 0);
				drawCica(g);
			}
			drawCica(g);
		} finally {
			g.dispose();
		}
		l.setIcon(new ImageIcon(image));
	}

	private void drawCica(Graphics2D g) {

		// Fej és test
		g.setColor(Color.GRAY);
		g.fillArc(0,0, 100, 100, 0, 360);
		g.fillArc(0,100, 100, 200, 0, 360);


		// Szemek
		g.setColor(Color.GREEN);
		drawCicrle(g, 35, 35,10);
		drawCicrle(g, 65, 35,10);

		// Farok
		g.setColor(Color.GRAY);
		g.fillArc(50, 285, 200, 30, 0,  360);

		// Lábak
		g.setColor(Color.WHITE);
		drawCicrle(g, 80, 290,15);
		drawCicrle(g, 20, 290,15);
		drawCicrle(g, 80, 118,15);
		drawCicrle(g, 20, 118,15);

		// Fülek
		g.setColor(Color.gray);
		g.fillPolygon(new int[]{0,0, 20}, new int[]{0,50,20}, 3);
		g.fillPolygon(new int[]{100,100, 80}, new int[]{0,50,20}, 3);
		
		// Orr
		g.setColor(Color.pink);
		drawCicrle(g, 50, 55);
		
		// Száj
		g.setColor(Color.red);
		g.drawArc(25, 50, 50, 25, 220,100);
	}

	private void drawCicrle(Graphics2D g, int x, int y) {
		int r = 5;
		g.fillArc(x - r, y - r, 2 * r, 2 * r, 0, 360);
	}
	private void drawCicrle(Graphics2D g, int x, int y, int r) {
		g.fillArc(x - r, y - r, 2 * r, 2 * r, 0, 360);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Pelda01 ex = new Pelda01();
			ex.setVisible(true);
		});
	}
}
