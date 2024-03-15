# commonmark-java-test

Test project using jlink together with [commonmark-java].

Build like this:

    mvn clean package

Then run the jlink-built binary like this:

    ./target/maven-jlink/default/bin/commonmark < README.md


[commonmark-java]: https://github.com/commonmark/commonmark-java
