# Project to prove OpenJdk bug: JDK-8222754

The aim of this project is to prove the bug: JDK-8222754 for OpenJdk 11.0.3 (and previous versions)

In order to test it, set the JDK version to 11.0.3 (or previous version), for example:
```shell script
export JAVA_HOME=`/usr/libexec/java_home -v 11.0.2` ; echo $JAVA_HOME
```

and then compile with:
```shell script
gradle clean build
```

It will fail with message:
```shell script
> Task :compileJava FAILED
compiler message file broken: key=compiler.misc.msg.bug arguments=11.0.2, {1}, {2}, {3}, {4}, {5}, {6}, {7}
java.lang.NullPointerException
...
```

In order to make it work, set the JDK version to 11.0.4 (or later version), for example:
```shell script
export JAVA_HOME=`/usr/libexec/java_home -v 11.0.4` ; echo $JAVA_HOME
```

and then compile with:
```shell script
gradle clean build
```

the compilation process will succeed. 