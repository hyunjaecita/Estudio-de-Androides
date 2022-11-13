package com.example.finalmultimedia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.sql.Date;

public class DbUsers extends DbAyudita {
    Context context;

    public DbUsers(@Nullable Context context){
        super(context);
        this.context=context;
    }

    public long insUser(String nombre, String contraseña, String dni, String correo_electronico, String cumple ){
        long id = 0;
        try{
            DbAyudita dbAyudita = new DbAyudita(context);
            SQLiteDatabase db = dbAyudita.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("contraseña", contraseña);
            values.put("dni", dni);
            values.put("correo_electronico", correo_electronico);
            values.put("cumple", cumple);

            id = db.insert(TABLE_USERS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public int existe(String dni, String contraseña){
        DbAyudita da = new DbAyudita(context);
        SQLiteDatabase sqldb = da.getWritableDatabase();
        String consultiya = " select count(*) from " + TABLE_USERS + " where (dni = '" + dni+"')" + "and(contraseña = '" +contraseña+"');";
        Cursor resultado = sqldb.rawQuery(consultiya,null);
        resultado.moveToNext();
        return resultado.getInt(0);
    }


    public int actualizacionCum(String cumple, String dni){
        int numerito = 0;
        try {
            DbAyudita da = new DbAyudita(context);
            SQLiteDatabase sqldb = da.getWritableDatabase();
            ContentValues nuevo = new ContentValues();
            nuevo.put("cumple", cumple);
            numerito = sqldb.update(TABLE_USERS, nuevo, "dni = " + dni , null);
        }catch (Exception e){
            e.toString();
        }
        return numerito;
    }
    public int actualizacionNom(String nombre, String dni){
        int numerito = 0;
        try {
            DbAyudita da = new DbAyudita(context);
            SQLiteDatabase sqldb = da.getWritableDatabase();
            ContentValues nuevo = new ContentValues();
            nuevo.put("nombre", nombre);
            numerito = sqldb.update(TABLE_USERS, nuevo, "dni = " + dni , null);
        }catch (Exception e){
            e.toString();
        }
        return numerito;
    }
    public int actualizacionEm(String correoNuevo, String dni){
        int numerito = 0;
        try {
            DbAyudita da = new DbAyudita(context);
            SQLiteDatabase sqldb = da.getWritableDatabase();
            ContentValues nuevo = new ContentValues();
            nuevo.put("correo_electronico", correoNuevo);
            numerito = sqldb.update(TABLE_USERS, nuevo, "dni = " + dni , null);
        }catch (Exception e){
            e.toString();
        }
        return numerito;
    }
    public int actualizacionCon(String contraseña, String dni){
        int numerito = 0;
        try {
            DbAyudita da = new DbAyudita(context);
            SQLiteDatabase sqldb = da.getWritableDatabase();
            ContentValues nuevo = new ContentValues();
            nuevo.put("contraseña", contraseña);
            numerito = sqldb.update(TABLE_USERS, nuevo, "dni = '" + dni +"'", null);
        }catch (Exception e){
            e.toString();
        }
        return numerito;
    }

    public int borrar(String dni){
        int numerito = 0;
        try {
            DbAyudita da = new DbAyudita(context);
            SQLiteDatabase sqldb = da.getWritableDatabase();
            numerito = sqldb.delete(TABLE_USERS, "dni = '" + dni + "'", null);
        }catch (Exception e){
            e.toString();
        }
        return numerito;
    }

    public Usuario datoUsuario(String dni){
        DbAyudita da = new DbAyudita(context);
        SQLiteDatabase sqldb = da.getWritableDatabase();
        String consultiya = " select nombre, dni, correo_electronico, cumple from " + TABLE_USERS + " where (dni = '" + dni+"')";
        Cursor resultado = sqldb.rawQuery(consultiya,null);
        resultado.moveToNext();
        return new Usuario(resultado.getString(0), resultado.getString(1), resultado.getString(2), resultado.getString(3));
    }
}
