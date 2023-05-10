package com.example.myapplication.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.example.myapplication.database.CompaniesEntity
import com.example.myapplication.repository.CompaniesBean
import com.example.myapplication.repository.TempRepository
import com.example.myapplication.tools.extentions.SingleLiveEvent
import com.example.myapplication.tools.extentions.launchCatching
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val tempRepository: TempRepository) : ViewModel() {

    private val _displayVO = MutableLiveData<List<CompaniesVO>>()
    val displayVO: LiveData<List<CompaniesVO>> = _displayVO.distinctUntilChanged()

    val toastMessage = SingleLiveEvent<String>()

    init {
        viewModelScope.launch {
            launchCatching {
                tempRepository.updateNewListing()
                tempRepository.getNewListing().collect {
                    _displayVO.value = it.map { companiesEntity ->
                        companiesEntity.adapt()
                    }
                }
            }.onFailure {
                toastMessage.value = it.message
            }
        }
    }

    fun addNewCompany() {
        viewModelScope.launch {
            tempRepository.addWierdItem()
        }
    }

    data class CompaniesVO(val companiesName: String)


    private fun CompaniesBean.adapt(): CompaniesVO {
        return CompaniesVO(companiesName = company)
    }
}