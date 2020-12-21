package com.example.program2_478;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CarDealers extends AppCompatActivity {

    ListView view;
    List<String> carList = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    int dealer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealers);

        Intent intent = getIntent();
        dealer = intent.getExtras().getInt("Index");
        view = (ListView) findViewById(R.id.listview1);

        switch(dealer){
            case 0:
                carList.add("1. Toyota of Lincoln Park: 1561 North Fremont Street, Chicago, IL 60642");
                carList.add("2. Midtown Toyota: 2700 North Cicero Avenue, Chicago, IL 60639");
                carList.add("3. Toyota On Western: 6941 South Western Ave, Chicago, IL 60636");
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,carList);
                view.setAdapter(adapter);
                break;

            case 1:
                carList.add("1. Berman Nissan of Chicago: 3456 N Kedzie Ave Chicago, Illinois 60618");
                carList.add("2. Star Nissan: 5757 W Touhy Ave, Niles, IL 60714");
                carList.add("3. Al Piemonte Nissan: 1600 West North Ave, Melrose Park, IL 60160");
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,carList);
                view.setAdapter(adapter);
                break;

            case 2:
                carList.add("1. Mc Grath City Honda: 6720 W Grand Ave Chicago, IL 60707");
                carList.add("2. Honda of Downtown Chicago: 1111 N Clark St Chicago, IL 60610");
                carList.add("3. North City Honda: 6600 N Western Ave Chicago, IL 60645");
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,carList);
                view.setAdapter(adapter);
                break;

            case 3:
                carList.add("1. Fox Ford Lincoln: 2501 North Elston Avenue Chicago, IL 60647");
                carList.add("2. Zeigler Ford of North Riverside: 2100 South Harlem Avenue North Riverside, IL 60546");
                carList.add("3. Al Piemonte Ford Sales, Inc.: 2500 West North Ave Melrose Park, IL 60160");
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,carList);
                view.setAdapter(adapter);
                break;

            case 4:
                carList.add("1. Mike Anderson Chevrolet of Chicago, LLC: 5333 W Irving Park Road Chicago, IL 60641");
                carList.add("2. Currie Motors Chevrolet, Inc.: 8401 W Roosevelt Rd Forest Park, IL 60130");
                carList.add("3. Rogers Auto Group: 2720 S Michigan Ave Chicago, IL 60616");
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,carList);
                view.setAdapter(adapter);
                break;

            case 5:
                carList.add("1. Chicago-Gold Coast: 901 North Rush Street Chicago, IL 60611");
                carList.add("2. Chicago-West Grand Avenue: 1053 W. Grand Avenue Chicago, IL 60642");
                carList.add("3. Chicago-Highland Park: 1200 Old Skokie Valley Road Highland Park, IL 60035");
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,carList);
                view.setAdapter(adapter);
                break;

        }

    }


}
