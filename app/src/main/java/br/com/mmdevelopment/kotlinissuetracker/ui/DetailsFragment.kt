package br.com.mmdevelopment.kotlinissuetracker.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.mmdevelopment.kotlinissuetracker.R
import br.com.mmdevelopment.kotlinissuetracker.databinding.FragmentDetailsBinding
import com.bumptech.glide.Glide

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args by lazy { DetailsFragmentArgs.fromBundle(requireArguments()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        populateData()
        insertListeners()
        return binding.root
    }

    private fun populateData() {
        binding.apply {
            tvBody.movementMethod = ScrollingMovementMethod()
            tvTitle.movementMethod = ScrollingMovementMethod()

            tvTitle.text = args.item.title
            tvCreated.text = (args.item.created_at).substringBefore("T")
            tvBody.text = args.item.body

            Glide.with(binding.root.context).load(args.item.user.avatar_url).into(ivAvatar)
        }
    }

    private fun insertListeners() {
        binding.btnView.setOnClickListener {
            Intent(Intent.ACTION_VIEW, Uri.parse(args.item.pull_request.html_url)).also {
                startActivity(it)
            }
        }
    }
}