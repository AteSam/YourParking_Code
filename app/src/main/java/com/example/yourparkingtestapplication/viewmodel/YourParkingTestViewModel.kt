package com.example.yourparkingtestapplication.viewmodel

import androidx.lifecycle.*
import com.example.yourparkingtestapplication.adapter.YourParkingTestAdapter
import com.example.yourparkingtestapplication.models.ActivityEvent
import com.example.yourparkingtestapplication.service.RedditService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Provider

class YourParkingTestViewModel @Inject constructor(
    val adapter: YourParkingTestAdapter,
    private val yourParkingTestRecyclerViewModelProvider: Provider<YourParkingTestRecyclerViewModel>,
    private val redditService: RedditService
) : ViewModel(), LifecycleObserver {

    val activityEvent: LiveData<ActivityEvent>
        get() = mutableActivityEvent

    private val mutableActivityEvent = MutableLiveData<ActivityEvent>()
    private val lifecycleDisposable = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun bindOnCreate() {
        redditService.getRedditPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMapObservable { Observable.fromIterable(it.data.children) }
            .filter { it.data.selftext.isNotBlank() }
            .map {
                yourParkingTestRecyclerViewModelProvider.get().apply { setData(it.data.selftext, "Author: ${it.data.authorFullname}") }
            }
            .toList()
            .subscribe(adapter::setData, Throwable::printStackTrace)
            .disposeOnLifecycle()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun bindOnDestroy() {
        lifecycleDisposable.clear()
    }

    private fun Disposable.disposeOnLifecycle() {
        lifecycleDisposable.add(this)
    }
}