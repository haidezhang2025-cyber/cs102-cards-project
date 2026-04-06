#!/bin/bash
javac --module-path linuxOSX64/lib  --add-modules javafx.controls,javafx.fxml -d classes $(find src -name "*.java")
cp -a src/UI/ classes/UI/
java --module-path linuxOSX64/lib --add-modules javafx.controls,javafx.fxml --enable-native-access=javafx.graphics -cp classes UI.GameApp
