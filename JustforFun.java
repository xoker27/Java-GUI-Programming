import java.awt.*;
public class JustforFun {
	public static void main(String args[]){
		Frame f=new Frame();
		f.setSize(500,400);
		GridLayout gl1=new GridLayout(2,2);
		f.setLayout(gl1);
		Panel p1=new Panel();
		GridLayout gl2=new GridLayout(2,0);
		p1.setLayout(gl2);
		Button b1=new Button("1");
		Button b2=new Button("2");
		p1.add(b1);
		p1.add(b2);
		f.add(p1);
		Panel p2=new Panel();
		GridLayout gl3=new GridLayout(0,3);
		p2.setLayout(gl3);
		Button b3=new Button("3");
		Button b4=new Button("4");
		Button b5=new Button("5");
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		f.add(p2);
		Panel p3=new Panel();
		GridLayout gl4=new GridLayout(0,2);
		p3.setLayout(gl4);
		Panel p4=new Panel();
		GridLayout gl5=new GridLayout(2,0);
		p4.setLayout(gl5);
		Button b6=new Button("6");
		Button b7=new Button("7");
		p4.add(b6);
		p4.add(b7);
		p3.add(p4);
		Panel p5=new Panel();
		GridLayout gl6=new GridLayout(3,0);
		p5.setLayout(gl6);
		Button b8=new Button("8");
		Button b9=new Button("9");
		Button b10=new Button("10");
		p5.add(b8);
		p5.add(b9);
		p5.add(b10);
		p3.add(p5);
		f.add(p3);
		Panel p6=new Panel();
		GridLayout gl7=new GridLayout(2,0);
		p6.setLayout(gl7);
		Panel p7=new Panel();
		p7.setLayout(gl4);
		Button b11=new Button("11");
		Button b12=new Button("12");
		p7.add(b11);
		p7.add(b12);
		p6.add(p7);
		Panel p8=new Panel();
		p8.setLayout(gl3);
		Button b13=new Button("13");
		Button b14=new Button("14");
		Button b15=new Button("15");
		p8.add(b13);
		p8.add(b14);
		p8.add(b15);
		p6.add(p8);
		f.add(p6);
		f.setVisible(true);
	}
}
