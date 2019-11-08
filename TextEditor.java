import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
public class TextEditor implements ActionListener{
	Frame f;
	int flag2;
	FileDialog fd;
	MenuBar mb;
	JTextArea ta;
	File f3;
	int flag3,flag4;
	int startIndex;
	String path,name;
	Menu m1,m2;
	MenuItem nw,open,save,saveas,close,find,findrep;
	public TextEditor(){
		f=new Frame("Text Editor");
		flag3=0;
		f.setSize(800,600);
		f.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e){
				ta.addMouseListener(new MouseListener(){
					public void mouseReleased(MouseEvent arg0){}
					public void mousePressed(MouseEvent arg0){}
					public void mouseExited(MouseEvent arg0){}
					public void mouseEntered(MouseEvent arg0){}
					public void mouseClicked(MouseEvent arg0){
						startIndex=ta.getCaretPosition();
					}
				});
			}
			public void windowIconified(WindowEvent e){}
			public void windowDeiconified(WindowEvent e){}
			public void windowDeactivated(WindowEvent e){}
			public void windowClosing(WindowEvent e) {
				if(ta.getText().trim().length()!=0  && flag3==0){
					Dialog req=new Dialog(f,"Text Editor",true);
					req.setSize(300,110);
					req.setLayout(new GridLayout(2,0));
					Panel p1=new Panel();
					p1.setBackground(Color.WHITE);
					Label msg=new Label("Do you wish to save changes?");
					p1.add(msg);
					Panel p2=new Panel();
					Button yes=new Button("YES");
					p2.add(yes);
					yes.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(f3==null){
								fd=new FileDialog(f,"Save As",FileDialog.SAVE);
								fd.setVisible(true);
								name=fd.getFile();
								path=fd.getDirectory();
								f3=new File(path,name);
								}
								BufferedWriter bf5;
								try {
									bf5 = new BufferedWriter(new FileWriter(f3));
					            bf5.write(ta.getText());
					            bf5.flush();
					            bf5.close();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								req.setVisible(false);
						}
					});
					Button no=new Button("NO");
					no.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							req.setVisible(false);
							req.dispose();
						}
					});
					
					p2.add(no);
					req.add(p1);
					req.add(p2);
					req.setVisible(true);
				}
				f.setVisible(false);
				f.dispose();
				System.exit(0);
				
			}
			public void windowClosed(WindowEvent e){}
			public void windowActivated(WindowEvent e){}
		});
		mb=new MenuBar();
		m1=new Menu("File");
		m2=new Menu("Edit");
		flag4=0;
		mb.add(m1);
		mb.add(m2);
		nw=new MenuItem("New");
		nw.addActionListener(this);
		open=new MenuItem("Open");
		open.addActionListener(this);
		save=new MenuItem("Save");
		save.addActionListener(this);
		saveas=new MenuItem("Save As");
		saveas.addActionListener(this);
		close=new MenuItem("Close");
		close.addActionListener(this);
		find=new MenuItem("Find");
		find.addActionListener(this);
		findrep=new MenuItem("Find & Replace");
		findrep.addActionListener(this);
		m1.add(nw);
		m1.add(open);
		m1.add(save);
		m1.add(saveas);
		m1.addSeparator();
		m1.add(close);
		m2.add(find);
		m2.add(findrep);
		f.setMenuBar(mb);
		ta=new JTextArea();
		Font fnt=new Font("Corsiva",Font.BOLD,20);
		ta.setFont(fnt);
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		f.add(ta);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		try{
		switch(e.getActionCommand()){
		case "New":
			 if(ta.getText().trim().length()!=0  && flag3==0){
				Dialog req=new Dialog(f,"Text Editor",true);
				req.setSize(300,110);
				req.setLayout(new GridLayout(2,0));
				Panel p1=new Panel();
				p1.setBackground(Color.WHITE);
				Label msg=new Label("Do you wish to save changes?");
				p1.add(msg);
				Panel p2=new Panel();
				Button yes=new Button("YES");
				p2.add(yes);
				yes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(f3==null){
							fd=new FileDialog(f,"Save As",FileDialog.SAVE);
							fd.setVisible(true);
							name=fd.getFile();
							path=fd.getDirectory();
							f3=new File(path,name);
							}
							BufferedWriter bf5;
							try {
								bf5 = new BufferedWriter(new FileWriter(f3));
				            bf5.write(ta.getText());
				            bf5.flush();
				            bf5.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							req.setVisible(false);
					}
				});
				Button no=new Button("NO");
				no.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						req.setVisible(false);
						req.dispose();
					}
				});
				
				p2.add(no);
				req.add(p1);
				req.add(p2);
				req.setVisible(true);
			}
			ta.setText("");
			f3=null;
			break;
		case "Open":
			if(ta.getText().trim().length()!=0  && flag3==0){
				final Dialog req=new Dialog(f,"Text Editor",true);
				req.setSize(300,110);
				req.setLayout(new GridLayout(2,0));
				Panel p1=new Panel();
				p1.setBackground(Color.WHITE);
				Label msg=new Label("Do you wish to save changes?");
				p1.add(msg);
				Panel p2=new Panel();
				Button yes=new Button("YES");
				p2.add(yes);
				yes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(f3==null){
							fd=new FileDialog(f,"Save As",FileDialog.SAVE);
							fd.setVisible(true);
							name=fd.getFile();
							path=fd.getDirectory();
							f3=new File(path,name);
							}
							BufferedWriter bf5;
							try {
								bf5 = new BufferedWriter(new FileWriter(f3));
				            bf5.write(ta.getText());
				            bf5.flush();
				            bf5.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							req.setVisible(false);
					}
				});
				Button no=new Button("NO");
				no.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						req.setVisible(false);
						req.dispose();
					}
				});
				p2.add(no);
				req.add(p1);
				req.add(p2);
				req.setVisible(true);
			}
			fd=new FileDialog(f,"Open File ",FileDialog.LOAD);
			fd.setVisible(true);
			name=fd.getFile();
			path=fd.getDirectory();
			f3=new File(path,name);
			StreamTokenizer st=new StreamTokenizer(new FileInputStream(f3));
			ta.setText("");
			   while(st.nextToken() !=StreamTokenizer.TT_EOF){
				String s;
				switch(st.ttype){
				case StreamTokenizer.TT_EOL:
					s="EOL";
			    		ta.append(s);
					break;
				case StreamTokenizer.TT_WORD:
			    		s=st.sval+" ";
			    		ta.append(s);
					break;
				case StreamTokenizer.TT_NUMBER:
					s=st.nval+" ";
					ta.append(s);
					break;
				default:
					s =((char)st.ttype)+" ";
					ta.append(s);
				}
			   }
			ta.setCaretPosition(ta.getText().length());
			flag3++;
			break;
			case "Save":
			if(f3==null){
			fd=new FileDialog(f,"Save As",FileDialog.SAVE);
			fd.setVisible(true);
			name=fd.getFile();
			path=fd.getDirectory();
			f3=new File(path,name);
			}
			BufferedWriter bf3 = new BufferedWriter(new FileWriter(f3));
            bf3.write(ta.getText());
            bf3.flush();
            bf3.close();
            flag3++;
			break;
		case "Save As":
			fd=new FileDialog(f,"Save As",FileDialog.SAVE);
			fd.setVisible(true);
			name=fd.getFile();
			path=fd.getDirectory();
			f3=new File(path,name);
			BufferedWriter bf2 = new BufferedWriter(new FileWriter(f3));
            bf2.write(ta.getText());
            bf2.flush();
            bf2.close();
			break;
		case "Close":
			if(ta.getText().trim().length()!=0 && flag3==0){
				final Dialog req=new Dialog(f,"Text Editor",true);
				req.setSize(300,110);
				req.setLayout(new GridLayout(2,0));
				Panel p1=new Panel();
				p1.setBackground(Color.WHITE);
				Label msg=new Label("Do you wish to save changes?");
				p1.add(msg);
				Panel p2=new Panel();
				Button yes=new Button("YES");
				p2.add(yes);
				yes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(f3==null){
							fd=new FileDialog(f,"Save As",FileDialog.SAVE);
							fd.setVisible(true);
							name=fd.getFile();
							path=fd.getDirectory();
							f3=new File(path,name);
							}
							BufferedWriter bf5;
							try {
							bf5 = new BufferedWriter(new FileWriter(f3));
				            bf5.write(ta.getText());
				            bf5.flush();
				            bf5.close();
							}catch (IOException e1) {
								e1.printStackTrace();
							}
							req.setVisible(false);
					}
				});
				Button no=new Button("NO");
				no.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						req.setVisible(false);
						req.dispose();
					}
				});
				
				p2.add(no);
				req.add(p1);
				req.add(p2);
				req.setVisible(true);
			}
			f.setVisible(false);
			f.dispose();
			System.exit(1);
			break;
		case "Find":
			final Dialog d=new Dialog(f,"Find Next",false);
			d.setSize(450,95);
			d.setResizable(false);
			d.setLayout(new GridLayout(0, 2));
			d.addWindowListener(new WindowListener()
			{
					public void windowActivated(WindowEvent e){}
					public void	windowClosed(WindowEvent e){}
					public void	windowClosing(WindowEvent e){
						flag4=0;
						d.setVisible(false);
						d.dispose();
					}
					public void	windowDeactivated(WindowEvent e){}
					public void	windowDeiconified(WindowEvent e){}
					public void	windowIconified(WindowEvent e){}
					public void	windowOpened(WindowEvent e){}


			});
			Panel p=new Panel();
			p.setLayout(new FlowLayout(FlowLayout.CENTER));
			Label l1=new Label("Find");
			p.add(l1);
			TextField tf=new TextField(20);
			p.add(tf);
			d.add(p);
			Panel p2=new Panel();
			p2.setLayout(new GridLayout(2, 0));
			Button b1=new Button("Find Next");
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int flag=0;
					Pattern p=Pattern.compile(tf.getText());
					Matcher m=p.matcher(ta.getText());
					while(m.find(startIndex)){
						ta.select(m.start(),m.end());
						f.toFront();
						flag++;
						startIndex=m.end();
						break;
					}
				if(flag==0)
					JOptionPane.showMessageDialog(null, "Could not find \"" + tf.getText() + "\"!");
				}
			});
			Button b2=new Button("Cancel");
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					d.setVisible(false);
					flag4=0;
					d.dispose();
				}
			});
			p2.add(b1);
			p2.add(b2);
			d.add(p2);
			if(flag4==0)
			d.setVisible(true);
			flag4++;
			break;
		case "Find & Replace":
			final Dialog d2=new Dialog(f,"Find & Replace",false);
			d2.setSize(550,95);
			d2.setResizable(false);
			d2.setLayout(new GridLayout(0, 2));
			d2.addWindowListener(new WindowListener()
			{
					public void windowActivated(WindowEvent e){}
					public void	windowClosed(WindowEvent e){}
					public void	windowClosing(WindowEvent e){
						flag4=0;
						d2.setVisible(false);
						d2.dispose();
					}
					public void	windowDeactivated(WindowEvent e){}
					public void	windowDeiconified(WindowEvent e){}
					public void	windowIconified(WindowEvent e){}
					public void	windowOpened(WindowEvent e){}


			});
			Panel p3=new Panel();
			p3.setLayout(new GridLayout(2,2));
			Label l2=new Label("Find What");
			p3.add(l2);
			TextField tf2=new TextField(20);
			p3.add(tf2);
			Label l3=new Label("Replace with");
			p3.add(l3);
			TextField tf4=new TextField(20);
			p3.add(tf4);
			d2.add(p3);
			Panel p4=new Panel();
			p4.setLayout(new GridLayout(2,2));
			Button b3=new Button("Find Next");
			b3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int flag=0;
					Pattern p=Pattern.compile(tf2.getText());
					Matcher m=p.matcher(ta.getText());
					while(m.find(startIndex)){
						ta.select(m.start(),m.end());
						f.toFront();
						flag++;
						startIndex=m.end();
						break;
					}
				if(flag==0)
					JOptionPane.showMessageDialog(null, "Could not find \"" + tf2.getText() + "\"!");
				}
			});
			Button b4=new Button("Replace");
			b4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int flag=0;
					Pattern p=Pattern.compile(tf2.getText());
					Matcher m=p.matcher(ta.getText());
					while(m.find(startIndex)){
						ta.replaceRange(tf4.getText(),m.start(), m.end());
						ta.select(m.start(),tf2.getText().length());
						f.toFront();
						ta.setCaretPosition(ta.getCaretPosition()+tf4.getText().length());
						flag++;
						startIndex=ta.getCaretPosition();
						break;
					}
				if(flag==0)
					JOptionPane.showMessageDialog(null, "Could not find \"" + tf2.getText() + "\"!");
				}
			});
			Button b5=new Button("Replace All");
			b5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int flag=0;
					Pattern p=Pattern.compile(tf2.getText());
					Matcher m=p.matcher(ta.getText());
					while(m.find(startIndex)){
						ta.setText(ta.getText().replaceAll(tf2.getText(), tf4.getText()));
						ta.select(m.start(),tf4.getText().length());
						ta.setCaretPosition(0);
						f.toFront();
						flag++;
						startIndex=ta.getCaretPosition();
						break;
					}
				if(flag==0)
					JOptionPane.showMessageDialog(null, "Could not find \"" + tf2.getText() + "\"!");
				}
			});
			Button b6=new Button("Cancel");
			b6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					flag4=0;
					d2.setVisible(false);
					d2.dispose();
				}
			});
			p4.add(b3);
			p4.add(b4);
			p4.add(b5);
			p4.add(b6);
			d2.add(p4);
			if(flag4==0)
			d2.setVisible(true);
			flag4++;
			break;
		}
		}catch(Exception e2){
			e2.getMessage();
		}
		ta.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				flag3=0;
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}
	public static void main(String args[]){
		TextEditor te=new TextEditor();
	}
}