package com.wordpress.cv14site.cmart

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mDrawerList: ListView? = null
    private var mAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDrawerList = findViewById<ListView>(R.id.navList)
        addDrawerItems()
    }

    private fun addDrawerItems() {
        val osArray = arrayOf("Android", "iOS", "Windows", "OS X", "Linux")
        mAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, osArray)
        mDrawerList!!.setAdapter(mAdapter)
    }

    fun toastMe(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe(view: View){

        val countString = textView.text.toString()

        // Convert value to a number and increment it
        var count: Int = Integer.parseInt(countString)
        count++

        // Display the new value in the text view.
        textView.text = count.toString();

    }

    fun randomMe(view: View){
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SeconAct::class.java)

        // Get the current value of the text view.
        val countString = textView.text.toString()

        // Convert the count to an int
        val count = Integer.parseInt(countString)

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(SeconAct.TOTAL_COUNT, count)

        // Start the new activity.
        startActivity(randomIntent)
    }
}
