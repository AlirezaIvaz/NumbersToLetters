# Persian Numbers to Letter Converter

[![](https://jitpack.io/v/ir.alirezaivaz/numberstoletters.svg)](https://jitpack.io/#ir.alirezaivaz/numberstoletters)
[![Apache2](http://img.shields.io/badge/license-APACHE2-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![API 21](https://img.shields.io/badge/Min%20API-14-brightgreen)](https://developer.android.com/about/versions/lollipop)
[![Kotlin 1.8.0](https://img.shields.io/badge/Kotlin-1.8.0-blueviolet)](https://kotlinlang.org)
[![Issues](https://img.shields.io/github/issues/AlirezaIvaz/NumbersToLetters)](https://github.com/AlirezaIvaz/NumberToLetters/issues)

This simple library converts numbers to Persian letters.

You can download demo application from [here](https://github.com/AlirezaIvaz/NumbersToLetters/raw/master/app/release/app-release.apk).

## Adding to your project

### 1. Adding the library repository

If you're using the old project structure, add **JitPack** in your root `build.gradle` or `build.gradle.kts` file like this:

<details>
<summary><code>build.gradle</code></summary>

```groovy
allprojects {
    repositories {
        ...
        maven {
            url 'https://jitpack.io'
        }
    }
}
```

</details>

<details open>
<summary><code>build.gradle.kts</code></summary>

```kotlin
allprojects {
    repositories {
        ...
        maven("https://jitpack.io")
    }
}
```

</details>

Otherwise if you're using new project structure, add **JitPack** in your `settings.gradle` or `settings.gradle.kts` like this:

<details>
<summary><code>settings.gradle</code></summary>

```groovy
dependencyResolutionManagement {
    ...
    repositories {
        ...
        maven {
            url 'https://jitpack.io'
        }
    }
}
```

</details>

<details open>
<summary><code>settings.gradle.kts</code></summary>

```kotlin
dependencyResolutionManagement {
    ...
    repositories {
        ...
        maven("https://jitpack.io")
    }
}
```

</details>

### 2. Adding the library dependency

Now add the library dependency in your application module `build.gradle` or `build.gradle.kts` file like this:

<details>
<summary><code>build.gradle</code></summary>

```groovy
dependencies {
    ...
    def numbersToLetters = "2.0.0" // You can find the latest version from releases page
    implementation "ir.alirezaivaz:numberstoletters:$numbersToLetters"
}
```

</details>

<details open>
<summary><code>build.gradle.kts</code></summary>

```kotlin
dependencies {
    ...
    val numbersToLetters = "2.0.0" // You can find the latest version from releases page
    implementation("ir.alirezaivaz:numberstoletters:$numbersToLetters")
}
```

</details>

## Usage
Simply create an object from `PersianNumbersToLettersConverter` class and call
`getParsedString()` function and pass your number as string to that function.

<details>
<summary><b>Java</b></summary>

```java
PersianNumbersToLettersConverter converter = new PersianNumbersToLettersConverter();
Int number = 123456789;
String inputNumber = Integer.toString(number);
String result = converter.getParsedString(inputNumber);
```

</details>

<details open>
<summary><b>Kotlin</b></summary>

```kotlin
val converter = PersianNumbersToLettersConverter()
val number = 123456789
val result = converter.getParsedString("$number")
```

</details>

## Notes

> This library supports 63 numbers. If you try to enter more than, the library returns error!

## Author
Library by **[Alireza Ivaz](https://github.com/AlirezaIvaz)**

## Thanks
* **[Mehran Shomali](http://mshomali.ir)** for base *PHP* code
* **[Saeid Raei](https://saeid.me)** for convert *PHP* code to *Java*

## Changelog
You can see full changelog from [here](CHANGELOG.md).

## License
Copyright 2016-2020 Saeid Raei
Copyright 2017-2020 Alireza Ivaz

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
