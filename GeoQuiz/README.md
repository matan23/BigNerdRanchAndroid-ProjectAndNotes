###Views and XML
* diff between px dp dip and sp : http://stackoverflow.com/questions/2025282/difference-between-px-dp-dip-and-sp-in-android
* diff between frameLayout and relativeLayout: http://stackoverflow.com/questions/11613193/difference-between-frame-and-relative-layout
* diff between gravity and layout gravity: http://stackoverflow.com/questions/3482742/gravity-and-layout-gravity-on-android
* on android and google xml namespace: http://stackoverflow.com/questions/5404560/android-xml-layout-files-and-namespace


###Activities
* How do activity get their View?
	* What does the setContentView do?
		* implicit inflation and explicit inflation (through LayoutINflater)
* How do XML elements become View objects?
* What is AppCompatActivity?
* diff between onCreate and onCreateView: 
	* onCreate(Bundle) is where you initialize your activity. Most importantly, here you will usually call setContentView(int) with a layout resource defining your UI, and using findViewById(int) to retrieve the widgets in that UI that you need to interact with programmatically.
	* onCreateView Hook you can supply that is called when inflating from a LayoutInflater. You can use this to customize the tag names available in your XML layout files.
* How are resouces generated and what is the R class: app/build/generated/source/r/debug/com/bignerdranch/android/geoquiz/R.java
	* the inner class Layout has the list of integer representing layouts defined in res/layout/*.xml
	* the inner class String has the list of integer representing strings defined in res/values/strings.xml

###Event Driven Programming
* How do event works in android? http://stackoverflow.com/questions/17964835/how-do-androids-event-listeners-work, http://android-developers.blogspot.co.uk/2009/05/painless-threading.html

###Context
__Memory leaks issues in Android applications and they are most of the time due to the same mistake: keeping a long-lived reference to a Context.__
* What is it? ` Context is used for many operations but mostly to load and access resources. This is why all the widgets receive a Context parameter in their constructor` -> https://possiblemobile.com/2013/06/context/
* When to pass activity vs application? -> Avoid Memory Leaks (`"leak" meaning you keep a reference to it thus preventing the GC from collecting it`)
	* http://stackoverflow.com/questions/4128589/difference-between-activity-context-and-application-context
	* http://android-developers.blogspot.cz/2009/01/avoiding-memory-leaks.html

###Android Build Process
-> Read page 30
