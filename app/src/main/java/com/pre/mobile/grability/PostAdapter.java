package com.pre.mobile.grability;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Carlos Mauricio Idárraga Espitia on 10/06/2015.
 */
public class PostAdapter  extends ArrayAdapter {

    //Atributos
    private RequestQueue requestQueue;
    private static final String URL_BASE="http://servidorexterno.site90.com/datos";
    private static final String URL_JSON="/social_media.json";
    private static final String TAG= "PostAdapter";
    List<Post> items;





    public PostAdapter(Context context){
        super(context,0);
        //gestionar petición del archivo JSON
        requestQueue= Volley.newRequestQueue(context);

        JsonObjectRequest jsArrayRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL_BASE + URL_JSON,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        items = parseJson(response);
                        notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG,"Error Respuesta Json: " + error.getMessage() );
                    }
                }
        );

        requestQueue.add(jsArrayRequest);



    }

    @Override
    public int getCount(){

        return items != null ? items.size() : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        //Salvando la referencia del View de la fila

        View listItemView = convertView;

        //comprobando si el View existe

        if(null == convertView){
            //Si no existe, entonces inflarlo

            listItemView = layoutInflater.inflate(R.layout.post,
                    parent,
                    false);

            //procesar item


        }
        return listItemView;
    }

}
