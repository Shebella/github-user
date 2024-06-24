package com.moneyforward.github.user.ui.user.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moneyforward.github.user.domain.usecase.GetUserDetailUseCase
import com.moneyforward.github.user.ui.dto.Detail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userDetailUseCase: GetUserDetailUseCase
) : ViewModel() {

    private val _detailList = MutableLiveData<List<Detail>>()

    val detailList: MutableLiveData<List<Detail>> = _detailList

    fun getUserDetail(username: String) {
        viewModelScope.launch {
            userDetailUseCase(username)
                .catch { throwable ->
                    Log.d(UserDetailViewModel::class.java.name, throwable.toString())
                }
                .collect { detailList ->
                    _detailList.value = detailList
                }
        }
    }
}
