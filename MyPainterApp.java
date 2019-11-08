import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;
public class MyPainterApp extends JComponent{
	private Image image;
	private Graphics2D g2;
	private int currentX,currentY,oldX,oldY;
	public MyPainterApp(){
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
			oldX=e.getX();
			oldY=e.getY();
			}
			
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				currentX=e.getX();
				currentY=e.getY();
				if(g2!=null){
					g2.drawLine(oldX,oldY,currentX,currentY);
					repaint();
					oldX=currentX;
					oldY=currentY; 
				}
			}
			
		});
	}
	protected void paintComponent(Graphics g){
		if(image==null){
			image=createImage(getWidth(),getHeight());
			g2=(Graphics2D)image.getGraphics();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
		}
		g.drawImage(image,0,0,null);
	}
	
	public void clear(){
		g2.setPaint(Color.WHITE);
		g2.fillRect(0, 0,10000,10000);
		g2.setPaint(Color.BLACK);
		repaint();
	}
	
}
