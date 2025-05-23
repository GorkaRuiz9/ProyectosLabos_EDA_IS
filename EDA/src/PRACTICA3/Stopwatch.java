package PRACTICA3;

public class Stopwatch {
	 private final long start;
	 /** Create a stopwatch object. */
	 /* For additional documentation, see
	 * http://introcs.cs.princeton.edu/32class Section 3.2 of
	 * Introduction to Programming in Java: An Interdisciplinary
	 Approach
	 * by Robert Sedgewick and Kevin Wayne. */
	 public Stopwatch() {
	 start = System.currentTimeMillis();
	 }
	 /** Return elapsed time (in seconds) since this object was created. */
	 public double elapsedTime() {
	 long now = System.currentTimeMillis();
	 return (now - start) / 1000.0;
	 }
	}