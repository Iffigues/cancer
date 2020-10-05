package com.example.cancer

import android.annotation.TargetApi
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage
import android.widget.Toast


class MyReceiver : BroadcastReceiver() {
    private val TAG: String = com.example.cancer.MyReceiver::class.java.simpleName
    val pdu_type = "pdus"

    @TargetApi(Build.VERSION_CODES.M)
    override fun onReceive(context: Context?, intent: Intent) {
        val bundle = intent.extras
        val msgs: Array<SmsMessage?>
        var strMessage = ""
        val format = bundle!!.getString("format")
        val pdus = bundle[pdu_type] as Array<Any>?

        if (pdus != null) {
            val isVersionM = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
            msgs = arrayOfNulls<SmsMessage>(pdus.size)
            for (i in msgs.indices) {
                if (isVersionM) {
                    msgs[i] = SmsMessage.createFromPdu(pdus[i] as ByteArray, format)
                } else {
                    msgs[i] = SmsMessage.createFromPdu(pdus[i] as ByteArray)
                }
                onMessage(msgs[i], context)
            }
        }

    }


    private fun onMessage(smsMessage: SmsMessage?, Context: Context?) {
        var t = Call()
        val i = Intent("SMS_RECEIVED_ACTION")
        //val intent:Intent = Intent()
        //i.action = "CUSTOM_INTENT"
        if (Context != null) {
            if (smsMessage != null) {
                i.putExtra("message", smsMessage.messageBody)
                var ee = smsMessage.originatingAddress?.let { t.getTel(Context, it) }
                if (ee != null) {
                    var strMessage = ""
                    strMessage += "SMS from " + (smsMessage.originatingAddress ?: null)
                    strMessage += """ :${smsMessage.messageBody}"""
                    Toast.makeText(Context, strMessage, Toast.LENGTH_LONG).show()
                    i.putExtra("uid", ee.uid)
                }
                Context.sendBroadcast(i)
            }

        }
        if (smsMessage != null) {
            var ee = smsMessage.originatingAddress?.let { t.getTel(Context as Context, it) }
            //Toast.makeText(Context as Context, "strMessage", Toast.LENGTH_LONG).show()
            if (ee != null) {
                if (Context != null) {
                    t.sendMessages(Context, smsMessage.messageBody, "OTHER", ee.uid)
                }
            }
        }
    }
}
