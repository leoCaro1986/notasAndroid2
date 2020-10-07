package com.example.notasandroid2.operations;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import com.example.notasandroid2.database.SQLHelper;
import com.example.notasandroid2.models.NotaModel;

import java.util.ArrayList;

public class NotaOperations {

    private String DBNAME = "Nota_final.db";
    private int VERSION = 2;
    public final Context context;
    private SQLiteDatabase database;
    private SQLHelper helper;
    private NotaModel model;
    private ArrayList<String>list;

    public NotaOperations(Context context) {
        this.context = context;
        helper = new SQLHelper(context, DBNAME, null, VERSION);
    }

    protected void openRead(){
        database =helper.getReadableDatabase();

    }
    protected void openWrite(){
        database = helper.getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    public int insert(NotaModel model)
    {

        ContentValues content =new ContentValues();
        content.put("nombre",model.getNombre());
        content.put("titulo",model.getTitulo());
        content.put("contenido",model.getContenido());

        openWrite();
        long id = database.insert("nota", null, content);
        close();
        return (int)id ;
    }

    public int delete(int id){
        String idString = String.valueOf(id);
        String sqlWhere ="id =?";
        String[] whereArgs = new String[] {idString};

        openWrite();
        return database.delete("nota",sqlWhere,whereArgs);
    }

    public int updateModel (NotaModel model){
        String idString = String.valueOf(model.get_id());
        String sqlWhere ="id=?";
        String[]whereArgs = new String[]{idString};

        ContentValues values = new ContentValues();
        values.put("nombre", model.getNombre());
        values.put("titulo", model.getTitulo());
        values.put("contenido", model.getContenido());

        openWrite();
        return database.update("nota", values,sqlWhere,whereArgs);
    }

    public ArrayList<String> list(){
        list = new ArrayList<String>();
        openRead();

        Cursor cursor = database.query("nota", null, null, null, null, null, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            String nombre, titulo, contenido, consolidado;
            int id;
            do{
                id= cursor.getInt(cursor.getColumnIndex("id"));
                nombre =cursor.getString(cursor.getColumnIndex("nombre"));
                titulo =cursor.getString(cursor.getColumnIndex("titulo"));
                contenido =cursor.getString(cursor.getColumnIndex("contenido"));

                consolidado= String.valueOf(id)+"-"+nombre;
                list.add(consolidado);

            }while(cursor.moveToNext());
        }
        close();
        return list;
    }


}
