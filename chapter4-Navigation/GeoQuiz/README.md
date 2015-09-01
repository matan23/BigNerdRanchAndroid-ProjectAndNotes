##Buildconfig

##What are intents

##Explicit  vs implicit intent

##onActivityResult(int requestCode, int resultCode, Intent data) 
	- used with Activity.setResult()
	- resultCode inform success or failure of the activity result, it is a return code returned by the called activity this usually CANCEL or OK but can also be a custom code set by the user (starting from RESULT_FIRST_USER + 1)
		- if user presses back button without using setResult, the result code will be activity canceled (CANCEL)
	- requestCode identify an activity which will be used for both startActivity and onActivityResult

##Backstack


##Versions Compability
- Running code from multiple SDK levels
	- check for os version before executing newest APIs: Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
	- use linter to check compatibility of apis
	- if running higher api on lower device the app will crash
- Setting the correct SDK
	- CompilerSDK should always be the oldest
	- TargetSDK should be the latest supported
	- MinSDK is the lowest version supported
