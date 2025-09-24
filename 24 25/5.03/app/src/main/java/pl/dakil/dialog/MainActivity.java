package pl.dakil.dialog;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int[] drawableResIds = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img6,
                R.drawable.img7,
                R.drawable.img8,
                R.drawable.img9,
                R.drawable.img10,
                R.drawable.img11,
                R.drawable.img12,
                R.drawable.img13,
                R.drawable.img14,
                R.drawable.img15
        };

        int[] imageViewIds = {
                R.id.imageView1,
                R.id.imageView2,
                R.id.imageView3,
                R.id.imageView4,
                R.id.imageView5,
                R.id.imageView6,
                R.id.imageView7,
                R.id.imageView8,
                R.id.imageView9,
                R.id.imageView10,
                R.id.imageView11,
                R.id.imageView12,
                R.id.imageView13,
                R.id.imageView14,
                R.id.imageView15
        };

        for (int i = 0; i < imageViewIds.length; i++) {
            ImageView imageView = findViewById(imageViewIds[i]);
            imageView.setImageResource(drawableResIds[i]);
            imageView.setTag(drawableResIds[i]);
            imageView.setOnClickListener(this::showImageDialog);
        }
    }

    private void showImageDialog(View view) {
        int imageResId = (int) view.getTag();
        ImageDialogFragment dialogFragment = ImageDialogFragment.newInstance(imageResId);
        dialogFragment.show(getSupportFragmentManager(), "imageDialog");
    }
}