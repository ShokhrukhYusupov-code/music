# 🎵 Music

Android music application built with **Kotlin** and **Jetpack Compose**.

The project is currently under active development and serves as a foundation for a modern Android music application.

## 🛠 Tech Stack

* **Kotlin**
* **Jetpack Compose**
* **Material 3**
* **Navigation Compose**
* **Hilt** — dependency injection
* **DataStore** — local data persistence
* **Kotlin Serialization**
* **Coroutines & Flow**
* **KSP**
* **Gradle Kotlin DSL**
* **AndroidX**
* **WebView**

## ✨ Current Features

The project currently includes the application's basic architecture and infrastructure:

* 🎨 Jetpack Compose UI
* 🧩 Material 3 design system
* 🧭 Compose Navigation
* 💉 Dependency injection with Hilt
* 💾 Local persistence with DataStore
* 🔄 Reactive state with Kotlin Coroutines and Flow
* 🌐 WebView integration
* 🌙 Application theming
* 📱 Edge-to-edge UI
* 🚀 Android Splash Screen
* 🏗 Layered project structure

## 🌐 WebView

The application includes **WebView** support for displaying web-based content directly inside the Android application.

This allows the project to combine native Android UI built with Jetpack Compose with web content when necessary.

WebView can be useful for:

* displaying web pages inside the application;
* integrating web-based music services;
* displaying content that does not require a native Compose implementation;
* gradually migrating web functionality to native Android screens.

## 🏗 Architecture

The project is organized into separate layers to keep UI, application logic and data-related functionality isolated.

```text
app/
└── src/
    └── main/
        └── java/
            └── com/
                └── shokhrukhyusupov/
                    └── music/
                        ├── core/
                        │   ├── navigation/
                        │   └── ui/
                        │       └── theme/
                        │
                        ├── data/
                        │
                        ├── domain/
                        │   └── managers/
                        │
                        └── presentation/
                            └── main/
```

The project is designed to keep platform-independent application logic separate from the presentation layer.

## 🧭 Navigation

Navigation is implemented using **Navigation Compose**.

Application routes are represented through a centralized route structure rather than being scattered throughout individual screens.

```text
App
│
├── Login
│
└── Main
    └── Home
```

This structure makes it easier to expand the application as new screens are added.

## 💉 Dependency Injection

The project uses **Hilt** for dependency injection.

Hilt is responsible for providing application dependencies and keeping object creation outside of UI components.

Example:

```kotlin
@AndroidEntryPoint
class MainActivity : ComponentActivity()
```

This allows dependencies to be injected into the appropriate Android components without manually creating them.

## 💾 Local Storage

The project uses **Jetpack DataStore** for persistent local data.

DataStore provides asynchronous and coroutine-friendly storage and is used instead of the legacy `SharedPreferences` API.

## 🎨 UI & Theming

The UI is completely based on **Jetpack Compose**.

The project uses **Material 3** as the foundation of its design system.

The UI architecture is built around:

* Compose
* Material 3
* custom application theme
* Compose state
* Kotlin Flow
* Android edge-to-edge APIs

## 📱 Android Configuration

The application targets modern Android versions while maintaining compatibility with older supported devices.

Current configuration includes:

* **Compile SDK:** 37
* **Target SDK:** 37
* **Minimum SDK:** 24

## 🚀 Getting Started

### Clone the repository

```bash
git clone https://github.com/ShokhrukhYusupov-code/music.git
```

### Open the project

Open the cloned project in **Android Studio**.

Allow Android Studio to complete Gradle synchronization and download the required dependencies.

### Run

Connect an Android device or start an emulator and run the application from Android Studio.

Alternatively:

```bash
./gradlew installDebug
```

## 🔨 Build

### Debug

```bash
./gradlew assembleDebug
```

The APK will be generated in:

```text
app/build/outputs/apk/debug/
```

### Release

```bash
./gradlew assembleRelease
```

Release builds require the appropriate signing configuration before distribution.

## 🧪 Testing

Run unit tests:

```bash
./gradlew test
```

Run instrumented Android tests:

```bash
./gradlew connectedAndroidTest
```

## 📦 Project Structure

### `core`

Shared application infrastructure:

* navigation;
* UI;
* theme;
* common functionality.

### `data`

Data-related implementations and persistence.

### `domain`

Application-level logic and abstractions.

### `presentation`

UI and presentation-related functionality.

## 🗺 Roadmap

The following functionality can be added as the project evolves:

* [ ] Music catalog
* [ ] Music search
* [ ] Music playback
* [ ] Audio player
* [ ] Background playback
* [ ] Media notification
* [ ] Playlists
* [ ] Favorites
* [ ] Music history
* [ ] Offline music
* [ ] Download management
* [ ] Improved WebView integration
* [ ] Player controls
* [ ] Improved animations
* [ ] More Compose screens
* [ ] Unit and UI test coverage

## 📌 Status

🚧 **Work in Progress**

The application is actively being developed. APIs, architecture, UI and functionality may change during development.

## 👨‍💻 Author

**Shokhrukh Yusupov**

GitHub:
https://github.com/ShokhrukhYusupov-code

## 📄 License

This project is licensed under the **Apache License 2.0**.

See [`LICENSE`](LICENSE) for more information.

---

⭐ If you like the project, consider giving it a star.
