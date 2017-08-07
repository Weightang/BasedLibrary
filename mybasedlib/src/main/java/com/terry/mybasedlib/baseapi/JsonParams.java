package com.terry.mybasedlib.baseapi;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class JsonParams {

    protected final JSONObject params = new JSONObject();


    public JsonParams() {
    }

    public void put(String key, String value) {
        if (key != null && value != null) {
            try {
                params.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String key, boolean value) {
        if (key != null) {
            try {
                params.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String key, int value) {
        if (key != null) {
            try {
                params.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String key, float value) {
        if (key != null) {
            try {
                params.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String key, double value) {
        if (key != null) {
            try {
                params.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String key, String[] value) {
        if (key != null && value != null) {
            try {
                params.put(key, new JSONArray(Arrays.asList(value)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String key, JSONArray value) {
        if (key != null && value != null) {
            try {
                params.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String key, JSONObject value) {
        if (key != null && value != null) {
            try {
                params.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JsonParams remove(String key) {
        params.remove(key);
        return this;
    }

    public JSONObject toJson() {
        return params;
    }


    public RequestBody toBoby() {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), toString());
    }


    public String toString() {
        return params.toString();
    }

    private String getEncodedParamString() {
        StringBuilder result = new StringBuilder();
        Iterator it = params.keys();
        while (it.hasNext()) {
            if (result.length() > 0)
                result.append("&");

            String key = (String) it.next();
            String value = params.optString(key);
            result.append(URLEncoder.encode(key));
            result.append("=");
            result.append(URLEncoder.encode(value));
        }
        return result.toString();
    }


    /**
     * 把参数转成 query string
     *
     * @return String
     */
    public String toQueryString(String url) {
        String paramString = getEncodedParamString();
        if (TextUtils.isEmpty(paramString)) {
            return url;
        }

        if (url.indexOf("?") == -1) {
            url += "?" + paramString;
        } else {
            url += "&" + paramString;
        }
        return url;
    }
}