package com.dicoding.techtest2gli

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dicoding.techtest2gli.databinding.ItemLayoutBinding
import com.dicoding.techtest2gli.model.Student

class StudentAdapter(private val students : List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(val binding : ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(listStudent : Student){
            binding.apply {
                Glide.with(itemView)
                    .load(listStudent.photoUrl)
                    .into(imgStudent)
                tvStudentName.text = listStudent.name
                tvStudentAddress.text = listStudent.address
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return StudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentStudent = students[position]
        holder.bind(currentStudent)
    }
}
