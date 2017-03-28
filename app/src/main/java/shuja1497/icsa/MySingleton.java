package shuja1497.icsa;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by shuja reshi on 3/28/2017.
 */

public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue requestQueue;
    private static Context mCtx;

    private MySingleton(Context context)
    {
        mCtx = context;
        requestQueue = getRequestQueue();

    }

    public static synchronized MySingleton getInstance(Context ctx){

        if(mInstance == null){
            mInstance = new MySingleton(ctx);
        }
        return mInstance;
    }

    public <T>void addToRequestQueue(Request<T> request){
        requestQueue.add(request);

    }


    public RequestQueue getRequestQueue(){

        if(requestQueue == null)
        {
            requestQueue= Volley.newRequestQueue(mCtx.getApplicationContext());
        }

        return requestQueue;
    }

}
