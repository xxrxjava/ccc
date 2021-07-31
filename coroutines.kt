fun main() {
    GlobalScope.launch {
        val e = async { SuspendFunctions.add(1, 3) }
        val f = async { SuspendFunctions.sadd(4, 6) }
        print(e.await() + f.await())
    }
    readLine()
}

object SuspendFunctions {
    suspend fun add(a: Int, b: Int): Int {
        return withContext(Dispatchers.Default) {
            delay(2000)
            a + b
        }
    }

    suspend fun sadd(a: Int, b: Int): Int {
        return withContext(Dispatchers.Default) {
            delay(4000)
            a + b
        }
    }
}

        lifecyclescope 
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.1"
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.1'
