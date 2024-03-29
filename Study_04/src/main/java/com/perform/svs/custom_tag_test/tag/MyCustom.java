package com.perform.svs.custom_tag_test.tag;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyCustom extends SimpleTagSupport{
	private String format;
	private String number;
	
	public MyCustom(){
		
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public void doTag() throws JspException, IOException {
		
		System.out.println("Number is:" + number);
		System.out.println("Format is:" + format);
		
		try{
			double amount = Double.parseDouble(number);
			DecimalFormat formatter = new DecimalFormat(format);

			String formattedNumber = formatter.format(amount);
			getJspContext().getOut().write(formattedNumber);
			
		}catch(Exception e){
			e.printStackTrace();
			throw new SkipPageException("Exception in formatting " + number + " with foramt " + format);
		}
	}
	
}
