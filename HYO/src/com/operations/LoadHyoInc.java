package com.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hyo.AppConfiguration;
import com.hyo.HYOInc;
import com.pojo.ItemType;
import com.pojo.Items;
import com.pojo.Location;
import com.pojo.Manufacturer;
import com.pojo.Supplier;

@WebServlet(description = "My First Servlet", urlPatterns = {"/HyoInc"})
public class LoadHyoInc extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		
		HashMap<String,Object> allDetails= HYOInc.getAllDetailsMap();
		Gson gsonObj = new Gson();
		String json = gsonObj.toJson(allDetails);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(json);
	}
}
