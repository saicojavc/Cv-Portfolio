package com.saico.cvportfolio.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat

fun formatStringResource(input: String): String {
    return input.replace("•", "\n•")
        .trim() // Reemplaza cada '•' por un salto de línea seguido de '•'
}

@SuppressLint("IntentReset", "QueryPermissionsNeeded", "SuspiciousIndentation")
fun Context.sendEmail(
    subject: String? = null,
    message: String? = null,
) {
    val intent = Intent(Intent.ACTION_SENDTO)
        .setType("message/rfc822")
        .setData(Uri.parse("mailto:"))
        .putExtra(Intent.EXTRA_EMAIL, arrayOf("jorgito.avc03@gmail.com"))
        .putExtra(Intent.EXTRA_SUBJECT, subject)
        .putExtra(Intent.EXTRA_TEXT, message)

        startActivity(intent)
}

fun Context.reDirect(
    uri: String
){
    val intent = Intent(Intent.ACTION_VIEW)
        .setData(Uri.parse(uri))

    startActivity(intent)
}