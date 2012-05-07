#!/bin/bash
cd ..
tar -cvzf source_pkg.tgz src
mv source_pkg.tgz tuenticmd/
cd bin
PATH_TO_SUBMIT=./../../tools-unix/submit_challenge
SOURCE=../tuenticmd/source_pkg.tgz
TOKEN=lEW5zzDs845BIAAwT7wS
EXECUTE="java net.tuenti.contest.igbopie.taskduration.TaskDuration ../tuenticmd/in"
$PATH_TO_SUBMIT $TOKEN $SOURCE $EXECUTE