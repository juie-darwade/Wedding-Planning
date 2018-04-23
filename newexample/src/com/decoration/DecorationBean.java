package com.decoration;
import java.sql.*;
public class DecorationBean {
	int price;
	String title;
	String type1,type2,img;
	int Trad_id;
	
	  public String getTitle() {
	        return title;
	    }
	  public int getTrad_id() {
	        return Trad_id;
	    }
	  public int getPrice() {
	        return price;
	    }

	  public String getType1() {
	        return type1;
	    }
	  public String getType2() {
	        return type2;
	    }
	  public String getImg() {
	        return img;
	    }
	  
	  public void setTitle() {
	        this.title=title;
	    }
	  public void setTrad_id() {
	        this.Trad_id=Trad_id;
	    }
	  public void setPrice() {
	        this.price=price;
	    }

	  public void setType1() {
	        this.type1=type1;
	    }
	  public void setType2() {
	        this.type2=type2;
	    }
	  public void setImg() {
	        this.img=img;
	    }
	  
	  
}
