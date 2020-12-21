package com.example.program2_478;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    static final int[] images = {R.drawable.rav4, R.drawable.rogue, R.drawable.crv, R.drawable.escape, R.drawable.equinox, R.drawable.modelx};
    static final ArrayList<Uri> mUriList= new ArrayList<Uri>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=(GridView) findViewById(R.id.gridView1);

        ArrayList<Cars> cars = new ArrayList<Cars>();

        cars.add(new Cars("Toyota Rav4",images[0]));
        cars.add(new Cars("Nissan Rogue",images[1]));
        cars.add(new Cars("Honda CR-V",images[2]));
        cars.add(new Cars("Ford Escape",images[3]));
        cars.add(new Cars("Chevy Equinox",images[4]));
        cars.add(new Cars("Tesla Model X",images[5]));

        ImageAdapter adapter = new ImageAdapter(this, cars);
        gridView.setAdapter(adapter);

        //Short click
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ShowImage.class);
                intent.putExtra("Index", i);
                startActivity(intent);
            }
        });

        registerForContextMenu(gridView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo contextmenu = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        initializeCarUris();

        switch (item.getItemId()) {
            case R.id.fullImage:
                Intent intImage = new Intent(getApplicationContext(),ShowImage.class);
                intImage.putExtra("Index", contextmenu.position);
                startActivity(intImage);
                break;

            case R.id.website:
                Uri uri = mUriList.get(contextmenu.position);
                Intent intSite = new Intent(Intent.ACTION_VIEW);
                intSite.setData(uri);
                intSite.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(intSite);
                break;

            case R.id.dealers:
                Intent intDealer = new Intent(getApplicationContext(), CarDealers.class);
                intDealer.putExtra("Index", contextmenu.position);
                startActivity(intDealer);
                break;

            default:
                return super.onContextItemSelected(item);

        }

        return super.onContextItemSelected(item);
    }

    private void initializeCarUris() {
        mUriList.add(Uri.parse("https://www.toyota.com/rav4/"));
        mUriList.add(Uri.parse("https://www.nissanusa.com/vehicles/crossovers-suvs/rogue.html"));
        mUriList.add(Uri.parse("https://automobiles.honda.com/cr-v"));
        mUriList.add(Uri.parse("https://www.ford.com/suvs-crossovers/escape/"));
        mUriList.add(Uri.parse("https://www.chevrolet.com/suvs/equinox"));
        mUriList.add(Uri.parse("https://www.tesla.com/modelx"));
    }

}