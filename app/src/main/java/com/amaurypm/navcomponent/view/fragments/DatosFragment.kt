package com.amaurypm.navcomponent.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.amaurypm.navcomponent.R
import com.amaurypm.navcomponent.databinding.FragmentDatosBinding


class DatosFragment : Fragment() {

    private var _binding: FragmentDatosBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDatosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val name = arguments?.getString("name", "")
        //val mobile = arguments?.getLong("mobile", 0)

        //Toast.makeText(requireActivity(), "Usuario: $name, Teléfono: $mobile", Toast.LENGTH_LONG).show()

        val args: DatosFragmentArgs by navArgs()

        val name = args.name
        val mobile = args.mobile
        val usuario = args.usuario

        /*binding.tvName.text = name
        binding.tvMobile.text = mobile.toString()*/

        binding.tvName.text = usuario?.name
        binding.tvMobile.text = usuario?.mobile.toString()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}