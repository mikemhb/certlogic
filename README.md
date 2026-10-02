# CertLogic Pro prototype

Click-through Android prototype (WebView wrapper around `app/src/main/assets/index.html`).

Flow: Log in screen -> "Create an account" -> "Create account" -> "16 Hatfield Gate" -> avatar menu.

## Getting the APK
Push to the branch or run the **Build APK** workflow in GitHub Actions, then download the
`CertLogicPro-apk` artifact. Locally: `gradle :app:assembleRelease` (needs the Android SDK).
The APK is signed with the debug key, so enable "install unknown apps" on the phone to sideload it.
