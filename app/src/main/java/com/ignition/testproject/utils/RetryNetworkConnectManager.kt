package com.ignition.testproject.utils

import io.reactivex.Flowable
import io.reactivex.functions.Function
import org.reactivestreams.Publisher
import retrofit2.HttpException
import java.util.concurrent.TimeUnit

class RetryManager(
        private val retryTimes: Int,
        private var delay: Long,
        private val delayAmount: Long = 1,
        private val httpErrorCodePrefix: Int = 5
) : Function<Flowable<Throwable>, Publisher<*>> {

    private var countRetries = 0
    private val divider = 100

    override fun apply(attempt: Flowable<Throwable>): Publisher<*> {
        return attempt.flatMap { t ->
            val hasRetry = ++countRetries < retryTimes
            val isHttpException = t is HttpException
            val errorCode = if (t is HttpException) t.code() / divider == httpErrorCodePrefix else false

            if (hasRetry && isHttpException && errorCode) {
                delay += delayAmount
                Flowable.timer(delay, TimeUnit.SECONDS)
            } else {
                Flowable.error(t)
            }
        }
    }
}