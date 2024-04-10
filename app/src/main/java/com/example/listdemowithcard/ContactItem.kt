package com.example.listdemowithcard


data class ContactItem(val imageIcon: Int = R.drawable.ic_launcher_foreground,
                       val name: String = "Friend Name",
                       val time:String="12.01hrs",
                       val lastMessage:String= "There could be class next week")
