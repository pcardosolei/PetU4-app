package pet4u.pet4u.managers;

import com.loopj.android.http.*;

import pet4u.pet4u.AppProperties;

/**
 * Created by Rafael on 26/01/2017.
 */

public class ServerHttpClient {

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return AppProperties.baseUrl + relativeUrl;
    }
}