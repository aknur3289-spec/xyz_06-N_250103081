# Proxy & Bridge

Completed Java lab based on `proxy_boilerplate.zip` and `bridge_boilerplate.zip`.
Original supplied files and the Proxy diagram are preserved under `boilerplate/`.

| Folder | Contents |
| --- | --- |
| task1-image-proxy | Task 1: role check before lazy loading the image |
| task2-video-proxy | Task 2: view counter and lazy video loading |
| task3-firewall | Task 3: school Internet protection proxy |
| tasks4-5-device-bridge | Tasks 4-5: original TV/Radio/remote classes plus SmartLight and PartyRemote |
| task6-weapon-bridge | Task 6: Knight/Wizard with Sword/MagicWand |
| example-message-bridge | Original runnable message/sender Bridge example |
| boilerplate | Unmodified files from both supplied archives |

Each example has its own Main.java because the supplied examples reuse class names.
Compile and run one folder at a time, for example:

```cmd
cd task1-image-proxy
javac -d bin Main.java
java -cp bin Main
```

Repeat for the other example folders. Each contains expected-output.txt.
The files under boilerplate are reference originals: their public Main classes
require renaming the source to Main.java before compiling, so run the prepared
example folders above instead.
