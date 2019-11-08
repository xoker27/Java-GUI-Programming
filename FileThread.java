import java.util.*;
import java.io.*;
class FileThread extends Thread
{	private String p;
	Vector<Integer> v=new Vector<Integer>();	
	private int sum;
	public FileThread(String fname,Vector<Integer> v)
	{ p=fname; 
		this.v=v;
		}
	
	public void run(){
		try{
			//File f=new File(p);
			
			FileInputStream fis=new FileInputStream(p);
			StreamTokenizer st=new StreamTokenizer(fis);
			while(st.nextToken()!=StreamTokenizer.TT_EOF)
			{
				switch(st.ttype)
				{
					case StreamTokenizer.TT_NUMBER:
					sum+=st.nval;
					break;
				}
			}
			v.add(sum);
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
	}
/*	public int getSum()
	{
		return sum;
	}*/
	       	
}
