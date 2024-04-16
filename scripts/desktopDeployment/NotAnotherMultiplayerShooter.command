#!/bin/bash
DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
cd "${DIR}"
./jre/Contents/Home/bin/java -XX:MaxRAMPercentage=60 -XstartOnFirstThread -classpath "lib/*" io.github.avacadowizard.notanothermultiplayershooter.NotAnotherMultiplayerShooter
exit 0
