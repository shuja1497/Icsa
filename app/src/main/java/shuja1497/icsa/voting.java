package shuja1497.icsa;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static shuja1497.icsa.R.id.phone;

public class voting extends AppCompatActivity {


    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    String server_url="http://192.168.43.196/icsa.php";

    String aadhar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        Bundle aadhaar= getIntent().getExtras();
         aadhar=aadhaar.getString("aadhar_no");

        tv1 = (TextView)findViewById(R.id.textncp);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(voting.this,"SERver Down",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();

                    }
                }){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String,String> params = new HashMap<String, String>();
                        params.put("aadhar_id",aadhar);
                        int a= 1;
                        String id = new Integer(a).toString();
                        params.put("party_id",id);

                        return params;
                    }
                };

                MySingleton.getInstance(voting.this).addToRequestQueue(stringRequest);

                Toast.makeText(voting.this,"u have voted for NCP",Toast.LENGTH_SHORT).show();

                startActivity(new Intent(voting.this,MainActivity.class));



            }
        });

/*

        send=(Button) findViewById(R.id.send);

        builder= new AlertDialog.Builder(TryingVolley.this);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String aadhar , ph ;
                aadhar=aadhaar.getText().toString();
                ph=phone.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                builder.setTitle("server response");
                                builder.setMessage("Response:"+ response);
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        aadhaar.setText("");
                                        phone.setText("");
                                    }
                                });

                                AlertDialog  alertDialog=  builder.create();
                                alertDialog.show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(TryingVolley.this,"thuk gyi app",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();

                    }
                }){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String,String> params = new HashMap<String, String>();
                        params.put("aadhar_id",aadhar);
                        params.put("party_id",ph);

                        return params;
                    }
                };

                MySingleton.getInstance(TryingVolley.this).addToRequestQueue(stringRequest);
            }
        });*/
    }
}
