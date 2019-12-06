Aysnc Task Loader
If we are using API calls and mean while device is rotated than API call which is exectuting in thread would get the results and deliver those results to that activity which is being destroyed (when a device is rotated than activity gets killed and than recreated with new orientations), and in worst case an new API call would be made get the data, and thus more thread would be created, thus to deal with this we use "Loaders", which solves the lifecycle problem

Why use an AsyncTaskLoader for threads bound to an Activity rather than AsyncTask?
AsyncTaskLoader will deliver the result to the current active Activity
AsyncTaskLoader prevents duplication of background threads
AsyncTaskLoader helps eliminate duplication of zombie activities

###
Launch mode ="single top" in activity manifest file make sure that activity is not created again when control pass back to activity after the intent

###
When dealing with databases, it is better to have a contract which defines what the database is and how it looks like.
When the database is changes then change the contract too. Working with db along with contracts is damn easy, insertion in database, deletion

###
Content Providers
They are used to make two apps share the data, like scanning business card and storing the information to default calling app
An Android should know four key app components : activity, Services, Broadcast Receivers and content Providers