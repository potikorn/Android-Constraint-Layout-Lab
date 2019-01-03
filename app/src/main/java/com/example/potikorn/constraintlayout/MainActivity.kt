package com.example.potikorn.constraintlayout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_main_menu.view.*

class MainActivity : AppCompatActivity() {

    private val simpleMenuAdapter: SimpleMenuAdapter by lazy { SimpleMenuAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvSimpleMenu.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = simpleMenuAdapter.apply {
                setItems(getMenuItems())
            }
        }
    }

    private fun getMenuItems(): MutableList<String> {
        return mutableListOf(
            "Circular Positioning",
            "Percents",
            "Barriers",
            "Group",
            "Place Holder"
        )
    }

    class SimpleMenuAdapter : RecyclerView.Adapter<SimpleMenuAdapter.SimpleMenuViewHolder>() {

        private val menuList = mutableListOf<String>()

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SimpleMenuViewHolder {
            return SimpleMenuViewHolder(
                LayoutInflater.from(p0.context).inflate(R.layout.item_main_menu, p0, false)
            )
        }

        override fun getItemCount(): Int = menuList.size

        override fun onBindViewHolder(p0: SimpleMenuViewHolder, p1: Int) {
            return p0.onBindData(menuList[p1])
        }

        fun setItems(menuItems: MutableList<String>) {
            menuList.apply {
                clear()
                addAll(menuItems)
            }
            notifyDataSetChanged()
        }

        inner class SimpleMenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            fun onBindData(menu: String) {
                itemView.apply {
                    tvMenu.text = menu
                    setOnClickListener { navigateTo(adapterPosition) }
                    background = when (adapterPosition % 2 == 0) {
                        true -> ContextCompat.getDrawable(itemView.context, android.R.color.darker_gray)
                        false -> ContextCompat.getDrawable(itemView.context, android.R.color.white)
                    }
                }
            }

            private fun navigateTo(position: Int) {
                when (position) {
                    0 -> itemView.context.startActivity(
                        Intent(itemView.context, CircularPositioningActivity::class.java)
                    )
                    1 -> itemView.context.startActivity(
                        Intent(itemView.context, PercentsActivity::class.java)
                    )
                    2 -> itemView.context.startActivity(
                        Intent(itemView.context, BarriersActivity::class.java)
                    )
                    3 -> itemView.context.startActivity(
                        Intent(itemView.context, GroupActivity::class.java)
                    )
                    4 -> itemView.context.startActivity(
                        Intent(itemView.context, PlaceHolderActivity::class.java)
                    )
                }
            }
        }
    }
}
