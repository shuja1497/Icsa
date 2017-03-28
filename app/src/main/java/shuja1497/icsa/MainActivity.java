package shuja1497.icsa;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewPager vp;
    TabLayout tl;
    ViewFlipper vf;
    Animation fade_in , fade_out ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("ELECTORAL REFORMS");

        tl=(TabLayout)findViewById(R.id.tl);


        vp=(ViewPager)findViewById(R.id.viewpager) ;
        swipeadapter sa = new swipeadapter(getSupportFragmentManager());
        sa.addFragments(new BlankFragment(),"Vote here ");
        sa.addFragments(new BlankFragment2(),"RESULTS");
        // sa.addFragments(new BlankFragment4(),"Register");
        //sa.addFragments(new BlankFragment3(),"About Us");
        vp.setAdapter(sa);
        tl.setupWithViewPager(vp);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(MainActivity.this,ChatActivity.class);
                startActivity(i);

            }
        });



    }
}
