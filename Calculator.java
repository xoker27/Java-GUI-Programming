//imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Calculator implements ActionListener {
	//stack for pushing operators
	Stack<Character> op  = new Stack<Character>();
	//stack for pushing oprands
    Stack<Integer> val = new Stack<Integer>();
	//variables for performing arthemtics
	int num1,num2,result;
	//flags for checking button presses
	int flag1=0;
	int flag2=0;
	//chars for storing symbol match
	char oper,temp;
	//Container and Components
	Frame f;
	Panel P,p1,p2,p3,p4;
	TextField tf1;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	//default constructor
	public Calculator(){
		//setting up attributes of Frame
		f=new Frame();
		//This is class used for adding functionality of frame closer, ***use your class here***
		FrameCloser fc=new FrameCloser();
		f.addWindowListener(fc);
		f.setSize(300,300);
		//Setting up layout and components
		BorderLayout bl1=new BorderLayout();
		f.setLayout(bl1);
		P=new Panel();
		GridLayout gl1=new GridLayout(4,0);
		P.setLayout(gl1);
		p1=new Panel();
		p2=new Panel();
		p3=new Panel();
		p4=new Panel();
		GridLayout gl2=new GridLayout(0,4);
		p1.setLayout(gl2);
		p2.setLayout(gl2);
		p3.setLayout(gl2);
		p4.setLayout(gl2);
		tf1=new TextField();
		f.add(tf1,"North");
		b1=new Button("1");
		b1.addActionListener(this);
		b2=new Button("2");
		b2.addActionListener(this);
		b3=new Button("3");
		b3.addActionListener(this);
		b4=new Button("+");
		b4.addActionListener(this);
		b5=new Button("4");
		b5.addActionListener(this);
		b6=new Button("5");
		b6.addActionListener(this);
		b7=new Button("6");
		b7.addActionListener(this);
		b8=new Button("-");
		b8.addActionListener(this);
		b9=new Button("7");
		b9.addActionListener(this);
		b10=new Button("8");
		b10.addActionListener(this);
		b11=new Button("9");
		b11.addActionListener(this);
		b12=new Button("*");
		b12.addActionListener(this);
		b13=new Button("C");
		b13.addActionListener(this);
		b14=new Button("0");
		b14.addActionListener(this);
		b15=new Button("/");
		b15.addActionListener(this);
		b16=new Button("=");
		b16.addActionListener(this);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);
		p3.add(b9);
		p3.add(b10);
		p3.add(b11);
		p3.add(b12);
		p4.add(b13);
		p4.add(b14);
		p4.add(b15);
		p4.add(b16);
		P.add(p1);
		P.add(p2);
		P.add(p3);
		P.add(p4);
		f.add(P);
		f.setTitle("Calculator");
		tf1.setEditable(false);
		Font ft=new Font("Consolas",Font.BOLD,20);
		tf1.setFont(ft);
		f.setVisible(true);
	}
	//event handeling for each button press
	@Override
	public void actionPerformed(ActionEvent e){
		try{
		//to get label of button
		String str=e.getActionCommand();
		switch(str){
		//on clear button press	
		case "C":
			tf1.setText("");
			while(!op.isEmpty())
				op.pop();
			while(!val.isEmpty())
				val.pop();
		break;
		//on add button press
		case "+":
		//if multiple clicks are there
			if(flag2!=0){
				op.pop();
			}
			num1=Integer.parseInt(tf1.getText());
			val.push(num1);
			//to check if operators exists
			if(!op.isEmpty()){
			temp=op.peek();
			//to check if higher precendence operators exists
			if(temp=='*'|| temp=='/'){
				oper=op.pop();
				num2=val.pop();
				num1=val.pop();
			if(oper=='*'){
				result=num1*num2;
				val.push(result);
			}
			if(oper=='/'){
				result=num1/num2;
				val.push(result);
			}
			}
			}
			//pushing of symbol
			op.push('+');
			//flag1 is for checking append mode or not
			flag1++;
			//flag2 is for checking multiple clicks on operators buttons
			flag2++;
			break;
		//on minus button press	
		case "-":
		//if multiple clicks are there
			if(flag2!=0){
				op.pop();
			}
			num1=Integer.parseInt(tf1.getText());
			val.push(num1);
			//to check if operators exists
			if(!op.isEmpty()){
			temp=op.peek();
			//to check if higher precendence operators exists
			if(temp=='*'|| temp=='/'){
				oper=op.pop();
				num2=val.pop();
				num1=val.pop();
			if(oper=='*'){
				result=num1*num2;
				val.push(result);
			}
			if(oper=='/'){
				result=num1/num2;
				val.push(result);
			}
			}
			}
			//pushing of symbol
			op.push('-');
			//flag1 is for checking append mode or not
			flag1++;
			//flag2 is for checking multiple clicks on operators buttons
			flag2++;
			break;
		//on multiply button press
		case "*":
		//if multiple clicks are there
			if(flag2!=0){
				op.pop();
			}
			num1=Integer.parseInt(tf1.getText());
			val.push(num1);
			//to check if operators exists
			if(!op.isEmpty()){
			temp=op.peek();
			//to check if higher precendence operators exists
			if(temp=='*'|| temp=='/'){
				oper=op.pop();
				num2=val.pop();
				num1=val.pop();
			if(oper=='*'){
				result=num1*num2;
				val.push(result);
			}
			if(oper=='/'){
				result=num1/num2;
				val.push(result);
			}
			}
			}
			//pushing of symbol
			op.push('*');
			//flag1 is for checking append mode or not
			flag1++;
			//flag2 is for checking multiple clicks on operators buttons
			flag2++;
			break;
		//on divide button press
		case "/":
		//if multiple clicks are there
			if(flag2!=0){
				op.pop();
			}
			num1=Integer.parseInt(tf1.getText());
			val.push(num1);
			//to check if operators exists
			if(!op.isEmpty()){
			temp=op.peek();
			//to check if higher precendence operators exists
			if(temp=='*'|| temp=='/'){
				oper=op.pop();
				num2=val.pop();
				num1=val.pop();
			if(oper=='*'){
				result=num1*num2;
				val.push(result);
			}
			if(oper=='/'){
				result=num1/num2;
				val.push(result);
			}
			}
			}
			//pushing of symbol
			op.push('/');
			//flag1 is for checking append mode or not
			flag1++;
			//flag2 is for checking multiple clicks on operators buttons
			flag2++;
			break;
		//on equals button click
		case "=":
			num2=Integer.parseInt(tf1.getText());
			val.push(num2);
			//to check if operators exists
			while(!op.isEmpty()){
				//pop top operator and two operands.
				oper=op.pop();
				num2=val.pop();
				num1=val.pop();
			//selection and evalutaion on basis of symbol
			if(oper=='+'){
				result=num1+num2;
				val.push(result);
			}
			if(oper=='-'){
				result=num1-num2;
				val.push(result);
			}
			if(oper=='*'){
				result=num1*num2;
				val.push(result);
			}
			if(oper=='/'){
				result=num1/num2;
				val.push(result);
			}
			}
			//display result
			tf1.setText(val.pop()+"");
			flag1++;
			break;
		//on digits button press
		default:
		//append when no opeartor is clicked
			if(flag1==0)
			tf1.setText(tf1.getText()+e.getActionCommand());
		//append when opeartor is clicked
			else {
				tf1.setText("");
			tf1.setText(tf1.getText()+e.getActionCommand());
			//reset flag1
			flag1=0;
			}
			//reset flag2
			flag2=0;
		}
		}catch(Exception ex){
			ex.getMessage();
		}
	}
	public static void main(String args[]){
		//Object of Calculator creation
		Calculator cl=new Calculator();
	}
}
	
