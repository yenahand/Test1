package com.example.todolist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTodoBinding
import timber.log.Timber

class TodoAdapter(private val todos: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {


    fun clearAll(){
        todos.forEach{it.completed = true}
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {//10개 호출해서 10개의 뷰 홀더 갯수 만큼 호출 // 어댑터에 context를 주지 않아도 ViewGroup에서 context를 뽑아 쓸 수 있음
        Timber.d("onCreateViewHolder") //뷰를 만든다라는뜻
        val binding =  ItemTodoBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return TodoViewHolder(binding).also { holder ->
            binding.todoCheck.setOnCheckedChangeListener { buttonView, isChecked ->

                Timber.d("checked clicked $isChecked")
                todos.getOrNull(holder.adapterPosition)?.completed = !isChecked
            }
        }


    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {// 자주 호출됨 재사용인것임
        Timber.d("onBindViewHolder $position")
        holder.bind(todos[position])

    }


    override fun getItemCount(): Int =  todos.size // 코틀린의 특성

    class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(todo: Todo){
            binding.rodoTitleText.text = todo.title
            binding.todoCheck.isChecked = todo.completed
        }

    }
}