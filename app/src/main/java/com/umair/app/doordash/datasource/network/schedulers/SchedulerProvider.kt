package com.umair.app.doordash.datasource.network.schedulers

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun getUIScheduler(): Scheduler
    fun getIOScheduler(): Scheduler
}