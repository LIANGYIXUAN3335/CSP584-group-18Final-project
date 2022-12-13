package com.iit.servlet.model;

import com.google.gson.Gson;
import com.iit.bean.DailySale;
import com.iit.bean.Sales;
import com.iit.bean.User;
import com.iit.servlet.base.ModelBaseServlet;
import com.iit.utils.MySqlDataStoreUtilities;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SalesServlet extends ModelBaseServlet {

	protected void showSalesReport(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MySqlDataStoreUtilities msdsu = new MySqlDataStoreUtilities();
		HashMap<String, ArrayList<Sales>> allSales = msdsu.getAllSale();
		ArrayList<Sales> sales = allSales.get("All Sale");
		HashMap<String, ArrayList<DailySale>> dailySales = msdsu.getDailySale();
		ArrayList<DailySale> dailySale = dailySales.get("Daily Sale");

		request.setAttribute("allSales",sales);
		request.setAttribute("dailySales",dailySale);
		processTemplate("order/sales_report",request,response);
	}

	private String getDailySale(HashMap<String, ArrayList<DailySale>> sales) {
		String _Content = "";
		_Content += "" + "<center><h2>Daily Sales</h2></center>";
		for (Map.Entry<String, ArrayList<DailySale>> data : sales.entrySet()) {
			String frame = data.getKey();
			ArrayList<DailySale> inv = data.getValue();
			if (frame.equalsIgnoreCase("ERROR")) {
				_Content += "<center>No Data Available.</center>";
			} else {
				_Content += ""
						+ "<table id='example2' class='hover' cellspacing='0' width='100%'>"
						+ "<thead>"
						+ "<tr>"
						+ "<th>"
						+ "Date"
						+ "</th>"
						+ "<th>"
						+ "No. Item Sold"
						+ "</th>"
						+ "<th>"
						+ "Total Sale"
						+ "</th>"
						+ "</tr>"
						+ "</thead>"
						+ "";
				
/*				_Content += ""
						+ "<tfoot>"
						+ "<tr>"
						+ "<th>"
						+ "Date"
						+ "</th>"
						+ "<th>"
						+ "No. Item Sold"
						+ "</th>"
						+ "<th>"
						+ "Total Sale"
						+ "</th>"
						+ "</tr>"
						+ "</tfoot>"
						+ "";
				*/
				_Content +="<tbody>";
				DecimalFormat df = new DecimalFormat(".###");
				for(DailySale i: inv) {
					_Content += ""
							+ "<tr>"
							+ "<td>"
							+ i.getDate()
							+ "</td>"
							+ "<td>"
							+ i.getQuantity()
							+ "</td>"
							+ "<td>$"
							+ df.format(i.getPrice())
							+ "</td>"
							+ "</tr>";
				}
				_Content +="</tbody>"
						+ "</table>";

			}
		}

		return _Content;
	}

	private String getSaleReport(HashMap<String, ArrayList<Sales>> sales) {
		String _Heading = "" + "<div id='body'>" + "<section id='content'>" + "";
		String _Content = "";
		_Content += "" + "<center><h2>Sales</h2></center>";
		for (Map.Entry<String, ArrayList<Sales>> data : sales.entrySet()) {
			String frame = data.getKey();
			ArrayList<Sales> inv = data.getValue();
			if (frame.equalsIgnoreCase("ERROR")) {
				_Content += "<center>No Data Available.</center>";
			} else {
				_Content += ""
						+ "<table id='example' class='hover' cellspacing='0' width='100%'>"
						+ "<thead>"
						+ "<tr>"
						+ "<th>"
						+ "ID"
						+ "</th>"
						+ "<th>"
						+ "Model"
						+ "</th>"
						+ "<th>"
						+ "Price"
						+ "</th>"
						+ "<th>"
						+ "QTY"
						+ "</th>"
						+ "<th>"
						+ "Total Sale"
						+ "</th>"
						+ "</tr>"
						+ "</thead>"
						+ "";
				
/*				_Content += ""
						+ "<tfoot>"
						+ "<tr>"
						+ "<th>"
						+ "ID"
						+ "</th>"
						+ "<th>"
						+ "Model"
						+ "</th>"
						+ "<th>"
						+ "QTY"
						+ "</th>"
						+ "<th>"
						+ "Total Sale"
						+ "</th>"
						+ "</tr>"
						+ "</tfoot>"
						+ "";*/
				
				_Content +="<tbody>";
				DecimalFormat df = new DecimalFormat(".###");
				for(Sales i: inv) {
					_Content += ""
							+ "<tr>"
							+ "<td>"
							+ i.getId()
							+ "</td>"
							+ "<td>"
							+ i.getModel()
							+ "</td>"
							+ "<td>$"
							+ df.format(i.getPrice())
							+ "</td>"
							+ "<td>"
							+ i.getQuantity()
							+ "</td>"
							+ "<td>$"
							+ df.format(i.getTotalSale())
							+ "</td>"
							+ "</tr>";
				}
				_Content +="</tbody>"
						+ "</table>";

			}
		}

		return _Heading + _Content;
	}

	private void getSalesChart(HttpServletRequest request, HttpServletResponse response) {
		MySqlDataStoreUtilities msdsu = new MySqlDataStoreUtilities();

		HashMap<String, ArrayList<Sales>> allSales = msdsu.getAllSale();

		Gson gson = new Gson();
		String type = request.getParameter("type");
		response.setContentType("application/json");

		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Map.Entry<String, ArrayList<Sales>> data : allSales.entrySet()) {
			if (!data.getKey().equalsIgnoreCase("ERROR")) {
				out.print(gson.toJson(data.getValue()));
			}
		}
	}
}
