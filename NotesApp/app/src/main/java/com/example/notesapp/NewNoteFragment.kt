package com.example.notesapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController


/**
 * A simple [Fragment] subclass.
 * Use the [NewNoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewNoteFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var editNoteView : EditText = view.findViewById(R.id.edit_word)




        val button = view.findViewById<Button>(R.id.button_save)
        button.setOnClickListener {

            val result:String?

            if (TextUtils.isEmpty(editNoteView.text)) {

                result= null


            } else {
                val note = editNoteView.text.toString()
                 result = note
                // Use the Kotlin extension in the fragment-ktx artifact
                setFragmentResult("requestKey", bundleOf("bundleKey" to result))

            }
            view.findNavController().navigate(R.id.action_newNoteFragment_to_notesList)

        }
    }

}