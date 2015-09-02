##Buildconfig

##What are intents
	- Communication component that describes an action to be performed
	- Communicate with the Activity Manager
	- Broadcast Intent
	- Communicate with a background Service
	- What happens when we start an activity via an intent?
		1. An intent is sent to the activity manager
		2. The Activity Manager send back the intent to the targeted activity 
	- Services, Activities etc.. need to be declared in the _Manifest_ this is how the ActivityManager knows the existence of our components


##Explicit vs implicit intent
	- Explicit Intent
		- Start Component within our application
	- Implicit Intent
		- Start Component outside of our application

##onActivityResult(int requestCode, int resultCode, Intent data) 
	- used with Activity.setResult()
	- resultCode inform success or failure of the activity result, it is a return code returned by the called activity this usually CANCEL or OK but can also be a custom code set by the user (starting from RESULT_FIRST_USER + 1)
		- if user presses back button without using setResult, the result code will be activity canceled (CANCEL)
	- requestCode identify an activity which will be used for both startActivity and onActivityResult

##Backstack
- ActivityManager manages a stack of running activities
- Activities for all applications share the same back stack
	- Thus when pressing back you can end up in a previous app
	- That is why ActivityManager lives with the OS and not inside our app, because it manages activities of all apps


##Versions Compability
- Running code from multiple SDK levels
	- check for os version before executing newest APIs: Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
	- use linter to check compatibility of apis
	- if running higher api on lower device the app will crash
- Setting the correct SDK
	- CompilerSDK should always be the oldest
	- TargetSDK should be the latest supported
	- MinSDK is the lowest version supported
