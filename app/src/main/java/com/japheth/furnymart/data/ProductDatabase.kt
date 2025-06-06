package com.japheth.furnymart.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.japheth.furnymart.model.Product
import com.japheth.furnymart.model.User
@Database(entities = [Product::class, User::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "main_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}