package com.example.yourparkingtestapplication.models

import android.content.Intent

sealed class ActivityEvent {
    class StartActivityEvent(val clazz: Class<*>, val intent: Intent? = null): ActivityEvent()
    class FinishActivityEvent: ActivityEvent()
}