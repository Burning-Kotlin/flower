package com.bulko.flowerkkio

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class PostRepository(context: Context) {

    private val dbHelper = PostDatabaseHelper(context)

    fun addPost(title: String, content: String, imageUri: String): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(PostDatabaseHelper.COLUMN_TITLE, title)
            put(PostDatabaseHelper.COLUMN_CONTENT, content)
            put(PostDatabaseHelper.COLUMN_IMAGE_URI, imageUri)
        }
        return db.insert(PostDatabaseHelper.TABLE_POSTS, null, values)
    }

    fun updatePost(id: Long, title: String, content: String, imageUri: String) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(PostDatabaseHelper.COLUMN_TITLE, title)
            put(PostDatabaseHelper.COLUMN_CONTENT, content)
            put(PostDatabaseHelper.COLUMN_IMAGE_URI, imageUri)
        }
        db.update(PostDatabaseHelper.TABLE_POSTS, values, "${PostDatabaseHelper.COLUMN_ID} = ?",
            arrayOf(id.toString()))
    }



    fun getPost(id: Long): Post? {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            PostDatabaseHelper.TABLE_POSTS,
            null,
            "${PostDatabaseHelper.COLUMN_ID} = ?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        return cursor?.use {
            if (it.moveToFirst()) {
                val post = Post(
                    id = it.getLong(it.getColumnIndexOrThrow(PostDatabaseHelper.COLUMN_ID)),
                    title = it.getString(it.getColumnIndexOrThrow(PostDatabaseHelper.COLUMN_TITLE)),
                    content = it.getString(it.getColumnIndexOrThrow(PostDatabaseHelper.COLUMN_CONTENT)),
                    imageUri = it.getString(it.getColumnIndexOrThrow(PostDatabaseHelper.COLUMN_IMAGE_URI))
                )
                post
            } else {
                null
            }
        }
    }
}
