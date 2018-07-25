import io.reactivex.Completable
import java.time.Instant
import java.time.ZoneId

private fun testCreate() {
    Completable.create {
        println(System.currentTimeMillis())
        it.onComplete()
    }.subscribe()
}

private fun testSimpleCase() {
    showTime().subscribe()
}


private fun testAndThen() {
    showTime()
        .andThen(showTime())
        .subscribe()
}

fun main(args: Array<String>) {
    testAndThen()
}

private fun showMilliseconds(): Completable =
    Completable.create {
        println(System.currentTimeMillis())
        it.onComplete()
    }

private fun showTime(): Completable =
    Completable.fromAction {
        val time = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalTime()
        println(time)
    }
