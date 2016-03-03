package yet.best.bottomsheets;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BottomSheetBehavior bottomSheetBehavior;
    Button open, collapse, hide;
    TextView heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View bottomSheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        setup();
    }

    private void setup() {
        open = (Button) findViewById(R.id.open);
        collapse = (Button) findViewById(R.id.collapse);
        hide = (Button) findViewById(R.id.hide);
        heading = (TextView) findViewById(R.id.heading);

        //Handling movement of bottom sheets from buttons
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                heading.setText("Welcome");
                heading.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
            }
        });

        collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                heading.setText("Collapsed");
                heading.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
            }
        });

        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        //Handling movement of bottom sheets from sliding
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    heading.setText("Collapsed");
                    heading.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                } else if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    heading.setText("Welcome");
                    heading.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {

            }
        });
    }

}
