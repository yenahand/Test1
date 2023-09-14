package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val todos = listOf(
        Todo("make bootcamp~~ #1",false),
        Todo("make bootcamp~~ #2",false),
        Todo("make bootcamp~~ #3",false),
        Todo("make bootcamp~~ #4",false),
        Todo("make bootcamp~~ #5",false),
        Todo("make bootcamp~~ #6",false),
        Todo("make bootcamp~~ #7",false),
        Todo("make bootcamp~~ #8",false),
        Todo("make bootcamp~~ #9",false),
        Todo("make bootcamp~~ #10",false),
        Todo("make bootcamp~~ #11",false),
        Todo("make bootcamp~~ #12",false),
        Todo("make bootcamp~~ #13",false),
        Todo("make bootcamp~~ #14",false),
        Todo("make bootcamp~~ #15",false),
        Todo("make bootcamp~~ #16",false),



    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initalizeViews()
    }

    private fun initalizeViews(){
        binding.todoList.layoutManager = LinearLayoutManager(this) // 어떻게 리스트를 배치할건지
        binding.todoList.adapter = TodoAdapter(todos)// 값을 넣어주는 어댑
        binding.clearButton.setOnClickListener {
            (binding.todoList.adapter as? TodoAdapter)?.clearAll()
        }
    }
}