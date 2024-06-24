package com.moneyforward.github.user.ui.user.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moneyforward.github.user.data.model.User
import com.moneyforward.github.user.domain.usecase.GetUserListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    val getUserListUseCase: GetUserListUseCase
) : ViewModel() {

    private val _userList = MutableLiveData<List<User>>()

    val userList: MutableLiveData<List<User>> = _userList

    fun getUserList(query: String) {
        viewModelScope.launch {
            getUserListUseCase(query)
                .catch { throwable ->
                    Log.d(UserListViewModel::class.java.name, throwable.toString())
                }.collect { users ->
                    _userList.value = users
                }
        }
    }
}
