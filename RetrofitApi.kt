# interface RetrofitApi {
    //'@Headers' 设置固定请求头 所有请求头不会i相互覆盖
    @Headers("Cache-Control: max-age= 10000")
    @GET("project/xxx")
    fun exmaple(): Call<ResponseBody>

    /*'@Header' 动态更新请求头*/
    @GET("project/xxx")
    fun exmaple2(@Header("Authorization") authorization: String): Call<ResponseBody>

    @POST("xxx")
    fun exmaple3(
        @Field("name") vararg name: String,
        @Field("array") array: ArrayList<String>,
        @FieldMap map: Map<String, String>
    ): Call<ResponseBody>

    @GET("project/{id}/list")
    fun exmaple4(@Path("id")id:Int):Call<ResponseBody>

    
    @HTTP(method = "get",path = "project/tree/json",hasBody = false)
    fun example():Call<ResponseBody>

    /* '@Streaming'返回的数据很大  如下载大文件*/
    @Streaming
    @GET
    fun downloadFile(@Url fileUel:String):Call<ResponseBody>



/*
* ---------标记类
*   @FormUrlEncoded   Form表单
    @Multipart          文件上传
    @Streaming          流形式返回
*
* */
}


class upload {
/*--------------单文件上传--------------------*/
    private fun testUpload() {
        val file = File("")
        val requestBody= RequestBody.create(MediaType.parse("image/png"),file)
        val filePath= MultipartBody.Part.createFormData("上传的Key",
        file.name,requestBody)

        val call = wanAndroidApi.upload2()
        call.execute()
    }

/*--------------多个文件上传--------------------*/
private fun testUpload2() {
    val files = listOf<File>()
    val map = mutableMapOf<String, RequestBody>()
    files.forEach {
        file -> val requestBody = RequestBody.create(MediaType.parse("image/png"),file)
        map["file\",filename\"test.png"] = requestBody
    }
    wanAndroidApi.upload2(map)
}

/*
*     @Multipart
    @POST("project/upload")
    fun upload3(@PartMap map:Map<String,RequestBody>):Call<RequestBody>
*
*     @Multipart
    @POST("project/upload")
    fun upload3(@PartMap map:Map<String,RequestBody.Part>):Call<RequestBody>
*
* */

}
