package com.example.program2_478;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowImage extends AppCompatActivity {

    final ArrayList<Uri> mUriList= new ArrayList<Uri>();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();

        i = intent.getExtras().getInt("Index");

        final ImageView img= (ImageView) findViewById(R.id.imageView1);
        img.setImageResource(MainActivity.images[i]);

        initializeCarUris();

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = mUriList.get(i);
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(uri);
                intent2.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(intent2);
            }
        });
    }

    private void initializeCarUris(){

        mUriList.add(Uri.parse("https://www.toyota.com/rav4/"));
        mUriList.add(Uri.parse("https://www.nissanusa.com/vehicles/crossovers-suvs/rogue.html"));
        mUriList.add(Uri.parse("https://automobiles.honda.com/cr-v"));
        mUriList.add(Uri.parse("https://www.ford.com/suvs-crossovers/escape/"));
        mUriList.add(Uri.parse("https://www.chevrolet.com/suvs/equinox"));
        mUriList.add(Uri.parse("https://www.tesla.com/modelx"));
    }

}
