public class RxJavaBaseUse {



    public static void main(String[] args) {
         Observable<String> observable =getObservable();
//          Observer<String> observer =getOberver();
        observable.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("xc", "accept: "+s);
            }
        });
    }


    public static Observable<String> getObservable() {

      return   Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "大保健";
            }
        });

//        return  Observable.just("大保健","泡吧","撩妹");

//        return  Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(@NotNull ObservableEmitter<String> emitter) throws Exception {
//                emitter.onNext("大保健");
//                emitter.onNext("泡吧！");
//                emitter.onComplete();
//            }
//        });
    }

//    public static Observer<String>  getOberver(){
//        return new Observer<String>() {
//            Disposable dd = null;
//
//            @Override
//
//            public void onSubscribe(@NotNull Disposable d) {
//                dd =d;
//
//                Log.d("xc", "onSubscribe: ");
//            }
//
//            @Override
//            public void onNext(@NotNull String s) {
//                if (s.equals("泡吧！")) {
//                    dd.dispose();
//                }
//                Log.d("xc", "onNext: ");
//            }
//
//            @Override
//            public void onError(@NotNull Throwable e) {
//                Log.d("xc", "onError: ");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d("xc", "onComplete: ");
//            }
//        };
//    }

}

/*----------------kotlin----------------*/
class RxJavabase : AppCompatActivity() {
    private val TAG = "xc"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(view: View) {
//        observable.subscribe(oberver)
    observable.subscribe { s -> Log.d(TAG, "click: $s")
    textView.append(s)
    }


    }

//    val observable: Observable<String>
//        get() = Observable.create { e ->
//            e.onNext("大保健")
//            e.onNext("泡吧！")
//            e.onComplete()
//        }

    val observable:Observable<String>
    get() = Observable.fromCallable{ "大保健"}

//    val observable: Observable<String>
//    get() = Observable.just("大保健", "泡吧", "撩妹")

//    val oberver: Observer<String>
//        get() = object : Observer<String> {
//            override fun onSubscribe(d: Disposable) {
//                Log.d("xc", "onSubscribe: ")
//            }
//
//            override fun onNext(s: String) {
//                Log.d("xc", "onNext: ")
//            }
//
//            override fun onError(e: Throwable) {
//                Log.d("xc", "onError: ")
//            }
//
//            override fun onComplete() {
//                Log.d("xc", "onComplete: ")
//            }
//        }
}
