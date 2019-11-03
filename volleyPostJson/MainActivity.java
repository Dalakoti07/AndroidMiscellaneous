package com.myproject.elearning;

import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String URL = "urllink";
        Map<String, String> params = new HashMap();
        params.put("FirstName", "Sahil");
        params.put("Id", "7010100152");
        params.put("Password", "asfas");

        JSONObject parameters = new JSONObject(params);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, URL, parameters,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Rest Response: ", response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response: ", error.toString());

                    }
                }

        );

        requestQueue.add(objectRequest);

    }
}

// Another way of doing the same thing, their pass the JsonObject at params of
// override a method
// public void JsonParse(){

// JsonObjectRequest jsonObjectRequest = new
// JsonObjectRequest(Request.Method.POST,"http://httpbin.org/post",null, new
// Response.Listener<JSONObject>() {

// @Override
// public void onResponse(JSONObject response) {
// textView.setText("Response: " + response.toString());
// Log.d("MainActivity",response.toString());
// }
// }, new Response.ErrorListener() {

// @Override
// public void onErrorResponse(VolleyError error) {
// Toast.makeText(MainActivity.this, "Volley error", Toast.LENGTH_SHORT).show();
// Log.e("MainActivity",error.toString());

// }
// }){
// @Override
// protected Map<String, String> getParams() throws AuthFailureError {
// Map<String,String> map = new HashMap<String, String>();
// map.put("name","Alif");
// map.put("domain","http://itsalif.info");
// return map;
// }
// };
// requestQueue.add(jsonObjectRequest);
// }
