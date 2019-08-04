package com.bateman.candystorev4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
//Concept borrowed from Hervé J. Franceschi

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_main );
    Toolbar toolbar = findViewById( R.id.toolbar );
    setSupportActionBar( toolbar );
  }

  @Override
  public boolean onCreateOptionsMenu( Menu menu ) {
    getMenuInflater( ).inflate( R.menu.menu_main, menu );
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId( );
    switch ( id ) {
      case R.id.action_add:
        Intent insertIntent = new Intent( this, InsertActivity.class );
        this.startActivity( insertIntent );
        return true;
      case R.id.action_delete:
        Intent deleteIntent = new Intent( this, DeleteActivity.class );
        this.startActivity( deleteIntent );
        return true;
      case R.id.action_update:
        Intent updateIntent = new Intent( this, UpdateActivity.class );
        this.startActivity( updateIntent );
        return true;
      case R.id.action_exit:
        this.finish();
        return true;
      default:
        return super.onOptionsItemSelected( item );
    }
  }
}
