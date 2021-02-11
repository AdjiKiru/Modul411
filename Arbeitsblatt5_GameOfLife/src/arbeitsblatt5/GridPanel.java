package arbeitsblatt5;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private int xcount=0;
	private int ycount=0;
	
	private final int maxDim=160;
	
	private boolean[][] feld;
	
	private Point rahmen;
	
	public GridPanel() {
		this.add(new JButton()); //nur so, um zu zeigen, dass dies auch möglich ist
		
		// Images sollen verschiebbar sein? Diesen Code einkommentieren
		this.addMouseListener(new MouseAdapter() {

			private Point pressedOn;
			private Point releasedOn;

			@Override
			public void mousePressed(MouseEvent e) {
				requestFocus(); // wichtig dammit der Key Lisener funzt!
				
				System.out.println("mousePressed " + e.getPoint().x + ", " + e.getPoint().y);
				pressedOn = calculateFeld(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("mouseReleased " + e.getPoint().x + ", " + e.getPoint().y);
				releasedOn = calculateFeld(e);

				if (!pressedOn.equals(releasedOn)) {
					// Image verschieben
					feld[releasedOn.x][releasedOn.y] = feld[pressedOn.x][pressedOn.y];
					feld[pressedOn.x][pressedOn.y] = Boolean.parseBoolean(null);
					
					rahmen=null;
					repaint();
				}
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
//				System.out.println("mouseMoved " + e.getPoint().x + ", " + e.getPoint().y);
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("mouseDragged " + e.getPoint().x + ", " + e.getPoint().y);
				// Rahmen um das Feld Zeichnen

				rahmen = calculateFeld(e);
				repaint();
			}
		});
		
		/*
		 * Achtung: damit der Key Listener bei einem Panel funzen kann muss dieses Panel
		 * den Focus haben! 
		 * Also, im Konstruktor oder so muss setFocusable(true);
		 * stehen. Zusätzlich muss mindestens einmal requestFocus(); aufgerufen werden
		 */
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("keyTyped: " + e.getKeyChar());				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased: " + e.getExtendedKeyCode());				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed:" + e.getExtendedKeyCode());				
			}
		});
		
	}
	
	private Point calculateFeld(MouseEvent e) {
		Point point = e.getPoint();

		int w = e.getComponent().getWidth() / xcount;
		int h = e.getComponent().getHeight() / ycount;

		// auf welchem feld?
		int x = point.x / w;
		int y = point.y / h;
		Point p = new Point(x, y);
		System.out.println("Klick auf Feld " + x + ", " + y);
		return p;
	}
	
	/*@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		System.out.println("paint");
		
		// wie viel Platz ist für jedes Element vorhanden?
		double w = (double)this.getWidth()  / xcount;
		double h = (double)this.getHeight() / ycount;
		
		for (int x = 0; x < xcount; x++) {
			for (int y = 0; y < ycount; y++) {
			}
		}
		
		// Drag Drop situation, Rahmen zeichnen
		if(rahmen!=null) {
			g.drawRect((int)(rahmen.x*w), (int)(rahmen.y*h), (int)w, (int)h);
		}
	}
	
	public void addImage(Image image, int x, int y) {
		if(x >= 0 && x < xcount)
		if(y >= 0 && y < ycount) {
			feld[x][y]=image;
		}else {
			throw new IllegalArgumentException("ungültige werte für x oder y");
		}
	}*/

	/**
	 * Setzt die Anzahl der möglichen Felder
	 * @param x
	 * @param y
	 */
	public void setDimension(int x, int y) {
		if(x >= 0 && x < maxDim && y >= 0 && y < maxDim) {
			this.xcount = x;
			this.ycount = y;
			feld = new boolean[x][y];
		}else {
			throw new IllegalArgumentException("ungültige werte für x oder y");
		}
	}
}
