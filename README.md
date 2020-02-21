```
mvn clean compile
cd target/classes/
java org.example.App
```

Output:

```
Hello World!
0:      This is a value
1:      This is a value
2:      This is a value
3:      This is a value
4:      new value
```

Then edit `target/classes/demo.properties`. The console output get updated until `20` and then it won't.
