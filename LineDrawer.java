import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LineDrawer{
	Button clrbtn;
	LineDrawerApp lda;
	ActionListener al=new ActionListener(){
	public void actionPerformed(ActionEvent e) throws NullPointerException{
			if(e.getSource()==clrbtn)
				lda.clear();
		}
	};
	public static void main(String args[])throws NullPointerException{
		new LineDrawer().show();	
	}
	public void show() throws NullPointerException{
		JFrame frame=new JFrame("Line Drawer");
		frame.setSize(900,900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		Container content=frame.getContentPane();
		content.setLayout(new BorderLayout());
		lda=new LineDrawerApp();
		content.add(lda,BorderLayout.CENTER);
		Panel controls=new Panel();
		clrbtn=new Button("Clear");
		clrbtn.addActionListener(al);
		controls.add(clrbtn);
		content.add(controls, BorderLayout.NORTH);
		controls.setBackground(Color.WHITE);
		frame.addComponentListener(new ComponentListener() {
			public void componentShown(ComponentEvent e) {
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
			lda.clear();
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		frame.setVisible(true);
		}
}
