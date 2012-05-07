#!/bin/bash
cd ..
tar -cvzf source_pkg.tgz src
mv source_pkg.tgz tuenticmd/
cd bin
PATH_TO_SUBMIT=./../../tools-unix/submit_challenge
SOURCE=../tuenticmd/source_pkg.tgz
TOKEN=P8OqtDInvXUdhH8wT7wS
EXECUTE="java net.tuenti.contest.igbopie.emirps.Emirps"
$PATH_TO_SUBMIT $TOKEN $SOURCE $EXECUTE