package student.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Marks implements Serializable
{
    
    private int coreJava;
    private int advJava;
    private int html;
    private int db;
   
    private int c;
    private int javascript;
    
    public Marks()
    {
    	
    }

	

	

	public int getCoreJava() {
		return coreJava;
	}

	public void setCoreJava(int coreJava) {
		this.coreJava = coreJava;
	}

	public int getAdvJava() {
		return advJava;
	}

	public void setAdvJava(int advJava) {
		this.advJava = advJava;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}

	public int getJavascript() {
		return javascript;
	}

	public void setJavascript(int javascript) {
		this.javascript = javascript;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
    
    
}
