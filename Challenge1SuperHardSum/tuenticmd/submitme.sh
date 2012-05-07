#!/bin/bash
cd ..
tar -cvzf source_pkg.tgz src
mv source_pkg.tgz tuenticmd/
cd bin
PATH_TO_SUBMIT=./../../tools-unix/submit_challenge
SOURCE=../tuenticmd/source_pkg.tgz
TOKEN=hDdX_VmgL3b-6vcwT7wS
EXECUTE="java net.tuenti.contest.igbopie.superhardsum.SuperHardSum"
$PATH_TO_SUBMIT $TOKEN $SOURCE $EXECUTE