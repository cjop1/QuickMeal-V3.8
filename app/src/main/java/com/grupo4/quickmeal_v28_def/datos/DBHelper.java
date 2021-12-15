package com.grupo4.quickmeal_v28_def.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    /**
     * Declaración del objeto de la base de datos
     */
    private SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context) {
        super(context, "BDQuickMeal.db", null, 1);
        sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /**
         * CREACION DE TABLAS DE BASE DE DATOS
         */

        db.execSQL("CREATE TABLE CARTAS(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PRODUCTO VARCHAR," +
                "DESCRIPCION VARCHAR," +
                "PRECIO VARCHAR," +
                "IMAGE BLOB" +
                ")");

        db.execSQL("CREATE TABLE COMBOS(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PRODUCTO VARCHAR," +
                "DESCRIPCION VARCHAR," +
                "PRECIO VARCHAR," +
                "IMAGE BLOB" +
                ")");

        db.execSQL("CREATE TABLE RESTAURANTES(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "RESTAURANTE VARCHAR," +
                "DIRECCI0N VARCHAR," +
                "LOCACION VARCHAR," +
                "IMAGE BLOB" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CARTAS");
        db.execSQL("DROP TABLE IF EXISTS COMBOS");
        db.execSQL("DROP TABLE IF EXISTS RESTAURANTES");
    }

    /**
     * CRUD
     */

    //1. Obtener Producto

    public Cursor obtenerData(String table){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+table, null);
        return cursor;
    }

    /**2. Obtener Producto by Id

    public Cursor obtenerDataById(String id){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM PRODUCTOS WHERE ID = "+id, null);
        return cursor;
    }
     **/

    //3. Insertar Producto

    public void insertarData(String campo1, String campo2, String campo3, byte[] image, String table){
        String sql = "INSERT INTO "+ table +" VALUES(null, ?, ?, ?, ?)";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, campo1);
        statement.bindString(2, campo2);
        statement.bindString(3, campo3);
        statement.bindBlob(4, image);

        statement.executeInsert();
    }

    /**
    //4. Actualizar Producto

    public void actualizarData(String ID, String PRODUCTO, byte[] IMAGE, String DESCRIPCION, String PRECIO){
        String sql = "UPDATE PRODUCTOS " +
                "SET PRODUCTO=?," +
                "DESCRIPCION=?," +
                "PRECIO=?," +
                "IMAGE=?";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, PRODUCTO);
        statement.bindString(2, DESCRIPCION);
        statement.bindString(3, PRECIO);
        statement.bindBlob(4, IMAGE);

        statement.executeUpdateDelete();
    }

   //5. Borrar Producto

    public void deleteData(String id){
        String[] args = new String[]{id};
        sqLiteDatabase.delete("PRODUCTOS", "ID=?", args);
    }
**/
}

