package com.example.locationtrackingapplication

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.locationtrackingapplication.databinding.ActivityLocationListBinding

class LocationListActivity : AppCompatActivity() {

    lateinit var binding: ActivityLocationListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_location_list)

        initialization()

    }

    private fun initialization() {

        supportActionBar!!.setTitle("Location List")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);

        val database = LocationsDatabase.getDatabase(this)

        database.locationsDao().getLocationList().observe(this, Observer {
            val photoAdapter = LocationListAdapter(this,it)
            binding.rvLocation.adapter = photoAdapter
            binding.rvLocation.layoutManager = LinearLayoutManager(this)
        })
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

}