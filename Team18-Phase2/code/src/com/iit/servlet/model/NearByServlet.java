package com.iit.servlet.model;

import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import com.iit.bean.Near;
import com.iit.servlet.base.ModelBaseServlet;
import com.google.maps.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class NearByServlet extends ModelBaseServlet {
    public void showMap(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        if(type.equals("near-me")) {
            processTemplate("product/near-by", request, response);
        }
    }



    public void getAddress (HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException, ApiException {
        String address = request.getParameter("address");


        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyBvJ0-vbqwdWJdOYGGQOhkxfdF9JkRSLwo")
                .build();
        GeocodingResult[] results =  GeocodingApi.geocode(context,address).await();

        double lat = results[0].geometry.location.lat;
        double lng = results[0].geometry.location.lng;

        LatLng location = new LatLng(lat, lng);

        PlacesSearchResponse res =
            PlacesApi.nearbySearchQuery(context, location)
                    .radius(2000)
                    .language("en")
                    .type(PlaceType.BANK)
                    .await();

//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = RequestBody.create(mediaType, "");
//
//        Request req = new Request.Builder()
//                .url("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+"%"+lng+"&radius=1500&type=atm&key=AIzaSyBvJ0-vbqwdWJdOYGGQOhkxfdF9JkRSLwo")
//                .method("POST", body)
//                .build();
//        Response resp = client.newCall(req).execute();
//        System.out.println(resp.body());
////
//        Near near1 = new Near(res.results[0].name,res.results[0].formattedAddress);
//        Near near2 = new Near(res.results[1].name,res.results[1].formattedAddress);
//
        request.setAttribute("nearlist", res.results);
        processTemplate("product/near-by", request, response);
        // Invoke .shutdown() after your application is done making requests
        context.shutdown();
    }


}
