package shuja1497.icsa;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {
    Button b;
    TextView tv;
    String server_url;


    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //View view = inflater.inflate
        View view=inflater.inflate(R.layout.fragment_blank2,container,false);


        server_url="http://192.168.43.196/count_icsa.php";

          b = (Button)view.findViewById(R.id.button2);
          tv = (TextView)view.findViewById(R.id.textView10);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity().getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();


                RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                tv.setText(response);
                                Toast.makeText(getActivity().getApplicationContext(),"success",Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        tv.setText("something went wrong");
                        Toast.makeText(getActivity().getApplicationContext(),"error",Toast.LENGTH_SHORT).show();

                    }
                });


                requestQueue.add(stringRequest);




            }
        });


        return view;
    }


}
