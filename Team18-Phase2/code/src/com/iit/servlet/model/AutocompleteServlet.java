package com.iit.servlet.model;

import com.iit.servlet.base.ModelBaseServlet;
import com.iit.utils.AjaxUtility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutocompleteServlet extends ModelBaseServlet {

   public void autoSearch(HttpServletRequest request,HttpServletResponse response) {
       String action = request.getParameter("action");
       String searchId = request.getParameter("searchId");
       
       try {
           StringBuffer sb = new StringBuffer();
           boolean namesAdded = false;
           if (action.equals("complete")) {
               if (!searchId.equals("")) {
                   AjaxUtility a = new AjaxUtility();
                   sb = a.readdata(searchId);
                   if (sb != null || !sb.equals("")) {
                       namesAdded = true;
                   }
                   if (namesAdded) {
                       response.setContentType("text/xml");
                       response.getWriter().write("<products>" + sb.toString() + "</products >");
                   }
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
