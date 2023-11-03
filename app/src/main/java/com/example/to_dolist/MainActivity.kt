package com.example.to_dolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var taskInput: EditText
    private lateinit var addTaskButton: Button
    private lateinit var taskList: ListView

    private val tasks = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskInput = findViewById(R.id.taskInput)
        addTaskButton = findViewById(R.id.addTaskButton)
        taskList = findViewById(R.id.taskList)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        taskList.adapter = adapter

        addTaskButton.setOnClickListener {
            val task = taskInput.text.toString()
            if (task.isNotBlank()) {
                tasks.add(task)
                adapter.notifyDataSetChanged()
                taskInput.text.clear()
            }
        }

        taskList.setOnItemClickListener { _, _, position, _ ->
            tasks.removeAt(position)
            adapter.notifyDataSetChanged()
        }
    }
}