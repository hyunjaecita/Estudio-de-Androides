package com.example.finalmultimedia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbAyudita extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NOMBRE = "usuarios.db";
    public static  final String TABLE_USERS = "t_users";

    public DbAyudita(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USERS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL," +
                "contraseña TEXT NOT NULL,"+
                "dni TEXT (9) UNIQUE NOT NULL ,"+
                "correo_electronico TEXT," +
                "cumple TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_USERS);
        onCreate(sqLiteDatabase);
    }
}
