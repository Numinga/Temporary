package com.numinga.impvault.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by Ivan on 12/10/2017.
 */

class DBHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, ctx.applicationInfo.name) {

    private val dbVersion : Int = 1

    companion object {
        private var instance: DBHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DBHelper {
            if (instance == null) {
                instance = DBHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        if (db.version < dbVersion) // is it neccessary?
            onUpgrade(db, db.version, dbVersion)

        db.transaction {
            createTable(DBStructure.CARD, true,
                    DBStructure.ID to INTEGER + PRIMARY_KEY + UNIQUE + AUTOINCREMENT,
                    DBStructure.LOGIN to TEXT,
                    DBStructure.PASS to TEXT)

            createTable(DBStructure.ACCOUNT, true,
                    DBStructure.ID to INTEGER + PRIMARY_KEY + UNIQUE + AUTOINCREMENT,
                    DBStructure.NUMBER to TEXT,
                    DBStructure.HOLDER_NAME to TEXT,
                    DBStructure.CODE to TEXT,
                    DBStructure.EXPIRATION_DATE to INTEGER,
                    DBStructure.BACKGROUND to INTEGER)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }
}

// Access property for Context
val Context.database: DBHelper
    get() = DBHelper.getInstance(applicationContext)