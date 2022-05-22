Moon.class:	Moon.java MoonCalc.class
	javac Moon.java

MoonCalc.class:	MoonCalc.java
	javac MoonCalc.java

clean:	
	rm -f *~ \#* *.class
