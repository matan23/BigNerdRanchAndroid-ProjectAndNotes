##Buildconfig

##What are intents

##Explicit  vs implicit intent

##onActivityResult(int requestCode, int resultCode, Intent data) 
	- used with Activity.setResult()
	- resultCode inform success or failure of the activity result, it is a return code returned by the called activity this usually CANCEL or OK but can also be a custom code set by the user (starting from RESULT_FIRST_USER + 1)
		- if user presses back button without using setResult, the result code will be activity canceled (CANCEL)
	- requestCode identify an activity which will be used for both startActivity and onActivityResult

##Backstack
