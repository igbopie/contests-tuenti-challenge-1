#!/bin/bash
cd ..
tar -cvzf source_pkg.tgz src
mv source_pkg.tgz tuenticmd/
cd bin
PATH_TO_SUBMIT=./../../tools-unix/submit_challenge
SOURCE=../tuenticmd/source_pkg.tgz
TOKEN=9dswqsSgvXP3H6EwT7wS
EXECUTE="java net.tuenti.contest.igbopie.gasstations.GasStations"
$PATH_TO_SUBMIT $TOKEN $SOURCE $EXECUTE