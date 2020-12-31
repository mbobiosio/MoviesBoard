# MoviesBoard
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/23692417882c4748a27142a667ad3918)](https://app.codacy.com/gh/mbobiosio/MoviesBoard?utm_source=github.com&utm_medium=referral&utm_content=mbobiosio/MoviesBoard&utm_campaign=Badge_Grade)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=mbobiosio_MoviesBoard&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=mbobiosio_MoviesBoard)
[![Build Status](https://app.bitrise.io/app/f153ab3caf794d19/status.svg?token=Lcsa3CZ_Xfe6fRJg3tQL-g&branch=main)](https://app.bitrise.io/app/f153ab3caf794d19)
[![Platform](https://img.shields.io/badge/platform-android-brightgreen)](https://developer.android.com/reference)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://developer.android.com/studio/releases/platforms#5.0)

## Discover the most popular, top rated, upcoming, trending, now playing movies and TV Series. Movies and TV Series data are fetched using themoviedb.org API.

## Screenshots
<img alt="movies_screen" src="https://github.com/mbobiosio/MoviesBoard/raw/main/screenshots/homescreen.png" width="235" height="500"> <img alt="movie_detail_screen" src="https://github.com/mbobiosio/MoviesBoard/blob/main/screenshots/pick_category.png" width="235" height="500">
<img alt="movie_detail_screen" src="https://github.com/mbobiosio/MoviesBoard/blob/main/screenshots/movie_detail.png" width="235" height="500">

## Technical Summary

- [Offline-First](https://applikeysolutions.com/blog/the-offline-first-approach-to-mobile-app-development): The offline-first apps, while still requiring a connection to the servers, don't need a constant internet connection. The data from servers is downloaded to the user's device and can still be accessed offline.
- [Single Source of Truth (SSOT)](https://developer.android.com/jetpack/docs/guide#truth): It is the practice of structuring information models and associated schemata such that every data element is stored exactly once. You can have an offline app and be sure your data always use one source and that is your database.
- [Model-View-ViewModel (MVVM)](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel): It is a software architectural pattern that facilitates the separation of the development of the graphical user interface (without using [DataBinding](https://developer.android.com/topic/libraries/data-binding)). Also, there are [Screen States](/app/src/main/java/com/jaimegc/covid19tracker/ui/base/states/ScreenStates.kt) to handle the different states in the UI.
- [Coroutines](https://developer.android.com/kotlin/coroutines): A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture): Collection of libraries that help you design robust, testable, and maintainable apps.
  - [Navigation](https://developer.android.com/guide/navigation): This component helps you implement navigation.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata): Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel): Stores UI-related data that isn't destroyed on UI changes.
  - [Paging 3](https://developer.android.com/topic/libraries/architecture/paging): The Paging Library helps you load and display small chunks of data at a time. Loading partial data on demand reduces usage of network bandwidth and system resources.
  - [Room](https://developer.android.com/topic/libraries/architecture/room): The library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
    - [DatabaseView](https://developer.android.com/training/data-storage/room/creating-views): This annotation allows you to encapsulate a query into a class. Room refers to these query-backed classes as views, and they behave the same as simple data objects when used in a DAO.
- [Retrofit 2](https://github.com/JakeWharton/retrofit2-kotlinx-serialization-converter): A Retrofit 2 Converter.Factory for Kotlin serialization.
- [Detekt](https://github.com/detekt/detekt): A static code analysis tool for the Kotlin programming language. It operates on the abstract syntax tree provided by the Kotlin compiler.
- [Kotlin Gradle DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html): Gradle's Kotlin DSL provides an alternative syntax to the traditional Groovy DSL with an enhanced editing experience in supported IDEs, with superior content assist, refactoring, documentation, and more.
- [Remal check dependency update](https://plugins.gradle.org/plugin/name.remal.check-dependency-updates): Plugin that provides task for discovering dependency updates.
- [GitHub Actions](https://github.com/features/actions): Automate, customize, and execute your software development workflows right in your repository. Discover, create, and share actions to perform any job, including CI/CD, and combine actions in a completely customized workflow.
- [Moshi](https://github.com/square/moshi) & [Moshi Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/moshi): A modern JSON library for Kotlin and Java. The converter uses Moshi for serialization to and from JSON.
- [Timber](https://github.com/JakeWharton/timber): A logger with a small, extensible API which provides utility on top of Android's normal Log class.
- [PowerSpinner](https://github.com/skydoves/PowerSpinner): A lightweight dropdown popup spinner with a fully customizable arrow and animations.

### Installing
Follow these steps if you want to get a local copy of the project on your machine.

#### 1. Clone or fork the repository by running the command below
```
git clone https://github.com/mbobiosio/MoviesBoard.git
```

## 2. Import the project in AndroidStudio
1.  In Android Studio, go to File -> New -> Import project
2.  Follow the dialog wizard to choose the folder where you cloned the project and click on open.
3.  Android Studio imports the projects and builds it for you.
4.  Add TheMovieDb API Key inside app level `build.gradle.kts` file.
5.  Enable Youtube Data API v3 to view trailers

```
API_KEY="tmdb-api-key"
YOUTUBE_API="google-api-key"
```

## Contribute

If you want to contribute to this app, you're always welcome!
See [Contributing Guidelines](CONTRIBUTING.md).

## 📝 License
This project is released under the MIT license.
See [LICENSE](./LICENSE) for details.

```
MIT License

Copyright (c) 2020 Mbuodile Obiosio

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```