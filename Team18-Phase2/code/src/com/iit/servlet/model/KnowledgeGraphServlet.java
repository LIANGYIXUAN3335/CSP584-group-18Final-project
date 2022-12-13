package com.iit.servlet.model;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.maps.errors.ApiException;
import com.iit.servlet.base.ModelBaseServlet;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class KnowledgeGraphServlet extends ModelBaseServlet {
    public void showData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        if(type.equals("knowledge_graph")) {
            processTemplate("product/knowledge_graph", request, response);
        }
    }



    public void getKGData (HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException, ApiException {
        String product = request.getParameter("product");

//        Properties properties = new Properties();
//        File file = new File("/Users/mingxi/CSP584-FinalProject/Team18-Phase2/code/resources","kgsearch.properties");
//        properties.load(new FileInputStream(file));

        HttpTransport httpTransport = new NetHttpTransport();
        HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
        JsonParser parser = new JsonParser();

        GenericUrl url = new GenericUrl("https://kgsearch.googleapis.com/v1/entities:search");
        url.put("query", product);
        url.put("limit", "5");
        url.put("key","AIzaSyBvJ0-vbqwdWJdOYGGQOhkxfdF9JkRSLwo");
        url.put("types","Person");
//        url.put("types","Event");
//        url.put("types","Corporation");
//        url.put("types","WebSite");
        HttpRequest req = requestFactory.buildGetRequest(url);
        HttpResponse httpResponse = req.execute();

        JsonObject res = (JsonObject) parser.parse(httpResponse.parseAsString());
        JsonArray elements = res.getAsJsonArray("itemListElement");

        elements.get(0).getAsJsonObject().get("result").getAsJsonObject().get("detailedDescription").getAsJsonObject().get("url").getAsString();
        request.setAttribute("productid",product);
        request.setAttribute("list", elements);
        processTemplate("product/knowledge_graph",request,response);
//        elements.getAsJsonObject().get("result").get;
//         results.get("name").getAsString()
//        results.getAsJsonObject("image").get("contentUrl").getAsString();
//        String link = results.getAsJsonObject("detailedDescription").get("url").getAsString();
//        String descrip = results.get("description").getAsString();

    }

    }
