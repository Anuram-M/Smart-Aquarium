# Smart-Aquarium

<div align="center">

<!-- BANNER / LOGO -->
<img src="https://placehold.co/900x280/0A0A0A/00C853?text=SMART-AQUARIUM-HUB&font=montserrat" alt="App Banner" width="100%" style="border-radius: 10px;" />

<br/>
<br/>

<!-- BADGES -->
![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Language](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Min SDK](https://img.shields.io/badge/Min%20SDK-24-00C853?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-FFC107?style=for-the-badge)
![Build](https://img.shields.io/badge/Build-Passing-00C853?style=for-the-badge)

<br/>

### 🚀 *For controlling/monitoring your aquarium through Mobile.*

[**Report Bug**](../../issues)  ·  [**Request Feature**](../../issues)

</div>

---

## 📋 Table of Contents

- [About](#-about)
- [Visuals](#-visuals)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Installation](#-installation)

---

## 🧭 About

> **Smart-Aquarium-Hub** is an Android application built with Kotlin and Jetpack Compose that connects with an ESP8266 MicroController board through the MQTT protocol. After a successful handshake with the HiveMQ server, it subscribes to the topics created for handling/monitoring aquarium-related components connected with the MicroController board. Right now, the control is only established for controlling the power cycles of a few pieces of equipment connected through a relay module with the MicroController.

---

## 🎬 Visuals

<div align="center">

| Home |
|:-----------:|
| <img src="assets/location_permission.png" width="220"/> |

</div>

---

## ✨ Features

| Feature | Description |
|---|---|
| 🎮 **Controlling power cycles** | Through MQTT topic subscription, the state of the equipment's power connection is controlled |
| 🛜 **History of power cycles** | Using Room DB for storing power cycles' history (In Progress) |

---

## 🛠 Tech Stack

<div align="center">

| Layer | Technology |
|---|---|
| **Language** | ![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=kotlin&logoColor=white) |
| **UI** | ![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=flat-square&logo=jetpackcompose&logoColor=white) |
| **Architecture** | `MVVM` + `Clean Architecture` |
| **Navigation** | `Compose Navigation` |
| **Build** | ![Gradle](https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=gradle&logoColor=white) with `Version Catalogs` |

</div>

---

## 📦 Installation

### Prerequisites

- Android Studio **Hedgehog** (2023.1.1) or newer
- JDK **17**
- Android SDK with **API Level 24+**
- A device or emulator running **Android 7.0 (Nougat)** or above

### Clone & Build

```bash
# 1. Clone the repository
git clone "repo remote url."

# 2. Navigate to the project directory
cd app_name

# 3. Open in Android Studio
# File → Open → select the project folder

# 4. Sync and Test
Sync Gradle and run it
If there is any error, verify the cause in the console
```

```bash
# Or build directly from the command line
./gradlew assembleDebug
```

### Download APK

| Version | Date | Download |
|---|---|---|
| `v1.0` | Coming soon | [![APK](https://img.shields.io/badge/Download-APK-3DDC84?style=for-the-badge&logo=android)](../../releases) |

---

> Have an idea? [Open a feature request](../../issues/new) — contributions are welcome!

---

## 📄 License

```
MIT License

Copyright (c) 2026 Your Name

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including, without limitation, the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software.
```

---

<div align="center">

Made with ❤️ using **Kotlin** & **Jetpack Compose**

⭐ If this project helped you, consider giving it a star!

</div>
