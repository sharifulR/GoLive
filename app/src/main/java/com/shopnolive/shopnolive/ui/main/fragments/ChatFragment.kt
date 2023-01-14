package com.shopnolive.shopnolive.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shopnolive.shopnolive.adapter.ChatViewPagerAdapter
import com.shopnolive.shopnolive.databinding.FragmentChatBinding
import com.shopnolive.shopnolive.ui.chat.ChatListFragment

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tabLayout.setupWithViewPager(binding.viewPagerChat)

        val chatViewPagerAdapter = ChatViewPagerAdapter(childFragmentManager, 0)
        chatViewPagerAdapter.addFragments(ChatListFragment(), "Messages")
//        chatViewPagerAdapter.addFragments(GroupChatListFragment(), "Groups")

        binding.viewPagerChat.adapter = chatViewPagerAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}