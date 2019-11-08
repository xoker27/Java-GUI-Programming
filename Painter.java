import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Painter {
	Button clrbtn;
	MyPainterApp mpa;
	ActionListener al=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==clrbtn){
				mpa.clear();
			}
			
		}
	};
	public static void main(String args[]){
		new Painter().show();
		
	}
	public void show(){
		JFrame frame=new JFrame("Painter");
		Container content=frame.getContentPane();
		content.setLayout(new BorderLayout());
		mpa=new MyPainterApp();
		content.add(mpa,BorderLayout.CENTER);
		Panel controls=new Panel();
		clrbtn=new Button("Clear");
		clrbtn.addActionListener(al);
		controls.add(clrbtn);
		content.add(controls, BorderLayout.NORTH);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		}
}
