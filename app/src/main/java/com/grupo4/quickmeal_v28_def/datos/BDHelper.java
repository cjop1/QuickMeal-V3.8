package com.grupo4.quickmeal_v28_def.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class BDHelper extends SQLiteOpenHelper {

    /**
     * Declaración del objeto de la base de datos
     */
    private SQLiteDatabase sqLiteDatabase;

    public BDHelper(Context context) {
        super(context, "BDQuickMeal", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /**
         * CREACION DE TABLAS DE BASE DE DATOS
         */

        db.execSQL("CREATE TABLE PRODUCTOS(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PRODUCTO VARCHAR," +
                "IMAGE BLOB," +
                "DESCRIPCION VARCHAR," +
                "PRECIO VARCHAR)");

        db.execSQL("CREATE TABLE COMBOS(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PRODUCTO VARCHAR," +
                "IMAGE BLOB," +
                "DESCRIPCION VARCHAR," +
                "PRECIO VARCHAR)");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCTOS");
        db.execSQL("DROP TABLE IF EXISTS COMBOS");
    }

    /**
     * CRUD
     */

    //1. Obtener Producto

    public Cursor obtenerProductoCarta(){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM PRODUCTOS", null);
        return cursor;
    }

    //1. Obtener Combo

    public Cursor obtenerProductoCombo(){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM COMBOS", null);
        return cursor;
    }


    //2. Obtener Producto by Id

    public Cursor obtenerProductoCartaById(String id){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM PRODUCTOS WHERE ID = "+id, null);
        return cursor;
    }

    //2. Obtener Combo by Id

    public Cursor obtenerProductoComboById(String id){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM COMBOS WHERE ID = "+id, null);
        return cursor;
    }

    //3. Insertar Producto

    public void insertarProductoCarta(String PRODUCTO, byte[] IMAGE, String DESCRIPCION, String PRECIO){
        String sql = "INSERT INTO PRODUCTOS VALUES(null, ?, ?, ?, ?)";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, PRODUCTO);
        statement.bindBlob(2, IMAGE);
        statement.bindString(3, DESCRIPCION);
        statement.bindString(4, (PRECIO));

        statement.executeInsert();
    }

    //3. Insertar Combo

    public void insertarProductoCombo(String PRODUCTO, byte[] IMAGE, String DESCRIPCION, String PRECIO){
        String sql = "INSERT INTO COMBOS VALUES(null, ?, ?, ?, ?)";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, PRODUCTO);
        statement.bindBlob(2, IMAGE);
        statement.bindString(3, DESCRIPCION);
        statement.bindString(4, (PRECIO));

        statement.executeInsert();
    }

    //4. Actualizar Producto

    public void actualizarProductoCarta(String ID, String PRODUCTO, byte[] IMAGE, String DESCRIPCION, String PRECIO){
        String sql = "UPDATE PRODUCTOS " +
                "SET PRODUCTO=?," +
                "IMAGE=?," +
                "DESCRIPCION=?," +
                "PRECIO=?";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, PRODUCTO);
        statement.bindBlob(2, IMAGE);
        statement.bindString(3, DESCRIPCION);
        statement.bindString(4, (PRECIO));

        statement.executeUpdateDelete();
    }

    //4. Actualizar Producto

    public void actualizarProductoCombo(String ID, String PRODUCTO, byte[] IMAGE, String DESCRIPCION, String PRECIO) {
        String sql = "UPDATE PRODUCTOS " +
                "SET PRODUCTO=?," +
                "IMAGE=?," +
                "DESCRIPCION=?," +
                "PRECIO=?";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, PRODUCTO);
        statement.bindBlob(2, IMAGE);
        statement.bindString(3, DESCRIPCION);
        statement.bindString(4, (PRECIO));

        statement.executeUpdateDelete();

    }

    //5. Borrar Producto

    public void deleteProductoCarta(String id){
        String[] args = new String[]{id};
        sqLiteDatabase.delete("PRODUCTOS", "ID=?", args);
    }

    //5. Borrar Producto

    public void deleteProductoCombo(String id){
        String[] args = new String[]{id};
        sqLiteDatabase.delete("COMBOS", "ID=?", args);
    }
}

