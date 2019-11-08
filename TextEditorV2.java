import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.JTextArea;
public class TextEditorV2 implements ActionListener{
	Frame f;
	MenuBar mb;
	Menu m1,m2;
	MenuItem nw,open,save,saveas,close,find,findrep;
	TextArea ta;
	public TextEditorV2() {
		mb=new MenuBar();
		m1=new Menu("File");
		m2=new Menu("Edit");
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
		ta=new TextArea();
		f.add(ta);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
