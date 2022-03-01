package com.example.myapplication.utils


import android.content.Context
import android.content.SharedPreferences

class Shared_Common_Pref(var _context: Context) {
    var Common_pref: SharedPreferences
    var editor: SharedPreferences.Editor
    fun save(key: String?, value: String?) {
        editor.putString(key, value)
        editor.commit()
    }

    fun getvalue(key: String?): String? {
        return Common_pref.getString(key, "")
    }

    companion object {
        var name = "name"
    }

    init {
        Common_pref = _context.getSharedPreferences("Preference_values", Context.MODE_PRIVATE)
        editor = Common_pref.edit()
    }
}