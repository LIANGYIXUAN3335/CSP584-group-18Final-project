package com.iit.servlet.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.iit.bean.User;
import com.iit.constant.StoreConstants;
import com.iit.servlet.base.ModelBaseServlet;
import serpapi.GoogleSearch;
import serpapi.SerpApiSearchException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RecommendServlet extends ModelBaseServlet {
    public void showRecommend(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute(StoreConstants.USERSESSIONKEY);
        if (user != null) {
            String preference = user.getPreference();
            JsonArray event = null;
            if (preference.equals("loan")) {
                Map<String, String> parameter = new HashMap<>();

                parameter.put("api_key", "c5eab911d174f59199f88886a36ef4dda4ed473f06b1231180857490f3bbdf10");
                parameter.put("device", "desktop");
                parameter.put("engine", "google_events");
                parameter.put("q", "loan events");
//                parameter.put("htichips", "date:next month");

                GoogleSearch search = new GoogleSearch(parameter);

                try {
                    JsonObject results = search.getJson();
                    event = results.getAsJsonArray("events_results");

                } catch (SerpApiSearchException e) {

                }

            } else if (preference.equals("insurance")) {
                Map<String, String> parameter = new HashMap<>();

                parameter.put("api_key", "c5eab911d174f59199f88886a36ef4dda4ed473f06b1231180857490f3bbdf10");
                parameter.put("device", "desktop");
                parameter.put("engine", "google_events");
                parameter.put("q", "insurance events");
//                parameter.put("htichips", "date:next month");

                GoogleSearch search = new GoogleSearch(parameter);

                try {
                    JsonObject results = search.getJson();
                    event = results.getAsJsonArray("events_results");

                } catch (SerpApiSearchException e) {

                }
            }else if (preference.equals("investment")){
                Map<String, String> parameter = new HashMap<>();

                parameter.put("api_key", "c5eab911d174f59199f88886a36ef4dda4ed473f06b1231180857490f3bbdf10");
                parameter.put("device", "desktop");
                parameter.put("engine", "google_events");
                parameter.put("q", "investment events");
//                parameter.put("htichips", "date:next month");

                GoogleSearch search = new GoogleSearch(parameter);

                try {
                    JsonObject results = search.getJson();
                    event = results.getAsJsonArray("events_results");

                } catch (SerpApiSearchException e) {

                }
            }
//        for(JsonElement e:event) {
//            String address = e.getAsJsonObject().getAsJsonArray("address").get(0).getAsString()+", "+e.getAsJsonObject().getAsJsonArray("address").get(1).getAsString();
//            System.out.println(address);
//        }
            request.setAttribute("recommend", event);

            processTemplate("product/recommend", request, response);
        } else {
            processTemplate("user/login",request,response);
        }
    }

//    public void getRecommend(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        User user = (User) request.getSession().getAttribute(StoreConstants.USERSESSIONKEY);
//        String preference = user.getPreference();
//        if (preference == "loan") {
//            Map<String, String> parameter = new HashMap<>();
//
//            parameter.put("api_key", "67de5b0f058fda90127575f55ea23ec65e70e22918b2e0ebc1f44c8951089e49");
//            parameter.put("device", "desktop");
//            parameter.put("engine", "google_events");
//            parameter.put("q", "Financial investment events");
//
//            GoogleSearch search = new GoogleSearch(parameter);
//
//            try {
//                JsonObject results = search.getJson();
//            } catch (SerpApiSearchException e) {
//
//            }
//        }
////        request.setAttribute("recommend",);
//
//    }
//}
}