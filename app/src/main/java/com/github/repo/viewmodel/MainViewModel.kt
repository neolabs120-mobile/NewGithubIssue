package com.github.repo.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.github.repo.model.Example
import com.github.repo.others.Resource
import com.github.repo.repsitory.MainRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(val mainRepository: MainRepository) : ViewModel() {

    private val _res = MutableLiveData<Resource<List<Example>>>()

    val res : LiveData<Resource<List<Example>>>
        get() = _res

    fun getIssue(org: String, repo: String) {
        _res.postValue(Resource.loading(null))
        viewModelScope.launch {
            mainRepository.getEmployee(repo, org).let {
                if (it.isSuccessful){
                    _res.postValue(Resource.success(it.body()))
                    Log.d("whathow", it.body().toString())
                }else{
                    _res.postValue(Resource.error(it.errorBody().toString(), null))
                    Log.d("whathow", it.errorBody().toString())
                }
            }
        }
    }
}