#!/bin/bash
cd ..
tar -cvzf source_pkg.tgz src
mv source_pkg.tgz tuenticmd/
cd bin
PATH_TO_SUBMIT=./../../tools-unix/submit_challenge
SOURCE=../tuenticmd/source_pkg.tgz
TOKEN=sokX3jEiwbzi9okwT7wS
EXECUTE="java net.tuenti.contest.igbopie.therobot.TheRobot"
$PATH_TO_SUBMIT $TOKEN $SOURCE $EXECUTE