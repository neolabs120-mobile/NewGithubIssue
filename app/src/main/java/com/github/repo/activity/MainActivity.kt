package com.github.repo.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.repo.R
import com.github.repo.RecyclerViewAdapter
import com.github.repo.databinding.ActivityMainBinding
import com.github.repo.dialog.CustomDialog
import com.github.repo.model.LayoutData
import com.github.repo.others.Status
import com.github.repo.retrofit.GetGihubIssueCallback
import com.github.repo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), GetGihubIssueCallback {
    val mainViewModel : MainViewModel by viewModels()
    val mDatas = mutableListOf<LayoutData>()

    private lateinit var mainbinding: ActivityMainBinding

    private var adapter : RecyclerViewAdapter = RecyclerViewAdapter(this, mDatas)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainbinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel.getIssue("google", "dagger")

        mainViewModel.res.observe(this, Observer{
            when(it.status) {
                Status.SUCCESS -> {
                    mDatas.clear()
                    Log.d("whatis", it.data!!.toString())
                    for(i in 0 until it.data!!.size) {
                        mDatas.add(LayoutData(("#" + it.data.get(i).number + ": " + it.data.get(i).title)))
                    }

                    adapter = RecyclerViewAdapter(this, mDatas)
                    mainbinding.recyclerView.adapter = adapter
                    val lm = LinearLayoutManager(this)
                    mainbinding.recyclerView.layoutManager = lm
                }
                Status.LOADING -> {

                }
                Status.ERROR -> {

                }
            }
        })

        mainbinding.choose.setOnClickListener {
            val customDialog = CustomDialog(this)
            customDialog.callFunction()
        }
    }

    override fun callback(org: String, repo: String) {
        mainViewModel.getIssue(org, repo)
        mainbinding.choose.text = org + " / " + repo
        adapter.notifyDataSetChanged()
    }
}


