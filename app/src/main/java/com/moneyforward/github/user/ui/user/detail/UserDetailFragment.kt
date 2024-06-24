package com.moneyforward.github.user.ui.user.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.moneyforward.github.user.databinding.FragmentUserDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private lateinit var binding: FragmentUserDetailBinding
    private lateinit var adapter: UserDetailAdapter

    private val viewModel: UserDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UserDetailAdapter()
        binding.userDetailList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        binding.userDetailList.adapter = adapter

        viewModel.detailList.observe(viewLifecycleOwner) { detailList ->
            adapter.submitList(detailList)
        }

        arguments?.getString(USER_LOGIN)?.let { login ->
            viewModel.getUserDetail(login)
        }
    }

    companion object {
        const val USER_LOGIN = "user_login"
    }
}
