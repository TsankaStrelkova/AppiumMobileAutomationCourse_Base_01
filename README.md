**First steps to set the project**

This is a project created based on lectures 1-140 from the course https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/
* Create project 
* Add to git ignore .idea/ 
* Add java client dependency 

**Important:** _No need for more dependencies (as Selenium) if the class for driver session creation is in /src/test/java
If the code is not in the test package you need to add and selenium dependencies_

**Important:**  You have 2 ways to create driver - using DesiredCapabilities or using Options
                For Android app if you like to start app , you can use capability to start it
                There is a second option to call a specific package and specific activity

If you like to open specific app package and app activity or you are in case when Appium can't retrieve appPackage and appActivity
from manifest.xml , you need to appPackage and appActivity to desired capabilities

How to take App package  and App activity

Run app - it needs to be on focus
Then execute in the terminal

adb shell dumpsys window | grep -E mCurrentFocus

Then use them in 


The result is something like this:
mCurrentFocus=Window{55a399e u0 io.appium.android.apis/io.appium.android.apis.ApiDemos}

Here: app package is on the beggining (io.appium.android.apis)
app activity is after it.   (o.appium.android.apis.ApiDemos)

**Native locator strategies**

Android -  https://developer.android.com/reference/androidx/test/uiautomator/BySelector
iOS - https://learnautomation.medium.com/improving-appium-ios-automation-performance-by-replacing-xpaths-1f5d0217d9a , https://appium.github.io/appium-xcuitest-driver/4.19/ios-predicate/

**Mobile gestures automation**
Android - https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
iOS - https://appium.readthedocs.io/en/latest/en/writing-running-appium/ios/ios-xctest-mobile-gestures/


**Interacting with apps** - install, activate, remove, put in background, uninstall, take state
iOS -  https://appium.readthedocs.io/en/latest/en/writing-running-appium/ios/ios-xctest-mobile-apps-management/
       https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/ lecture 118
Android - https://github.com/appium/appium-uiautomator2-driver (Platform-Specific Extensions)
          https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/ lecture 121
