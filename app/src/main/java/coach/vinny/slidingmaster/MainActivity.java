package coach.vinny.slidingmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String [] imagesLinks = {
            "https://imgs.xkcd.com/comics/post_vaccine_social_scheduling.png",
            "https://imgs.xkcd.com/xkcloud/splash.png",
            "https://imgs.xkcd.com/comics/puzzle.png",
            "https://imgs.xkcd.com/comics/data_pipeline.png",
            "https://imgs.xkcd.com/comics/rule_34.png",
            "https://imgs.xkcd.com/comics/orphaned_projects.png",
            "https://imgs.xkcd.com/comics/quantum_teleportation.png",
            "https://imgs.xkcd.com/comics/artifacts.png",
            "https://imgs.xkcd.com/comics/tinder.png",
            "https://imgs.xkcd.com/comics/worst_hurricane.png"
    };

    private ImageView display;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.image_zone);
        SeekBar slider = findViewById(R.id.slider);
        progressBar = findViewById(R.id.progress);

        // Load the first image
        loadImage(0);

        // set the maximum of the slider to the length of our array
        slider.setMax(imagesLinks.length);
        // add a change listener to the slider/seekbar
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // The progress variable represents which image we want to display. 1 indexing
                loadImage(progress - 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void loadImage(int index) {
        /*
        This function loads the image at the specified index into the ImageView.
         */
        Picasso.get().load(imagesLinks[index]).into(display, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                Log.e("SLIDER", "Failed to load image", e);
            }
        });
    }

}