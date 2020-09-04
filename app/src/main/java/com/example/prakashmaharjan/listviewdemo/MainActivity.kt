package com.example.prakashmaharjan.listviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
//import com.example.prakashmaharjan.listviewdemo.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.row_main.view.*

import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpListView()


    }

    fun setUpListView() {
        val listView = findViewById<ListView>(R.id.myListView)
        listView.adapter = MyCustomAdapter()
    }


    private class MyCustomAdapter : BaseAdapter() {

        private val androidVersionsArray = arrayListOf<String>(
                "Android 1.0", "Android 1.1 (Petit Four)", "Android 1.5 (Cupcake)", "Android 1.6 (Donut)", "Android 2.0 (Eclair)", "Android 2.2 (Froyo)", "Android 2.3 (Gingerbread)", "Android 3.0 (Honeycomb)", "Android 4.0 (Ice Cream Sandwich)", "Android 4.1 (Jelly Bean)", "Android 4.4 (Kitkat)", "Android 5.0 (Lollipop)", "Android 6.0 (Marshmallow)", "Android 7.0 (Nougat)", "Android 8.0 (Oreo)", "Android 9.0 (Pie)", "Android 10", "Android 11"
        )
        private val androidAPILevelsArray = arrayListOf<String>(
                "API 1", "API 2", "API 3", "API 4", "API 5", "API 8", "API 9", "API 11", "API 14", "API 16", "API 19", "API 21", "API 23", "API 24", "API 26", "API 28", "API 29", "API 30"
        )

        override fun getCount(): Int {
            //no of rows
            return androidVersionsArray.size

        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return ""
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            val rowMain: View
            if (convertView == null) {
                val layoutInflater = LayoutInflater.from(viewGroup!!.context)
                rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)
                val viewHolder = ViewHolder(rowMain.version_textLabel, rowMain.api_textLabel)
                rowMain.tag = viewHolder
            } else {
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder
            viewHolder.nameTextView.text = androidVersionsArray.get(position)
            viewHolder.apiTextView.text = androidAPILevelsArray.get(position)

            // viewHolder.positionTextView.text =  androidVersionsArray.get(position)
            return rowMain
        }

        private class ViewHolder(val nameTextView: TextView, val apiTextView: TextView)

    }
}
