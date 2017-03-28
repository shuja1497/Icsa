package shuja1497.icsa;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    TextView tv;
    ViewFlipper vf;
    Animation fade_in , fade_out ;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank,container,false);




        vf  = (ViewFlipper)view.findViewById(R.id.vflip);

        fade_in = AnimationUtils.loadAnimation(getActivity().getApplicationContext() , android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(getActivity().getApplicationContext() , android.R.anim.fade_out);

        vf.setInAnimation(fade_in);
        vf.setOutAnimation(fade_out);

        vf.setAutoStart(true);

        vf.setFlipInterval(2500);

        vf.startFlipping();

        Button vote = (Button)view.findViewById(R.id.vote);
        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(),TryingVolley.class));
            }
        });



        return view ;
    }






}
