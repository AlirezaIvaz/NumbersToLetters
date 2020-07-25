# Persian Numbers to Letters Converter &nbsp;&nbsp;[![](https://jitpack.io/v/ir.alirezaivaz/NumbersToLetters.svg)](https://jitpack.io/#ir.alirezaivaz/NumbersToLetters)
With this simple library can convert numbers to Persian letters.
## How to use
1. Add [JitPack](https://jitpack.io/) to your build file
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

2. Add the gradle dependency
```gradle
dependencies {
  implementation 'ir.alirezaivaz:NumbersToLetters:1.0'
}
```

3. Convert numbers

**Java:**
```java
PersianNumbersToLettersConverter pntlc = new PersianNumbersToLettersConverter();
String resultString = pntlc.getParsedString("123456789");
```
**Kotlin:**
```kotlin
val pntlc = PersianNumbersToLettersConverter()  
val resultString = pntlc.getParsedString("123456789")
```
5. Enjoy it!

## Notes

> This library supports 63 numbers. If you try to enter more than, the library returns empty!

## Author
Library by **[Alireza Ivaz](https://alirezaivaz.ir)**

## Thanks from
* **[Mehran Shomali](http://mshomali.ir)** for base *PHP* code
* **[Saeid Raei](https://saeid.me)** for convert *PHP* code to *Java*
