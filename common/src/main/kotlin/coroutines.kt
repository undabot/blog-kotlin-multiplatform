import kotlin.coroutines.experimental.CoroutineContext
import kotlin.properties.Delegates.notNull
import kotlinx.coroutines.experimental.*

var coroutineContext: CoroutineContext by notNull()

fun launchCancellable(block: suspend () -> Unit): CancellableJob {
    val job = launch(coroutineContext) {
        block()
    }
    return object : CancellableJob {
        override fun cancel() {
            if (job.isActive) job.cancel()
        }
    }
}