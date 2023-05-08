package com.example.myapplication.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.example.myapplication.database.CompaniesEntity
import com.example.myapplication.repository.CompaniesBean
import com.example.myapplication.repository.TempRepository
import com.example.myapplication.tools.extentions.launchCatching
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val tempRepository: TempRepository ) : ViewModel(){

    private val _displayVO = MutableLiveData<List<CompaniesVO>>()
    val displayVO: LiveData<List<CompaniesVO>> = _displayVO

    fun fire() {
        viewModelScope.launch {
            launchCatching {
                val content = tempRepository.getNewListing()
                content.stateIn(viewModelScope).collect{
                    val displayVO = it.map { companiesEntity->
                        companiesEntity.adapt()
                    }

                    _displayVO.value = displayVO
                    Log.e("displayVO",displayVO.size.toString())
                }
            } .onFailure {
                Log.e("companies",it.message.toString())
            }
        }
    }
    data class CompaniesVO(val companiesName : String)


    private fun CompaniesEntity.adapt(): CompaniesVO {
        return CompaniesVO( companiesName = company   )
    }
}