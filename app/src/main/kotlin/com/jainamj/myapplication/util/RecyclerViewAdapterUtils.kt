package com.jainamj.myapplication.util

import android.content.Context
import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup

// Following generic adapter class is modified from
// https://gist.github.com/mirrajabi/c70ec2b41b44fbe1c8cbf80771f9a618
abstract class RecyclerViewAdapterUtils<T>(
        val context: Context,
        private val listener: OnViewHolderClick<T>?,
        private var items: MutableList<T>?
) :
        RecyclerView.Adapter<RecyclerViewAdapterUtils<T>.MyViewHolder>() {


    var list: MutableList<T>?
        get() = items
        set(list) {
            items = list
            notifyDataSetChanged()
        }

    protected abstract fun createView(context: Context, viewGroup: ViewGroup, viewType: Int): View

    protected abstract fun bindView(item: T?, viewHolder: MyViewHolder)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(createView(context, viewGroup, viewType), listener)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapterUtils<T>.MyViewHolder, position: Int) {
        bindView(getItem(position), holder)
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    fun getItem(index: Int): T? {
        return if (items != null && index < items!!.size) items!![index] else null
    }

    interface OnViewHolderClick<in T> {
        fun onItemClick(view: View, position: Int, item: T?)
    }

    inner class MyViewHolder internal constructor(
            view: View,
            private var listener: OnViewHolderClick<T>?
    ) :
            RecyclerView.ViewHolder(view), View.OnClickListener {

        private val views: SparseArray<View> = SparseArray()

        init {
            views.put(0, view)
            listener.let { view.setOnClickListener(this) }
        }


        override fun onClick(view: View) {
            listener?.onItemClick(view, adapterPosition, getItem(adapterPosition))
        }


        private fun initViewById(id: Int) {
            getView().findViewById<View>(id)?.let { views.put(id, it) }
        }

        public fun getView(@IdRes id: Int = 0): View {
            when {
                views.get(id) != null -> return views.get(id)
                else -> initViewById(id)
            }

            return views.get(id)
        }
    }

}
