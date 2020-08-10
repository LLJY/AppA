package com.example.appa

import android.util.Log
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONObject

class Repository {
    private var fcm_key = "AAAAhzCLcXw:APA91bETjOwT10SvrsVCL1QeH131JzAAS_PKqk-rOHMWoBzZKFBxgoiwbUbiFYan7UEBS6idaNO_mYb4oGekTLma4R39QNwhUQeFNKCh5_QBPZ0NKHIni-MSjcbCDvJcGccAD6vb7ZWV";
    suspend fun sendMessage(){

    }

    suspend fun sendMessageDirect(message: String){
        var data = JSONObject()
        data.put("title", "Some Title")
        data.put("message", message)
        var url = "https://fcm.googleapis.com/fcm/send"
        var client = OkHttpClient()
//        var formBody = MultipartBody.Builder()
//            .setType(MultipartBody.FORM)
//            .addFormDataPart("condition", "'topic' in topics")
//            .addFormDataPart("data", "data")
//            .build()
       val json =  "{\n" +
                "  \"condition\": \"'topic' in topics\",\n" +
                "  \"data\": {\n" +
                "    \"title\": \"Some Title\",\n" +
                "    \"message\": \"$message\"\n" +
                "  }\n" +
                "}"
        val body = RequestBody.create("application/json".toMediaTypeOrNull(), json)
        Log.d("lol",body?.toString())
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "key=$fcm_key")
            .addHeader("Content-Type","application/json")
            .post(body)
            .build()
        // suspend function that we're calling in a coroutine anyway, doesn't matter.
        var result = client.newCall(request).execute()
        Log.d("lol",result.body?.string())
    }
}
