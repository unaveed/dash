package com.umair.app.doordash.datasource.network.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxSchedulerProvider : SchedulerProvider {
    override fun getUIScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun getIOScheduler(): Scheduler {
        return Schedulers.io()
    }
}