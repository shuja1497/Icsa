package shuja1497.icsa;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class TryingVolley extends AppCompatActivity {

    EditText aadhaar , phone ;
    Button send;
    String server_url="http://192.168.43.196/icsa.php";
    AlertDialog.Builder builder;
    String aadhar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trying_volley);

        aadhaar=(EditText)findViewById(R.id.aadaar);
        phone=(EditText)findViewById(R.id.phone);
        send=(Button) findViewById(R.id.send);


        builder= new AlertDialog.Builder(TryingVolley.this);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aadhar=aadhaar.getText().toString();

/*
                final String aadhar , ph ;

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

                        Toast.makeText(TryingVolley.this,"server down",Toast.LENGTH_SHORT).show();
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




*/













                Intent i = new Intent(TryingVolley.this,voting.class);
                i.putExtra("aadhar_no",aadhar);
                startActivity(i);
            }
        });


    }




}
