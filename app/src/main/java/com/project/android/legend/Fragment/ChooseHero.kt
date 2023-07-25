package com.project.android.legend.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.geomain.R
import com.bignerdranch.android.geomain.databinding.ChooseHeroFragmentBinding
import com.project.android.legend.DataClass.Hero
import com.project.android.legend.Adapter.HeroAdapter
import com.project.android.legend.Model.QuizViewModel
import com.project.android.legend.Interface.SelectedHero

class ChooseHero: DialogFragment (), HeroAdapter.Listener {

    private lateinit var binding: ChooseHeroFragmentBinding
    private lateinit var adapter: HeroAdapter
    private val model: QuizViewModel by lazy {
        ViewModelProvider(requireActivity())[QuizViewModel::class.java]
    }

    private lateinit var mCallBack: SelectedHero

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ChooseHeroFragmentBinding.inflate(inflater, container, false)
        mCallBack = activity as SelectedHero
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
        model.liveHero.value = model.getHero()
        model.liveHero.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        if(model.getQuestionBank().size<3) binding.back.isEnabled = false
    }

    private fun initRcView() = with(binding) {
        adapter = HeroAdapter(this@ChooseHero)
        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        binding.back.setOnClickListener {
            onDestroyView()
        }
    }

    override fun getTheme(): Int {
        return R.style.Theme_GeoQuiz_Fullscreen
    }

    override fun onClick(item: Hero) {
        mCallBack.clickHero(item.id)
        Log.d("MyLog", "Hero question: ${item.question}")
        onDestroyView()
    }
}