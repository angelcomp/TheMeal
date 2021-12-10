package br.com.angelcomp.themeal.presenter.view
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import br.com.angelcomp.themeal.databinding.DialogMealBinding
import br.com.angelcomp.themeal.presenter.model.CategoryUiModel
import coil.load

class DialogFragment(private val category: CategoryUiModel): DialogFragment() {

    private lateinit var binding: DialogMealBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivThumb.load(category.thumb)
        binding.tvDescription.text = category.description
        binding.tvName.text = category.name
        binding.ivExit.setOnClickListener {
            dismiss()
        }
    }
}