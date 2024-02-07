package com.example.stackExchange.util;

import com.example.stackExchange.filter.RestAssuredLogFilter;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
@Component

public class Util {
    private static final String SERVICE_URL_HOST_FORMAT = "https://api.stackexchange.com/2.3/badges/";

    public static final String BADGES_IDS = "?order=desc&sort=rank&site=stackoverflow";
    public static final String RECIPIENTS_IDS ="?site=stackoverflow";
    public static final String BADGES_TAGS = "?order=desc&sort=rank&site=stackoverflow";

    public String getServiceUrlWithPath(String path, String identifier) {

    if (identifier.equalsIgnoreCase("id")) {
        if (path.equalsIgnoreCase("all")) {
            return format(getServiceUrlHost() + BADGES_IDS);
        } else {
            return format("%s", getServiceUrlHost() + path + BADGES_IDS);
        }
}
        if (identifier.equalsIgnoreCase("recipients")) {
            if (path.equalsIgnoreCase("all")) {
                return format(getServiceUrlHost() + identifier+RECIPIENTS_IDS);
            }
            else {
                return format("%s", getServiceUrlHost() + path +"/"+identifier+ RECIPIENTS_IDS);
            }
        }
        if (identifier.equalsIgnoreCase("tags")) {
            if (path.equalsIgnoreCase("all")) {
                return format(getServiceUrlHost() + identifier+BADGES_TAGS);
            }
            else {
                return format("%s", getServiceUrlHost() + path +"/"+identifier+ BADGES_TAGS);
            }
        }

        else {
            return format("%s", getServiceUrlHost() + path +"/"+ identifier + RECIPIENTS_IDS);
        }
    }

   public String getServiceUrlHost() {
        return format(SERVICE_URL_HOST_FORMAT);
    }

    public static Response get(String url) {
        return given()
                .filters(new RestAssuredLogFilter())
                .when()
                .get(url)
                .thenReturn();
    }

}
