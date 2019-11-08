import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;
public class LineDrawerApp extends JComponent{
	private Image image;
	private Graphics2D g2;
	private int currentX,currentY,x1,y1,x2,y2,x3,y3,x4,y4;
	public LineDrawerApp() throws NullPointerException{
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				//actual_location
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) throws NullPointerException{
				currentX=e.getX();
				currentY=e.getY();
				x1=0;y1=0;
				x2=getWidth();
				y2=0;
				x3=0;
				y3=getHeight();
				x4=getWidth();
				y4=getHeight();
				//TOP_RIGHT
				g2.setColor(Color.RED);
				g2.drawLine(x1,y1,currentX,currentY);
				
				//TOP_MIDDLE
				g2.setColor(Color.YELLOW);
				g2.drawLine(x2/2,y1,currentX,currentY);
				
				//TOP_LEFT
				g2.setColor(Color.GREEN);
				g2.drawLine(x2,y2,currentX,currentY);
				
				//MIDDLE_LEFT
				g2.setColor(Color.CYAN);
				g2.drawLine(x2,y3/2,currentX,currentY);
				
				//BOTTOM_LEFT
				g2.setColor(Color.BLUE);
				g2.drawLine(x4,y4,currentX,currentY);

				//BOTTOM_MIDDLE
				g2.setColor(Color.ORANGE);
				g2.drawLine(x4/2,y4,currentX,currentY);
				
				//BOTTOM_RIGHT
				g2.setColor(Color.MAGENTA);
				g2.drawLine(x3,y3,currentX,currentY);
				
				//MIDDLE_RIGHT
				g2.setColor(Color.GRAY);
				g2.drawLine(x1,y4/2,currentX,currentY);
				repaint();
			}
		});
	}
	protected void paintComponent(Graphics g) throws NullPointerException{
		if(image==null){
			image=createImage(getWidth(),getHeight());
			g2=(Graphics2D)image.getGraphics();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
		}
		g.drawImage(image,0,0,null);
	}
	public void clear() throws NullPointerException{
		g2.setPaint(Color.BLACK);
		g2.fillRect(0, 0, 10000, 10000);
		repaint();
	}
}