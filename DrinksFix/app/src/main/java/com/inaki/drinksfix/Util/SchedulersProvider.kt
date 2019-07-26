package com.inaki.drinksfix.Util

import io.reactivex.*

class SchedulerProvider(private val backgroundScheduler: Scheduler, private val foregroundScheduler: Scheduler) {

    fun <T> getSchedulersForObservable(): (Observable<T>) -> Observable<T> {
        return {observable: Observable<T> ->
            observable.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
        }
    }

    fun <T> getSchedulerForSingle(): (Single<T>) -> Single<T> {
        return {single: Single<T> ->
            single.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
        }
    }

    fun getSchedulerForCompletable(): (Completable) -> Completable {
        return {completable: Completable ->
            completable.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
        }
    }

    fun <T> getSchedulersForFlowable(): (Flowable<T>) -> Flowable<T> {
        return {flowable: Flowable<T> ->
            flowable.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
        }
    }
}