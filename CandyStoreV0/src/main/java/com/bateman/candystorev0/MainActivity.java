package com.bateman.candystorev0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

//Concept borrowed from Hervé J. Franceschi

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    switch ( id ) {
      case R.id.action_add:
        Log.w( "MainActivity", "Add selected" );
        return true;
      case R.id.action_delete:
        Log.w( "MainActivity", "Delete selected" );
        return true;
      case R.id.action_update:
        Log.w( "MainActivity", "Update selected" );
        return true;
      default:
        return super.onOptionsItemSelected( item );
    }
  }
}
