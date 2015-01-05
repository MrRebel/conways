#!/bin/bash

LWSS="(2,2) (4,2) (5,3) (5,4) (2,5) (5,5) (3,6) (4,6) (5,6)"

echo "Compiling..." &&
javac *.java &&
echo "Running..." &&
java Conways $LWSS
