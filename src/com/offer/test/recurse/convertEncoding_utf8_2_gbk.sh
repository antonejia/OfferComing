#!/bin/sh

for file in `find ./ -name "*.java"`;
do
echo convering : $file
iconv -f utf-8 -t gbk $file > $file.t
mv $file.t $file
done
echo DONE
