import java.awt.BasicStroke;
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
 */
public class Pelda02 extends JFrame {
	private static final long serialVersionUID = 1L;
	BufferedImage image;
	JLabel l;

	public Pelda02() {
		setTitle("Körben kör");
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
			g.translate(1024/2, 768/2);
			g.setStroke(new BasicStroke(3));
			double[] elozo=null;
			double R = 5.0;
			int n=31;
			int k=7;
			double r = R/n*k;
			double t = r*.7;
			double szog=30;
			for(szog=0; szog<=360*20;szog+=1)
			{
				Turtle turtle=new Turtle(g);
				turtle.draw=false;
				turtle.setColor(Color.green);
				turtle.turnLeft(szog);
				turtle.forward(R);
				turtle.setColor(Color.BLUE);
				turtle.turnLeft(180);
				turtle.forward(r);
				turtle.turnLeft(180);
				turtle.turnLeft(-szog*R/r);
				turtle.setColor(Color.pink);
				turtle.forward(t);
				turtle.drawLineFrom(elozo);
				elozo=turtle.getPoint();
			}
		} finally {
			g.dispose();
		}
		l.setIcon(new ImageIcon(image));
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Pelda02 ex = new Pelda02();
			ex.setVisible(true);
		});
	}
}
