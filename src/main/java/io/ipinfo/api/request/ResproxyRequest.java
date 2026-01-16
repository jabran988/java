package io.ipinfo.api.request;

import io.ipinfo.api.errors.ErrorResponseException;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.ResproxyResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ResproxyRequest extends BaseRequest<ResproxyResponse> {
    private final static String URL_FORMAT = "https://ipinfo.io/resproxy/%s";
    private final String ip;

    public ResproxyRequest(OkHttpClient client, String token, String ip) {
        super(client, token);
        this.ip = ip;
    }

    @Override
    public ResproxyResponse handle() throws RateLimitedException {
        String url = String.format(URL_FORMAT, ip);
        Request.Builder request = new Request.Builder().url(url).get();

        try (Response response = handleRequest(request)) {
            if (response == null || response.body() == null) {
                return null;
            }

            try {
                return gson.fromJson(response.body().string(), ResproxyResponse.class);
            } catch (Exception ex) {
                throw new ErrorResponseException(ex);
            }
        }
    }
}
