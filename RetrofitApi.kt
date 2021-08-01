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
