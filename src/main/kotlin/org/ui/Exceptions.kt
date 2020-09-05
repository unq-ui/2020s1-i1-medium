package org.ui
import java.lang.Exception

class UsedEmail : Exception("Email used")

class RepeatedTitle : Exception("Title used")

class NotFound(msg: String) : Exception("Not found $msg")
