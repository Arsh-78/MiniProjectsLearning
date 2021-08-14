package com.example.notesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class NotesList : Fragment() {


    val application= NotessApplication()
    private val noteViewModel: NoteViewModel by activityViewModels {


        NoteViewModelFactory(application.repository)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = NotesListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        noteViewModel.allNotes.observe(viewLifecycleOwner, Observer { notes ->
            // Update the cached copy of the words in the adapter.
            notes?.let { adapter.submitList(it) }
        })

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {

            view.findNavController().navigate(R.id.action_notesList_to_newNoteFragment)
            setFragmentResultListener("requestKey") { requestKey, bundle ->
                // We use a String here, but any type that can be put in a Bundle is supported
                val result = bundle.getString("bundleKey")
                onFragresult(result)
            }

        }

    }

    private fun onFragresult(result: String?) {
        if(result==null)
        {
            Toast.makeText(
                activity,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
        else
        {
            val note = Note(result)
            noteViewModel.insert(note)
        }

    }


}