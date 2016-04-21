package com.android4dev.navigationview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TABKA on 21/04/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //database values
    private static final String DATABASE_NAME      = "SmartLife.db";
    private static final int DATABASE_VERSION      = 1;
    public static final String COLUMN_ID           = "_id";

    private static final String CREATE_TABLE_Predicition = "CREATE TABLE Predicition (id INTEGER PRIMARY KEY NOT NULL,"
            +"EquipementID INTEGER NOT NULL, "
            +"Value REAL  NOT NULL,"
            +"Date DATETIME NOT NULL,"
            +"PropertieName INTEGER NOT NULL,"
            +"FOREIGN KEY(EquipementID) REFERENCES Equipement(ID)"
            +")";



    private static final String CREATE_TABLE_PredictedEquipement = "CREATE TABLE PredictedEquipement (id INTEGER PRIMARY KEY NOT NULL,"
            +"EquipementID INTEGER NOT NULL, "
            +"Value REAL  NOT NULL,"
            +"Date DATETIME NOT NULL,"
            +"Verrified INTEGER NOT NULL,"
            +"FOREIGN KEY(EquipementID) REFERENCES Equipement(ID)"
            +")";

    private static final String CREATE_TABLE_Equipement = "CREATE TABLE Equipement (id INTEGER PRIMARY KEY NOT NULL,"
            +"ID INTEGER NOT NULL, "
            +"EntitledID VARCHAR(50)  NOT NULL,"
            +"BoxID INTEGER NOT NULL,"
            +")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_Predicition);
        db.execSQL(CREATE_TABLE_PredictedEquipement);
    }
    //select from PredictedEquipement
/* String select_PredictedEquipement=" select * from PredictedEquipement where condition ";
log.e(LOG,select_PredictedEquipement);
Cursor c = db.rawQuery(select_PredictedEquipement, null);

 */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PredictedEquipement");
        db.execSQL("DROP TABLE IF EXISTS Predicition ");

        onCreate(db);
    }
}
