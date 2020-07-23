# CryptoTracker

> Crypto tracker app

## Screenshots

<p align="middle">
  <img width="200" src="https://github.com/SpiralDevelopment/CryptoTracker/blob/master/screenshots/sc3.jpg">
  <img width="200" src="https://github.com/SpiralDevelopment/CryptoTracker/blob/master/screenshots/sc2.jpg">
  <img width="200" src="https://github.com/SpiralDevelopment/CryptoTracker/blob/master/screenshots/sc1.jpg">
  <img width="200" src="https://github.com/SpiralDevelopment/CryptoTracker/blob/master/screenshots/sc4.jpg">
</p>

## Architecture
MVVM (Model - ViewModel - View) is the design pattern used for making this app. 
MVVM provides a clear separation of concern and has great support in Android SDK in the form of [Architecture Components][1].

## Libraries Used

* [Architecture][1] - A collection of libraries that help you design robust, testable, and
  maintainable apps.
  * [Data Binding][2] - Declaratively bind observable data to UI elements.
  * [LiveData][3] - Build data objects that notify views when the underlying database changes.
  * [Room][4] - Access your app's SQLite database with in-app objects and compile-time checks.
  * [ViewModel][5] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
     asynchronous tasks for optimal execution.
  * [Dagger][6] - For Dependeny Injection 
  * [Navigation][12] - Handle everything needed for in-app navigation.
* Third party
  * [Glide][7] for image loading
  * [Kotlin Coroutines][8] for managing background threads with simplified code and reducing needs for callbacks
  * [MPAndroidChart][9] to chart the financial data
  * [Retrofit][10] for making HTTP requests


[1]: https://developer.android.com/jetpack/arch/
[2]: https://developer.android.com/topic/libraries/data-binding/
[3]: https://developer.android.com/topic/libraries/architecture/livedata
[4]: https://developer.android.com/topic/libraries/architecture/room
[5]: https://developer.android.com/topic/libraries/architecture/viewmodel
[6]: https://developer.android.com/training/dependency-injection/dagger-android
[7]: https://bumptech.github.io/glide/
[8]: https://kotlinlang.org/docs/reference/coroutines-overview.html
[9]: https://github.com/PhilJay/MPAndroidChart
[10]: https://github.com/square/retrofit
[11]: https://developer.android.com/training/dependency-injection/hilt-android
[12]: https://developer.android.com/topic/libraries/architecture/navigation/

## Variations

There are 2 versions of this project. One uses [dagger-android][6] for dependency injection, another one uses [dagger-hilt][11]. You see that dependency injection with dagger-hilt is simpler.

|     Sample     | Description |
| ------------- | ------------- |
| [dagger-hilt](https://github.com/SpiralDevelopment/CryptoTracker/tree/master) | Dagger Hilt version |
| [dagger-android](https://github.com/SpiralDevelopment/CryptoTracker/tree/dagger-android) | Dagger Android version


## Support

If you like my work, feel free to support it!

* **BTC:** 1PUGs6mxcW2W3SJi95aG8GvRQRJsoFHWWQ

* **ETH:** 0x66615e09f7f46429e7620ffbf78479879bbab41d

* **LTC:** LRxYMgEXMumwxYdimZo9EJ5CfBcipD5c3n

