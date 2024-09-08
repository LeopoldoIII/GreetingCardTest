## Just to test androidx.test.espresso

### Notes

 Issues with unauthorized 
 
    ➜  ~ adb devices
    List of devices attached
    emulator-5554	unauthorized
    emulator-5562	offline

To fix just run 

    rm -fr  ~/.android/adbkey*



use full adb commands 


    adb kill-server
    adb start-server
    adb -s emulator-5554 emu kill
    adb -s emulator-5554 reboot
