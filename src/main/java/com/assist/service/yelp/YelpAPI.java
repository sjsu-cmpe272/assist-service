package com.assist.service.yelp;

import com.assist.service.domain.YelpRequestBody;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/**
 * Created by sindhya on 10/31/16.
 */
public class YelpAPI {

    OAuthService oauthService;
    Token token;
    public YelpAPI() {
        this.oauthService = new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(YelpConstants.CONSUMER_KEY)
                .apiSecret(YelpConstants.CONSUMER_SECRET_KEY).build();
        this.token = new Token(YelpConstants.ACCESS_TOKEN, YelpConstants.TOKEN_SECRET_KEY);
    }

    public String searchRestaurantByLocation(YelpRequestBody yelpRequestBody){
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://" + YelpConstants.YELP_API_HOST + YelpConstants.YELP_SEARCH_PATH);
        String location=yelpRequestBody.getLocation();
        String latlong=yelpRequestBody.getLatlong();
        String term=yelpRequestBody.getTerm();
        String filter=yelpRequestBody.getFilter();

        request.addQuerystringParameter("radius_filter","1000");
        if(location!=null)
            request.addQuerystringParameter("location", yelpRequestBody.getLocation());
        else
            request.addQuerystringParameter("ll",yelpRequestBody.getLatlong());

        if(!(term==null)) {
            request.addQuerystringParameter("term", term);
        }
        if(!(filter==null)) {
            request.addQuerystringParameter("category_filter",filter);
        }

        //request.addQuerystringParameter("limit", String.valueOf(SEARCH_LIMIT));
        oauthService.signRequest(this.token, request);
        Response response = request.send();
        System.out.println("Yelp resp:  "+response.getBody().toString());
        return response.getBody();

    }




}
