package com.shechkov.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

interface Communication {

    interface Observe<T> {
        fun observe(owner: LifecycleOwner, observer: Observer<T>)
    }

    interface Update<T> {
        fun setValue(data: T)
    }

    abstract class Abstract<T : Any>(
        protected val mutableLiveData: MutableLiveData<T>
    ) : Observe<T>, Update<T> {

        override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
            mutableLiveData.observe(owner, observer)
        }

    }

    abstract class UiUpdate<T : Any>(
        liveData: MutableLiveData<T> = MutableLiveData()
    ) : Abstract<T>(liveData) {
        override fun setValue(data: T) {
            mutableLiveData.value = data
        }
    }

    abstract class PostUpdate<T : Any>(
        liveData: MutableLiveData<T> = MutableLiveData()
    ) : Abstract<T>(liveData) {

        override fun setValue(data: T) = mutableLiveData.postValue(data)
    }

    abstract class SingleUiUpdate<T : Any> : UiUpdate<T>(SingleLiveEvent())

    abstract class SinglePostUpdate<T : Any> : PostUpdate<T>(SingleLiveEvent())
}