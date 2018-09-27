package com.rajan.java.xml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class JavaDomParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i=0;
		FileReader fr=null;
		StringBuilder sb=new StringBuilder();
		try {
			fr=new FileReader("C:\\Users\\Rajan\\Desktop\\SampleXML.txt");
			//FileInputStream fr=new FileInputStream("C:\\Users\\Rajan\\Desktop\\SampleXML.txt");
			BufferedReader br=new BufferedReader(fr);
			String line;
			while((line=br.readLine()) != null)
				{
				sb.append(line);
				};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sb);
		
		try {
			DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = docFactory.newDocumentBuilder();
			Document doc=dBuilder.parse(new InputSource(new StringReader(sb.toString())));
			
			Node rootElement=doc.getFirstChild();
			System.out.println(rootElement.getNodeName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
