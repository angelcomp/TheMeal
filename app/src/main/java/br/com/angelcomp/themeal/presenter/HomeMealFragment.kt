package br.com.angelcomp.themeal.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.angelcomp.themeal.R
import br.com.angelcomp.themeal.databinding.FragmentHomeMealBinding
import br.com.angelcomp.themeal.presenter.adapter.CategoriesAdapter
import br.com.angelcomp.themeal.presenter.model.CategoryUiModel
import br.com.angelcomp.themeal.presenter.view.DialogFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeMealFragment : Fragment(), CategoriesAdapter.OnItemClickListener {

    private val viewModel: MealViewModel by sharedViewModel()

    private lateinit var binding: FragmentHomeMealBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.categories.observe(viewLifecycleOwner, { listCategoryUiModel ->
            populateMealCategory(listCategoryUiModel)
        })

        viewModel.getCategories()
    }

    private fun populateMealCategory(categories: List<CategoryUiModel>) {
        binding.rvMeals.adapter = CategoriesAdapter(this, categories)
    }

    override fun viewFavoriteDetails(position: Int) {
        val dialog = viewModel.categories.value?.get(position)?.let { DialogFragment(it) }
        dialog?.show(parentFragmentManager, dialog.tag)

    }
}