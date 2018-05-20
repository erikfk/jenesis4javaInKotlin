# jenesis4javaInKotlin

current status<br>
[![Build Status](https://travis-ci.com/erikfk/jenesis4javaInKotlin.png)](https://travis-ci.com/erikfk/jenesis4javaInKotlin)

"Reboot" of jenesis 4 Java written in Kotlin

This project is meant to be (someday, in an undefined future) a rewrite of the SourceForge project jenesis4java - http://jenesis4java.sourceforge.net/

The core problem with jenesis4java from my point of view is that its architecture is fundamentally broken - consider the weird class hierarchies for example... This makes it very unpleasant to extend. It also has very few test cases and writing new tests after the fact for rather bad code in a bad architecture is just painful and frustrating.

Rewriting jenesis4java from scratch therefore seems to me not only the best but actually the only viable solution.

Writing the new jenesis4java in Kotlin seems like a good choice as of this writing as Kotlin is a modern and powerful JVM language far less verbose than Java that offers interoperability with Java. On an other (more personal) side: my first contact with Kotlin has been quite pleasant so I wanted to use it in a real project. For reasons beyond the scope of this README, using it to write a new jenesis4java was a rather obvious choice. So here am I.

The (i.e. my) main challenge is that I'm a notorious procrastinator - it took me two weeks to actually create this repository... - and that things I do seem to take an excessively long time. That I talk too much instead of writing working code is a related weakness, as you rightly guessed while reading these lines.

I nevertheless hope that things will start to speed up at one time or another and the project and its code will actually deliver useful functionality.

I intend to start small by concentrating on certain aspects of the Java code generation, like covering the whole spectrum of Java class generation including Generics (which jenesis4java doesn't cover as of this writing, forcing you to use String concatenation to generate class using generics). When this goal is achieved, we'll see...

I intend to use the nomenclature found in the Java Language Specification when it comes to naming elements of the Java language in  jenesis4javaInKotlin - also here jenesis4java took weird decisions probably in the early days of the project and I want to get rid of that past.

I would like to keep the (relative) simplicity of use found in jenesis4java but improve it where possible to make code generating Java code simple to write and easy to read. Hopefully using a test driven approach that will force me to eat my own dog food from day one will help me stick to that goal.

If things go well (I mean far better than I can imagine while writing these lines) I will take a look at the possibility to define a DSL in Kotlin to generate the Java code.

But we'll see where the journey actually takes me. This is just day one and time will begin to fly fast from here.

BTW: jenesis4javaInKotlin is an ugly and uninspired name. Hopefully some kind of muse will kiss me and provide me with an inspiration for a better name...
