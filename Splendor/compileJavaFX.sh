#!/bin/bash
javac --module-path /Users/edensng/javafx-sdk-26/lib  --add-modules javafx.controls,javafx.fxml -d classes $(find src -name "*.java")
cp -a src/UI/ classes/UI/
