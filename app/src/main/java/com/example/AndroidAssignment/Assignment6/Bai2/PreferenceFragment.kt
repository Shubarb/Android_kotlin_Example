package com.example.AndroidAssignment.Assignment6.Bai2

import android.os.Bundle
import android.util.Log
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.kotlinassignment.R

class PreferenceFragment: PreferenceFragmentCompat(){
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preference_fragment)
        val mPreference = preferenceScreen.findPreference<Preference>("edit_text")as EditTextPreference?

        val preferenceChangeListener: Preference.OnPreferenceChangeListener =
            Preference.OnPreferenceChangeListener {_,newValue ->
                Log.d("aaa",newValue.toString())
                true
            }
        mPreference?.onPreferenceChangeListener = preferenceChangeListener
    }
}