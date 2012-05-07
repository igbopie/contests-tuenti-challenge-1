#!/bin/bash
cd ..
tar -cvzf source_pkg.tgz src
mv source_pkg.tgz tuenticmd/
cd bin
PATH_TO_SUBMIT=./../../tools-unix/submit_challenge
SOURCE=../tuenticmd/source_pkg.tgz
TOKEN=GiN1LeqO_BsOT2gwT7wS
EXECUTE="java net.tuenti.contest.igbopie.theclock.TheClock"
$PATH_TO_SUBMIT $TOKEN $SOURCE $EXECUTE