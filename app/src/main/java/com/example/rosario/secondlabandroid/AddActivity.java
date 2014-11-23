package com.example.rosario.secondlabandroid;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.rosario.secondlabandroid.R.drawable.ic_launcher;


public class AddActivity extends Activity {

    public static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        TextView counterLabel = (TextView) findViewById(R.id.counterText);
        counterLabel.setText(""+counter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addEnterpriseButton (View view){
        ListItem listItem = new ListItem();
        EditText editTextName = (EditText) findViewById( R.id.nameInput );
        EditText editTextArea = (EditText) findViewById(R.id.areaInput);
        listItem.setName( editTextName.getText().toString());
        listItem.setArea(editTextArea.getText().toString());
        View image = (View) findViewById(R.id.image);
        listItem.setImage( getResources().getDrawable(ic_launcher));
        MainActivity.myArrayList.add(counter++,listItem);
        System.out.println("Ahora el numero de elementos es "+MainActivity.myArrayList.size());
        TextView counterLabel = (TextView) findViewById(R.id.counterText);
        counterLabel.setText(""+counter);
    }

}
