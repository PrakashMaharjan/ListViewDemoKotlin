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

    fun setUpListView(){
        val listView = findViewById<ListView>(R.id.myListView)
        listView.adapter = MyCustomAdapter()
    }



        private class MyCustomAdapter: BaseAdapter(){

        private val androidVersionsArray = arrayListOf<String>(
                "Android 1.0", "Petit Four", "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "Kitkat", "Lollipop","Marshmallow", "Nougat", "Oreo", "Pie", "Android 10", "Android 11"
        )

        override fun getCount(): Int {
            //no of rows
            return androidVersionsArray.size

        }
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getItem(position: Int): Any {
            return  ""
        }
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            val rowMain: View
            if (convertView == null ){
                val layoutInflater = LayoutInflater.from(viewGroup!!.context)
                rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)
                val viewHolder = ViewHolder(rowMain.textLabel)
                rowMain.tag = viewHolder
            }
            else{
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder
            viewHolder.nameTextView.text =  androidVersionsArray.get(position)
           // viewHolder.positionTextView.text =  androidVersionsArray.get(position)
            return  rowMain
        }

        private class ViewHolder(val nameTextView: TextView)

    }
}
