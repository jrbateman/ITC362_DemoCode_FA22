package com.bateman.candystorev4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class


DatabaseManager extends SQLiteOpenHelper {
  private static final String DATABASE_NAME = "candyDB";
  private static final int DATABASE_VERSION = 1;
  private static final String TABLE_CANDY = "candy";
  private static final String ID = "id";
  private static final String NAME = "name";
  private static final String PRICE = "price";
	
  public DatabaseManager( Context context ) {
    super( context, DATABASE_NAME, null, DATABASE_VERSION );
  }
 
  public void onCreate( SQLiteDatabase db ) {
    // build sql create statement
    String sqlCreate = "create table " + TABLE_CANDY + "( " + ID;
    sqlCreate += " integer primary key autoincrement, " + NAME;
    sqlCreate += " text, " + PRICE + " real )" ;
    
    db.execSQL( sqlCreate );
  }
 
  public void onUpgrade( SQLiteDatabase db,
                         int oldVersion, int newVersion ) {
    // Drop old table if it exists
    db.execSQL( "drop table if exists " + TABLE_CANDY );
    // Re-create tables
    onCreate( db );
  }
    
  public void insert( Candy candy ) {
    SQLiteDatabase db = this.getWritableDatabase( );
    String sqlInsert = "insert into " + TABLE_CANDY;
    sqlInsert += " values( null, '" + candy.getName( );
    sqlInsert += "', '" + candy.getPrice( ) + "' )";
 
    db.execSQL( sqlInsert );
    db.close( );
  }
   
  public void deleteById( int id ) {
    SQLiteDatabase db = this.getWritableDatabase( );
    String sqlDelete = "delete from " + TABLE_CANDY;
    sqlDelete += " where " + ID + " = " + id;
    
    db.execSQL( sqlDelete );
    db.close( );
  }

  public void updateById( int id, String name, double price ) {
    SQLiteDatabase db = this.getWritableDatabase();
 
    String sqlUpdate = "update " + TABLE_CANDY;
    sqlUpdate += " set " + NAME + " = '" + name + "', ";
    sqlUpdate += PRICE + " = '" + price + "'";
    sqlUpdate += " where " + ID + " = " + id;

    db.execSQL( sqlUpdate );
    db.close( );
  }

  public ArrayList<Candy> selectAll( ) {
    String sqlQuery = "select * from " + TABLE_CANDY;
 
    SQLiteDatabase db = this.getWritableDatabase( );
    Cursor cursor = db.rawQuery( sqlQuery, null );
    
    ArrayList<Candy> candies = new ArrayList<Candy>( );
    while( cursor.moveToNext( ) ) {
      Candy currentCandy
          = new Candy( Integer.parseInt( cursor.getString( 0 ) ),
        		        cursor.getString( 1 ), cursor.getDouble( 2 ) );
      candies.add( currentCandy );
    }
    db.close( );
    return candies;
  }
    
  public Candy selectById( int id ) {
    String sqlQuery = "select * from " + TABLE_CANDY;
    sqlQuery += " where " + ID + " = " + id;
    
    SQLiteDatabase db = this.getWritableDatabase( );
    Cursor cursor = db.rawQuery( sqlQuery, null );
 
    Candy candy = null;
    if( cursor.moveToFirst( ) )
      candy = new Candy( Integer.parseInt( cursor.getString( 0 ) ),
		              cursor.getString( 1 ), cursor.getDouble( 2 ) );
    return candy;
  }
}
