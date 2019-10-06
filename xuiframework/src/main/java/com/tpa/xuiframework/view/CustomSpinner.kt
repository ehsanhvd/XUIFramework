package com.tpa.xuiframework.view

import android.content.Context
import android.support.annotation.ArrayRes
import android.support.annotation.LayoutRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.tpa.xuiframework.R
import org.jetbrains.anko.custom.ankoView


public class CustomSpinner<V> : Spinner {

    private var adapter: SpinnerAdapter<V>? = null
    private var items: List<V> = ArrayList()
    private var render: ((View, V, Int) -> Unit) = { view: View, v: V, i: Int ->

        val textTitle = view.findViewById<TextView>(R.id.textTitle)
        if (textTitle != null) {
            textTitle.setText(v.toString())
        }
    }

    var attrs: AttributeSet? = null
    var defStyleAttr: Int = 0

    @LayoutRes
    private var defaultItem = R.layout.spinner_dropdown_item
    @LayoutRes
    private var dropDownItem = R.layout.spinner_dropdown_item


    constructor(context: Context) : super(context) {
    }

    constructor(
        context: Context,
        item: List<V>,
        render: ((View, V, Int) -> Unit)? = null
    ) : super(context) {

        if (render != null) {
            set(item, render)
        } else {
            set(item)
        }
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.attrs = attrs
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        this.attrs = attrs
        this.defStyleAttr = defStyleAttr
    }

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.CustomSpinner, defStyleAttr, 0)
        defaultItem = ta.getResourceId(R.styleable.CustomSpinner_defaultItem, this.defaultItem)
        dropDownItem = ta.getResourceId(R.styleable.CustomSpinner_dropdownItem, this.dropDownItem)

        ta.recycle()
    }

    fun set(item: List<V>, render: ((View, V, Int) -> Unit)) {
        items = item
        this.render = render;

        setAdapter(SpinnerAdapter(context, items))
    }

    fun set(item: List<V>) {
        items = item

        setAdapter(SpinnerAdapter(context, items))
    }

    fun getChoosenItemIndex(): Int {
        return getSelectedItemPosition()
    }

    operator fun get(index: Int): V {
        return items.get(index)
    }

    fun getItems(): List<V> {
        return items
    }

    fun remove(index: Int) {
        items.drop(index)
        adapter?.notifyDataSetChanged()
    }


    private inner class SpinnerAdapter<T>(context: Context, list: List<T>) :
        ArrayAdapter<T>(context, 0, list) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            return renderView(defaultItem, position, convertView, parent)
        }

        override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
            return renderView(dropDownItem, position, convertView, parent)
        }

        private fun renderView(
            itemResource: Int,
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {
            var view = convertView
            if (view == null) {
                val inflater =
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflater.inflate(itemResource, parent, false)
            }

            if (render != null) {
                (render!!)(view!!, items.get(position), position)
            }

            return view!!
        }
    }

    fun onRender(render: ((View, V, Int) -> Unit)){
        this.render =render;
    }

    companion object {
        fun withArray(
            context: Context,
            @ArrayRes items: Int,
            render: ((View, String, Int) -> Unit)? = null
        ): CustomSpinner<String> {

            return CustomSpinner(context, context.resources.getStringArray(items).toList(), render)
        }

    }
}

fun <T> ViewManager.customSpinner(
    items: List<T> = arrayListOf()
) = customSpinner<T>(items, {})

fun ViewManager.customSpinner(@ArrayRes items: Int) =
    customSpinner(items, {})

fun <T> ViewManager.customSpinner(
    items: List<T>,
    init: CustomSpinner<T>.() -> Unit
) =
    ankoView({ CustomSpinner(it, items) }, 0, init)

fun ViewManager.customSpinner(
    @ArrayRes items: Int,
    init: CustomSpinner<String>.() -> Unit
) =
    ankoView({ CustomSpinner.withArray(it, items, null) }, 0, init)