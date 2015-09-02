#Maven

####FragmentManager
	- handles two things
		1. list of fragments
		2. back stack of fragment transactions
	- findFragmentById(_container view id_)
		- find fragment that are currently added to the manager's _activity_ if not found search through the backstack of the FM
			- why would a fragment already be in the list?
				- FragmentManager persist fragments when activity get destroyed (only in rotation?) if an activity get recreated due to a rotation the FM will still have a reference to the fragment so that it can restore it
		- container view id will typically be the placeholder id, identifying a fragment by the ID of its container is built into how the FM operates
		- container view id serves two purposes:
			1. tell the FM where in the activity's view the fragment should appear
			2. it is used as a unique identifier for a fragment in the FM list of fragments

####FragmentActivity
####Fragment Lifecycle
	- activities need to manually call the fragment callbacks
	- fragment lifecycle need to match activity lifecycle (fragment lifecycle callbacks are public and so can be called from outside)
	- onCreate do not inflate the fragment's view, instead it is configured in onCreateView where this method will return the view of the fragment
	- diff between onCreate and onCreateView: http://stackoverflow.com/questions/28929637/difference-and-uses-of-oncreate-oncreateview-and-onactivitycreated-in-fra
	- onAttach?
	- onDetach?
	- onCreateView?

###Activities host fragment
####Hosting a Fragment
	- Define a placeholder in the Activity layout for the fragment's view
	- Inject the fragment via activity code so that we can dynamically manage the placeholder
	- Manage the lifecycle of the fragment instance (fragment lifecycle callbacks are public and so can be called from outside)

UI Fragment need to be hosted inside of an activity to display its view
What about Non-UI Fragment?	

difference between appcompat and androidsupport?
	http://stackoverflow.com/questions/18271429/difference-between-android-support-v7-appcompat-and-android-support-v4
