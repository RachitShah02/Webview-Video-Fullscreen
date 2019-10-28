# Webview-Video-Fullscreen
Enable full screen mode of videos in webview android
[![](https://jitpack.io/v/RachitShah02/Webview-Video-Fullscreen.svg)](https://jitpack.io/#RachitShah02/Webview-Video-Fullscreen)

## Installation
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ``` 
 
Step 2. Add the dependency

  ```dependencies
  dependencies {
	        implementation 'com.github.RachitShah02:Webview-Video-Fullscreen:1.0.2'
	}
```

## Usage

Define Custom Webview in layout xml

```xml
<com.gurudev.fullscreenvideowebview.FullScreenVideoWebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

Access in activity simple as webview

```java
FullScreenVideoWebView fullScreenVideoWebView = findViewById(R.id.webView);
fullScreenVideoWebView.loadUrl("https://m.youtube.com"); \\ Replace with your website url
```
And in Manifests File add configChanges="orientation" to your activity

```xml
<activity android:name=".MainActivity"
    android:configChanges="orientation">
</activity>
```
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
