package com.amaurypm.navcomponent.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.amaurypm.navcomponent.R
import com.amaurypm.navcomponent.databinding.FragmentDatosBinding
import com.amaurypm.navcomponent.databinding.FragmentFormularioBinding
import com.amaurypm.navcomponent.model.Usuario

class FormularioFragment : Fragment() {

    private var _binding: FragmentFormularioBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFormularioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnVerifyDetails.setOnClickListener {

            val name = binding.tietName.text.toString()
            val mobile = binding.tietMobile.text.toString()

            when{
                name.isEmpty() -> {
                    Toast.makeText(requireActivity(), "Ingresa un nombre", Toast.LENGTH_SHORT).show()
                }
                mobile.isEmpty() -> {
                    Toast.makeText(requireActivity(), "Ingresa un número telefónico", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    /*val bundle = Bundle()
                    bundle.putString("name", name)
                    bundle.putLong("mobile", mobile.toLong())*/

                    val bundle = bundleOf(
                        "name" to name,
                        "mobile" to mobile.toLong()
                    )

                    val usuario = Usuario(name, mobile.toLong())

                    //findNavController().navigate(R.id.action_formularioFragment_to_datosFragment, bundle)

                    findNavController().navigate(FormularioFragmentDirections.actionFormularioFragmentToDatosFragment(
                         name,
                         mobile.toLong(),
                         usuario
                    ))

                }

            }


        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}