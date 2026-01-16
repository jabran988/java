package io.ipinfo.api.model;

import com.google.gson.annotations.SerializedName;

public class ResproxyResponse {
    private final String ip;
    @SerializedName("last_seen")
    private final String lastSeen;
    @SerializedName("percent_days_seen")
    private final Double percentDaysSeen;
    private final String service;

    public ResproxyResponse(
            String ip,
            String lastSeen,
            Double percentDaysSeen,
            String service
    ) {
        this.ip = ip;
        this.lastSeen = lastSeen;
        this.percentDaysSeen = percentDaysSeen;
        this.service = service;
    }

    public String getIp() {
        return ip;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public Double getPercentDaysSeen() {
        return percentDaysSeen;
    }

    public String getService() {
        return service;
    }

    @Override
    public String toString() {
        return "ResproxyResponse{" +
                "ip='" + ip + '\'' +
                ", lastSeen='" + lastSeen + '\'' +
                ", percentDaysSeen=" + percentDaysSeen +
                ", service='" + service + '\'' +
                '}';
    }
}
