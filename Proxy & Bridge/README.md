# Proxy & Bridge - Tasks 1-6

All six worksheet tasks are completed using plain Java without external libraries.
Tasks 1 and 2 extend the supplied Proxy examples; Tasks 4 and 5 extend the supplied
device/remote Bridge example. Tasks 3 and 6 implement the worksheet mini-challenges.

## Tasks

| Task | Exercise | Source file |
| --- | --- | --- |
| Task 1 | The Bouncer: ADMIN/GUEST image protection and lazy loading | [Main.java](<task1-image-proxy/Main.java>) |
| Task 2 | The View Counter: audit counter and lazy video loading | [Main.java](<task2-video-proxy/Main.java>) |
| Task 3 | School Wi-Fi Firewall: block gaming.com and socialmedia.com | [Main.java](<task3-firewall/Main.java>) |
| Task 4 | The New Machine: SmartLight with AdvancedRemote | [Main.java](<tasks4-5-device-bridge/Main.java>) |
| Task 5 | The New Button: PartyRemote with Radio at volume 100 | [Main.java](<tasks4-5-device-bridge/Main.java>) |
| Task 6 | RPG Weapon System: Knight/Wizard with Sword or MagicWand | [Main.java](<task6-weapon-bridge/Main.java>) |

Tasks 4 and 5 share one Main.java and are labeled separately in its main method.
Every task example includes expected-output.txt for checking the console output.

## Run

From the repository root, choose one task folder:

```cmd
cd "Proxy & Bridge/task1-image-proxy"
javac -d bin Main.java
java -cp bin Main
```

For another task, open a terminal in its folder and run the same javac and java
commands. Run each example separately because the examples reuse class names.

## Supplied boilerplate

- boilerplate/proxy_boilerplate/: original proxy_1moodle.java, proxy_2moodle.java and Proxy class diagram.
- boilerplate/bridge_boilerplate/: original bridge_1.java and bridge_2.java.
- example-message-bridge/: runnable copy of the original message/sender Bridge example.

Original files are preserved unchanged. Their public Main classes require the
filename Main.java to compile; use the prepared example folders above.
