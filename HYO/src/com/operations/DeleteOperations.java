package com.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hyo.HYOInc;
import com.pojo.Items;

public class DeleteOperations extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
			 String operation = request.getParameter("operation");
		    Items item = (Items)request.getAttribute("operation");
		    String a = request.getParameter("x");
		    Items b = (Items)request.getAttribute("x");
		    if(operation.equals("item")) {
		    	DAOOperations.deleteItem(item);
		    }
		    HashMap<String,Object> allDetails= HYOInc.getAllDetailsMap();
			Gson gsonObj = new Gson();
			String json = gsonObj.toJson(allDetails);
	        response.setContentType("application/json");
	        PrintWriter out = response.getWriter();
	        out.println(json);
			}

	  public void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
		  
        String operation2 =  request.getParameter("data");
	    String operation = (String)request.getParameter("operation");
	    String operation1 = (String)request.getAttribute("operation");
	    Items item = (Items)request.getAttribute("operation");
	    String a = request.getParameter("x");
	    Items b = (Items)request.getAttribute("x");
	    if(operation.equals("item")) {
	    	DAOOperations.deleteItem(item);
	    }
	    HashMap<String,Object> allDetails= HYOInc.getAllDetailsMap();
		Gson gsonObj = new Gson();
		String json = gsonObj.toJson(allDetails);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(json);
	  }
}
